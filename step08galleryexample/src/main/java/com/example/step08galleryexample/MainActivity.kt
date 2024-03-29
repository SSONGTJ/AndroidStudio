package com.example.step08galleryexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.step08galleryexample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() , OnItemClickListener {
    lateinit var binding:ActivityMainBinding
    lateinit var list:MutableList<GalleryDto>
    lateinit var adapter:GalleryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //모델
        list = mutableListOf<GalleryDto>()
        //ListView 에 연결할 Custom Adapter [라이브러리를 가져다 사용 할 예정]
        adapter= GalleryAdapter(this, R.layout.listview_cell, list)
        //ListView 에 Adapter 연결하기
        binding.listView.adapter=adapter    //binding.listView.setAdapter(adapter)
        //gallery 데이터를 서버로 부터 받아온다.
        lifecycleScope.launch (Dispatchers.Main){
            val url="http://192.168.0.68:9000/boot09/api/galleries"
            // [{"num":x,"writer":"xxx", ...}]
            val json=makeHttpRequest(url)
            // 응답받은 json 문자열을 이용해서 ListView 에 Gallery 출력하기
            printToListView(json)
        }
        //ListView 에 아이템 클릭 리스너 등록
        binding.listView.onItemClickListener = this
    }



    // json 문자열을 파싱해서 ListView 에 정보 출력하기
    fun printToListView (json:String){
        val arr=JSONArray(json)
        //반복문 돌면서
        for(i in 0 until arr.length()){
            // i번째 JSONObject 객체를 얻어와서
            val tmp=arr.getJSONObject(i)
            //GalleryDto 객체에 정보를 담고
            val dto = GalleryDto()
            dto.num = tmp.getInt("num")
            dto.writer = tmp.getString("writer")
            dto.caption = tmp.getString("caption")
            dto.regdate = tmp.getString("regdate")
            dto.imagePath = "http://192.168.0.68:9000/boot09/upload/images/"+
                    tmp.getString("saveFileName")
            //모델에 추가하고
            list.add(dto)
        }
        //모델이 변경되었다고 adapter에 알린다.
        adapter.notifyDataSetChanged()
    }

    suspend fun makeHttpRequest(url:String):String {
        /*
        *   IO(InputOutput) 입출력 처리를 하기에 적합한 스레드를 시작시켜서 작업을 한다.
        *   withContext(){} 블럭 내부는 UI 스레드가 아니다.
        *   블럭의 가장 아랫부분에 남긴 값이 리턴된다.
        */
        val result = withContext(Dispatchers.IO){
            // 여기도 새로운 스레드
            //문자열을 누적할 객체
            //StringBuilder builder = new StringBuilder();
            val builder = StringBuilder();

            try{
                //요청 url을 생성자의 인자로 전달하면서 URL 객체를 생성한다.
                val url = URL(url)
                //URLConnection 객체를 원래 type(자식 type) 으로 casting 해서 받는다.
                val conn = url.openConnection() as HttpURLConnection;
                if(conn != null){
                    conn.setConnectTimeout(20000);  // 응답을 기다리는 최대 대기 시간
                    conn.setRequestMethod("GET");   // 요청 메소드 설정 (Default 는 GET
                    //conn.setUseCaches(false);       // 캐시 사용 여부
                    conn.useCaches=false
                    //응답 코드를 읽어온다.
                    //int responseCode = conn.getResponseCode();
                    val responseCode = conn.responseCode
                    if(responseCode == HttpURLConnection.HTTP_OK) { //정상 응답이라면(200)
                        //문자열을 읽어들일 수 있는 객체의 참조값 얻어오기
                        val br = BufferedReader(InputStreamReader(conn.inputStream));
                        //반복문 돌면서
                        while(true){
                            //문자열을 한줄 씩 읽어 들인다.
                            val line = br.readLine();
                            if(line==null)break;
                            // StringBuilder 객체에 누적시키기
                            builder.append(line);
                        }
                    }
                }

            }catch (e:Exception){
                e.message?.let{ Log.e("MainActivity", it)}
            }//try~catch

            //누적된 문자열이 리턴된다.
            builder.toString()// 이것이 withContext...return 값
        }
        return result
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //ListView 의 아이템을 클릭하면 여기가 호출된다.
        //Java 에서 class type 은 클래스명 . class
        //kotlin 에서 class type 은 클래스명 :: class.java
        intent = Intent(this, DetailActivity::class.java)
        //intent 객체에 DetailActivity 에 전달할 정보를 담는다.
        intent.putExtra("id", id)   // id 라는 키값으로 Long type 을 담는다.
        //액티비티 이동
        startActivity(intent)
    }
}