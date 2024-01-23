package com.example.hellokotlin

import java.util.Scanner

fun main(){
    /*
        java 패키지에 있는 클래스 import 가능
        in 은 예약어인데 예약어를 escape 하는 방법은 backtick 으로 감싸주면 된다.
        new 예약어 없이 클래스명() gudtlrdmfh rorcp todtjdgksek.
     */
    val scan:Scanner = Scanner(System.`in`)
    println("Gun:1, Sword:2")
    print("무기를 선택하세요 (1 or 2):")
    val weapon = scan.nextInt()
    // weapon 안에 들어 있는 숫자를 이용해서 분기하기
    when(weapon){ //kotlin 에는 switch 문이 없다.
        1 -> {
            println("총으로 공격해요.")
        }
        2 -> {
            println("칼로 공격해요.")
        }
        else -> println("주먹으로 공격해요.")   // 실행할 code가 한 줄이면 중괄호 생략 가능
    }

    // 대입연산자의 우측에 when() 문을 작성할 수도 있다.
    val selectedWeapon = when(weapon){
        1->"총"
        2->"칼"
        else->"주먹"
    }
    println(selectedWeapon)
}