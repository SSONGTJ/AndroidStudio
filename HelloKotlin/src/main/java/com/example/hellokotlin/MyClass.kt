package com.example.hellokotlin

/*
 *  [ Kotlin 기본 data type ]
 *  - import 없이 바로 사용할 수 있는 data type
 *  Byte, Short, Int, Long
 *  Float, Double
 *  Boolean, Char
 *  String
 */
fun main(){
    println("Hello, World!")

    // 정수를 담을 수 있는 num 이라는 이름의 변수를 만들어서 10 대입하기
    var num:Int = 10
    // 실수를 담을 수 있는 num2 라는 이름의 변수를 만들어서 10.1 대입하기
    var num2:Double = 10.1
    // 문자열을 담을 수 있는 myName 이라는 변수를 만들어서 "김구라" 대입하기
    var myName:String = "김구라"

    // num 은 변수(var) 라서 값 변경 가능
    num=11

    // val 은 상수를 만들 때 사용하는 예약어다.
    val num3:Int = 20 // 값이 한번 결정되면 변경 불가
    // num3 = 21 <- 변경 불가

    // type 추론이 가능한 경우 type 은 생략 가능
    var num4=10
    var num5=10.1
    var yourName="해골"

    // 변수를 미리 선언하고
    var num6:Int = 6

}