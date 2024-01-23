package com.example.hellokotlin

/*
    String 과 String? 은 다른 type 으로 취급 된다.
    즉 type 에 ? 가 붙은 것과 안 붙은 것은 다른 type 이다.
    ? 가 붙으면 null 이 가능한 type
    ? 가 안 붙으면 null 이 불가능한 type
 */

fun main(){
    var a:String
    var b:String = "kim"
    var c:String? = null

    //println(a.length) 초기화 되지 않았기 때문에 a는 사용 불가

    println("문자열의 길이:"+b.length)

    // c가 null 이 아닌 경우에만 length를 참조해라 ( null safe )
    println("문자열의 길이:"+c?.length)

    println("main 함수가 종료 됩니다.")
}