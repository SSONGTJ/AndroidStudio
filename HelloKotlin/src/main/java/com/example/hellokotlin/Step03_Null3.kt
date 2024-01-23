package com.example.hellokotlin



fun main(){
    var str:String = "abcde12345"
    var str2:String? = "abcde12345"

    // 문자열의 길이를 참조해서 변수에 담기
    var length = str.length     // Int type

    var length2 = str2?.length  // Int? type -> null 일 가능성이 있기 때문에

    // Elvis 연산자?: 는 null 일 경우에 기본 값을 남기는 연산자이다.
    // str2.length 가 만일 null 이면 0을 남기기 때문에 대입연산자의 우측이 null 일 가능성은 없다.
    // 따라서 length3 은 Int? type 이 아닌 Int type 으로 선언할 수 있는 것이다.
    var length3:Int = str2?.length ?:0
}