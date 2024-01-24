package com.example.hellokotlin

class MyUtil{
    // 같은 메소드명으로 메소드를 여러개 정의할 수 있다. ( 매개변수의 모양이 다르면 )
    fun send(){}
    fun send(num:Int){}
    fun send(num:Int,name:String){}
}
class YourUtil{
    // 메소드 오버로딩 느낌을 낼 수 있다.
    fun send(num:Int=0, msg:String=""){}
}
class OurUtil{
    // 메소드 오버로딩 느낌을 낼 수 있다.
    @JvmOverloads fun send(num:Int=0, msg:String=""){}
}
fun main(){
    val util = MyUtil()
    util.send()
    util.send(10)
    util.send(10,"hi")

    val util2 = YourUtil()
    util2.send()
    util2.send(10)
    util2.send(10,"hello")

    val util3 = OurUtil()

}