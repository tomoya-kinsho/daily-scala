package com.github.study.FizzBuzz

/**
 * Created by tamaki on 2015/02/08.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    // for式
    // foreach
//    for (i <- 1 to 100)
//      if(i % 3 == 0) {
//        println("Fizz")
//      }  else if(i % 5 == 0) {
//        println("Buzz")
//      } else if(i % 15 == 0) {
//        println("FizzBuzz")
//      } else {
//        println(i)
//      }

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



  }
}



