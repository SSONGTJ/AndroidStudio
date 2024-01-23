package com.example.hellokotlin

class MyData{
    //문자열을 담을 필드
    lateinit var name:String

    //인자로 전달받은 문자열을 필드에 저장하는 메소드
    fun putName(name:String){
        this.name=name
    }
}

fun main() {
    val nums2:List<Int> = listOf<Int>(1,2,3,4,5,6,7,8,9,10)

    val result:List<Int> = nums2.filter { item -> item % 2 == 0 }
    println(result)

    println("------")
    val nums = listOf(10, 20, 30, 40, 50)
    nums.forEach { println(it) }


}

val  list: List<Any> =listOf(10, "kim", true )