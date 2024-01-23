package com.example.hellokotlin

fun main(){
    // ReadOnly Map type 객체 만들기 [ type 추론이 가능하기 때문에 생략도 가능하다 ]
    val mem:Map<String, Any> = mapOf<String, Any>("num" to 1, "name" to "김구라", "isMan" to true)

//    1) 이렇게 적는 방법
//    val num:Any? = mem.get("num")
//    val name:Any? = mem.get("name")
//    val isMan:Any? = mem.get("isMan")

//    2) 이렇게 적는 방법
//    val num:Any? = mem["num"]
//    val name:Any? = mem["name"]
//    val isMan:Any? = mem["isMan"]

//    casting 까지 동시에 하기
    val num = mem.get("num") as Int // as 캐스팅할 type
    val name = mem.get("name") as String
    val isMan = mem.get("isMan") as Boolean

    println(num)
}