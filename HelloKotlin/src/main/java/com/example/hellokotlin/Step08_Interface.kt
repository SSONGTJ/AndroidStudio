package com.example.hellokotlin

//  kotlin 에서 인터페이스 만들기
interface Remocon{
    fun up()
    fun down()
}

//  인터페이스를 구현한 클래스 만들기
class MyRemocon : Remocon{
    override fun up() {
        println("올려~!")
    }

    override fun down() {
        println("내려~!")
    }

    fun move(){
        println("움직여!")
    }
}

fun main(){
    val r1:MyRemocon = MyRemocon()
    val r2:Remocon = MyRemocon()

    // r1 은 MyRemocon type 이기 때문에 move() 메소드 사용 가능
    r1.up()
    r1.down()
    r1.move()
    println("-----------------")
    // r2 는 Remocon type 이기 때문에 move() 메소드 사용 불가
    r2.up()
    r2.down()
    println("-----------------")
    // in java (MyRemocon)r2
    // in kotlin r2 as MyRemocon
    val r3:MyRemocon = r2 as MyRemocon  // kotlin 의 type casting
    r3.up()
    r3.down()
    r3.move()
    println("-----------------")
    // in java : r2 instanceof MyRemocon
    // in kotlin : r2 is MyRemocon
    if(r2 is MyRemocon){
        // type 확인 방법 ( smart casting ) 형 변환 없이 바로 MyRemocon 의 기능을 사용할 수 있다.
        r2.move()
    }
}