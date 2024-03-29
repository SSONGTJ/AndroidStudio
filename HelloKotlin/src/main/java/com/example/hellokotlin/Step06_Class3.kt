package com.example.hellokotlin

class Member(var num:Int, var name:String, var add:String)
//  data 예약어를 붙이면 toString() 메소드가 자동 재정의 되고 copy() 메소드가 생긴다.
//  콘솔창에 출력했을 때 필드에 저장된 내용을 알 수 있다.
data class Member2(var num:Int, var name:String, var add:String)

fun main(){
    val m1=Member(1,"김구라", "노량진")
    println(m1)

    val m2=Member2(2,"해골", "행신동")
    println(m2)

    val m3=m2.copy()
    println(m3)
    if(m2 == m3) println("m2 와 m3 는 같아요.") else println("m2 와 m3 는 달라요.")
}