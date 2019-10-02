package com.github.study.Daily1

class Fact {

  def fact(n: Int): Long = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => n * fact(n - 1)
    }
  }
}
