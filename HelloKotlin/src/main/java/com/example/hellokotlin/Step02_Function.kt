package com.example.hellokotlin

fun main(){
    /*
        in java => public void a(){} (return 해주는 값이 없으면 void 를 쓰는 것 처럼)
        in kotlin => fun a():Unit{} or fun a(){} (return 해주는 값이 없으면)
        코틀린에서 Unit(생략가능)은 원시 type 이라고 지칭하고, java 의 void 와 비슷한 역할을 한다.
     */

    //  함수명():리턴type{}
    fun a():Unit{
        println("a 함수 호출됨!")
    }
    // 이름이 없는 함수를 만들어서 그 참조값을 변수에 담기
    var b = fun(){}

    var num1=10
    var num2:Int=10

    /*
        [ 함수의 type 정의하는 방법 ]
        (매개변수의 모양) -> 리턴 type
     */
    var c:()->Unit = fun():Unit{} // 함수의 type 은 (매개변수type)->리턴type 으로 표기

    //  String type 을 전달 받아서 해당 문자열의 길이를 리턴하는 함수를 변수에 담아보세요
    //  함수의 type 을 정확히 명시해서
    var d:(String)->Int = fun(str:String):Int{
        return str.length
    }
    //  d 라는 변수에는 (String)->Int type 의 함수만 담을 수 있다.
    /*
        d=10        Int type 은 대입되지 않는다.
        d="kim"     String type 은 대입되지 않는다.
        d=fun(){}   ()->Unit type 은 대입되지 않는다.
     */
    d=fun(a:String):Int{return 999} //(String)->Int type 이기 때문에 대입된다.

    var test:(Int,String)->Int
    //  test 라는 변수에 값을 대입 해 보세요.
    test=fun(a:Int, b:String):Int {
        return a*b.length
    }
}