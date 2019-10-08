package com.github.study.FizzBuzz

/**
 * Created by tamaki on 2015/02/08.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    // for式
    // foreach
    for (i <- 1 to 100)
      if(i % 3 == 0) {
        println("Fizz")
      }  else if(i % 5 == 0) {
        println("Buzz")
      } else if(i % 15 == 0) {
        println("FizzBuzz")
      } else {
        println(i)
      }

    // ただcollectionを処理したかったら、
    // map flatMapで書き換えれる。
    // map flatMapで書く際に、ネストが深くなる時にfor式の内包表記を使うと、フラットになり処理が追いやすい
    case class User(name: Option[String], age: Option[Int], location: Option[Location])
    case class Location(prefecture: String, town: Option[String])
    case class UserResult(name: String, town: String)
    val userList = Seq(
      User(Some("tomoya"), Some(24), Some(Location("nara", None))),
      User(Some("nana"), Some(24), Some(Location("nara", Some("sakurai")))),
      User(Some("iku"), Some(24), Some(Location("nara", Some("kannmaki")))),
      User(Some("mimi"), Some(24), Some(Location("nara", Some("kashiba")))))

    // for
    val userInfo = for {
      user <- userList
      name <- user.name
      location <- user.location
      // townがNoneの場合は処理がスキップされる
      // Someの時だけ処理される
       town <- location.town
      // Q: Noneの時にも処理をして欲しい時はどうするのか？
//      town <- location.town.fold("no town")(identity)
    } yield UserResult(name, town)
    println(userInfo)

    // map
    val userInfo2 = userList.map {
      user => UserResult(
        user.name.getOrElse("no name"),
        user.location.get.town.getOrElse("no town")
      )
    }

    println(userInfo2)


    // case pattern matchを使う
    def calcurateFizzBuzz(num: Int): String = {
      num match {
        case n if n % 15 == 0 => "FizzBuzz"
        case n if n % 3 == 0 => "Fizz"
        case n if n % 5 == 0 => "Buzz"
        case n => n.toString
      }

    }

    val list = 1 to 100

    for(
      i <- list
    ) {
      println(calcurateFizzBuzz(i))
    }

    // 一行でかく
    // toListにする意味ないよね？
    (1 to 100).toList.foreach(num => if(num % 15 == 0) println("FizzBuzz") else if(num % 3 == 0) println("Fizz") else if(num % 5 == 0) println("Buzz") else println(num.toString))

    // (1 to 100).toList.foreach(num => num match { case n if n % 15 == 0 => println("FizzBuzz") case n if n % 3 == 0 => println("Fizz") case n if n % 5 == 0 => println("Buzz") case n => n.toString })

    // ２の倍数は除外する
    val list2: List[Int] = (1 to 100).toList

    def fizzBuzz2(num: Int): String = {
      num match {
        case n if n % 15 == 0 => "FizzBuzz"
        case n if n % 3 == 0 => "Fizz"
        case n if n % 5 == 0 => "Buzz"
        case n => n.toString
      }
    }

    for(
      // filterをかける
      i <- list2 if i % 2 != 0
    ) {
      println(fizzBuzz2(i))
    }


    // 一行ずつ表示をやめる

    val list3: List[Int] = (1 to 100).toList

    def fizzBuzz3(list: List[Int]): List[String] = {
      list3.map(num => num match {
        case n if n % 15 == 0 => "FizzBuzz"
        case n if n % 3 == 0 => "Fizz"
        case n if n % 5 == 0 => "Buzz"
        case n => n.toString
      })
    }

    println(fizzBuzz3(list3).mkString(","))



    // fizz buzz fizzbuzzになっていない数字の合計値を出す

    val list4: List[Int] = (1 to 100).toList

    def fizzBuzz4(list: List[Int]): List[String] = {
      list.map(num => num match {
        case n if n % 15 == 0 => "FizzBuzz"
        case n if n % 3 == 0 => "Fizz"
        case n if n % 5 == 0 => "Buzz"
        case n => n.toString
      })
    }
    val strList = fizzBuzz4(list4)

    strList.map(s => {
      if(s.contains("zz")) 0
      else s.toInt
    }).sum

  }
}



