package com.example.hellokotlin

fun main(){
    //Remocon type 의 참조값을 간단히 얻어내기

    // 익명 클래스를 정의함과 동시에 객체를 생서하는 것이 object 키워드이다.
    val r1:Remocon = object : Remocon { // in java -> new Remocon(){} 익명 클래스 class ? implements Remocon{} 로 볼 수 있다.
        override fun up() {
            println("올려~")
        }

        override fun down() {
            println("내려~")
        }
    }

    r1.up()
    r1.down()
}