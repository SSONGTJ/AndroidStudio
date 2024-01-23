package com.example.hellokotlin

fun main(){
    val nums= mutableListOf(10, -5, -6, 1, 4, -7, -8, 20, 30, -15, -13)
    //for문을 활용해서 nums List에서 음수를 모두 제거 해 보쇼
//    for ( i in nums.size-1 downTo 0){
//        if(nums[i] < 0){
//            nums.removeAt(i)
//        }
//    }
    // 이런 방법도 있다.
    for (i in nums.indices.reversed()){
        if(nums[i] < 0){
            nums.removeAt(i)
        }
    }
    //삭제 후에 실제로 음수가 모두 삭제 되었는지 순서대로 출력 해 보쇼
    for (item in nums){
        println(item)
    }
    println("-----")
    //삭제된 새로운 배열을 얻어내고 싶다면 .filter 함수를 사용하면 된다.
    val nums2 = mutableListOf(10, -5, -6, 1, 4, -7, -8, 20, 30, -15, -13)

    // result 는 음수가 제거된 새로운 배열
    val result = nums2.filter { item -> item >= 0  }
    println("result : "+result)
    println("-----")

    val result2 = nums2.filter(fun(item):Boolean{
        return item >= 0
    })
    println("result2 : "+result2)
    println("-----")

    val result3 = nums.filter({item ->
        item >=0
    })
    println("result3 : "+result3)
    println("-----")

    //람다식의 매개변수가 1개인 경우에는 매개변수를 선언하지 않고 it 으로 매개변수에 전달된 값을 가리킬 수 있다.
    val result4 = nums.filter{ it >= 0}
    println("result4 : "+result4)
    println("-----")
}