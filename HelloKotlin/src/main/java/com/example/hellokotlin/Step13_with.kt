package com.example.hellokotlin
/*
    with 는 맨 마지막 이 남는다. showInfo 일 경우 Unit 타입
 */
fun main (){
    class Member{
        var num:Int?=null
        var name:String?=null
        var isMan:Boolean?=null
        fun showInfo(){ // Unit type
            println("${this.num}, ${this.name}, ${this.isMan}")
        }
    }

    val m1=Member()
    m1.num=1
    m1.name="김구라"
    m1.isMan=true
    m1.showInfo()

    val m2=Member()
    with(m2){
        num=2
        name="해골"
        isMan=false
        showInfo()
    }

    val m3=Member()
    val result:String = with(m3){
        num=3
        name="원숭이"
        isMan=true
        showInfo()
        "${this.num}, ${this.name}, ${this.isMan} 입니다."
    }
}
