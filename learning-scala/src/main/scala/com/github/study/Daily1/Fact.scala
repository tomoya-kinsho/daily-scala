package com.github.study.Daily1

class Fact {

  // 通常再帰
  //  def fact(n: Int): Long = {
  //    n match {
  //      case 0 => 0
  //      case 1 => 1
  //      case _ => n * fact(n - 1)
  //    }
  //  }

  // 末尾再帰
  def fact(n: Int) = {
    def loop(n: Int, acc: Int): Int = {
      if (n == 0) 1
      if (n == 1) acc
      // 4!の場合
      // loop(3, 4)
      // loop(2, 12)
      // loop(1, 24)
      // loop(0, 24)
      else loop(n - 1, n * acc)
    }

    loop(n, 1)
  }

}
