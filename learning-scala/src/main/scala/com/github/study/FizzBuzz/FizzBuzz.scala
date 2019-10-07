package com.github.study.FizzBuzz

/**
 * Created by tamaki on 2015/02/08.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
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
  }
}

