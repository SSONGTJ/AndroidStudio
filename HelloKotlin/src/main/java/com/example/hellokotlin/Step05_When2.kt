package com.example.hellokotlin

import java.util.Scanner


fun main(){
    val scan = Scanner(System.`in`)
    println("점수 입력 :")
    val jumsu=scan.nextInt()
    when(jumsu){
        in 90..100 -> println("90에서 100 사이 입니다.")
        in 80..90 -> println("80에서 90 사이 입니다.")
        else -> println("80 아래 입니다.")
    }
    
    when(jumsu){
        in 90..100 -> println("A 학점")
        in 80 until 90 -> println("b학점")
        in 70 until 80 -> println("C 학점")
        else -> println("A,B,C 이외의 학점")
    }

}