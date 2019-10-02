package com.github.study.Daily1

class Fibo {
  def fib(n: Long): Long = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => fib(n - 2) + fib(n - 2 + 1)
    }
  }
}
