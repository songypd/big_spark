package com.scala.learn.base

/**
  * Created by yuanpeng.song on 2018/8/7.
  * Actor Model
  */

;

import scala.actors.Actor

class myActor extends Actor{

  def act(){
    while(true){
      receive {
        case x:String => println("save String ="+ x)
        case x:Int => println("save Int")
        case _ => println("save default")
      }
    }
  }
}

object scala_Actor_001 {
  def main(args: Array[String]): Unit = {

    //创建actor的消息接收和传递
    val actor =new myActor()
    //启动
    actor.start()
    //发送消息写法
    actor ! "i love you !"

  }
}



case class Message(msg:String,endpointRef:Actor)

//endpoint  实体,角色,处理消息
//endpointRef  对实体的引用,消息发送的体现
//send
//ask

//1
class Act1 extends Actor {

  def act(): Unit = {
    while(true){
      receive{
        case x:Message => if(x.msg.equals("hello")){
          println("hello....")
          x.endpointRef ! Message("wozhidaole",this)
        }else if(x.msg.equals("womenkaishiba...")){
          println("womenkaishiba...")
          x.endpointRef ! Message("xintiao...",this)
          println("xintaoba.....")
        }
        case _ => println("dklsjfklsdjfkl")
      }
    }
  }
}
class Act2(ac1:Actor) extends Actor {

  ac1 ! Message("hello",this)

  def act(): Unit = {
    while(true){
      receive{
        case x:Message => if(x.msg.equals("wozhidaole")){
          println("wozhidaole....")

          x.endpointRef ! Message("womenkaishiba...",this)
        }
        case _ => println("dklsjfklsdjfkl")
      }

    }
  }
}


object lesson05 {
  def main(args: Array[String]): Unit = {
    val ac1 = new Act1
    val ac2 = new Act2(ac1)
    ac1.start()
    ac2.start()


  }




}