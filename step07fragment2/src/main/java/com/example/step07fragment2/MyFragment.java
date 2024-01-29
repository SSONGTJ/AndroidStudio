package com.example.step07fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.step07fragment2.databinding.FragmentMyBinding;

/*
    하나의 액티비티는 여러개의 프레그먼트로 구성할 수가 있다.
    액티비티 제어하에 동작하는 미니 액티비티라고 생각하면 된다.
 */
public class MyFragment extends Fragment {
    // 필드
    int count = 0;
    FragmentMyBinding binding;

    public interface MyFragmentListener{
        public void onTen(String msg);
        public void onOrig(String msg);
        public void currentTen(String msg);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //메소드에 전달된 객체를 활용해서 FragmentMyBinding 객체를 얻어낸다.
        binding = FragmentMyBinding.inflate(inflater, container,false);
        binding.textView.setOnClickListener(v->{
            count++;
            binding.textView.setText(Integer.toString(count));
            // 이 프레그먼트를 제어하고 있는 액티비티의 참조값을 얻어와서
            FragmentActivity fa = getActivity();
            // 만일 해당 액티비티가 MyFragmentListener type 이고, count 가 10의 배수라면
            if(fa instanceof MyFragmentListener && count%10 == 0) {
                // MyFragmentListener type 으로 액티비티를 casting 한 다음
                MyFragmentListener listener = (MyFragmentListener) fa;
                // 메소드를 호출하면서 메세지를 전달한다.
                listener.onTen(count + " 입니다!");
                listener.currentTen("최근 값 : "+count);
            } else {
                // MyFragmentListener type 으로 액티비티를 casting 한 다음
                MyFragmentListener listener = (MyFragmentListener) fa;
                // 메소드를 호출하면서 메세지를 전달한다.
                listener.onOrig("10의 배수에서 반응");
            }
        });
        
        //바인딩 객체가 리턴해주는 View 를 리턴해준다.
        return binding.getRoot();
    }

    //리셋 하는 메소드
    public void reset(){
        //카운트 초기화
        count=0;
        binding.textView.setText("0");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}