package com.github.study.Daily1

class Fibo {
  // 通常の再帰
  def fib(n: Long): Long = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => fib(n - 2) + fib(n - 2 + 1)
    }
  }

  // 末尾再帰 part1
  def fib(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case n => {
        def loop(i: Int, a: Int, b: Int): Int = {
          if (i == n) a + b
          else loop(i + 1, b, a + b)
        }

        loop(2, 0, 1)
      }
    }
  }

  // 末尾再帰part2
  def fib2(n: Int): Int = {
    def loop(i: Int, a: Int, b: Int): Int = {
      if (i == n) a
      else loop(i + 1, b, a + b)
    }

    loop(0, 0, 1)
  }

  def fib3(n: Int, sum: Int, stack: Int): Int = {
    case 0 => sum
      // sumは、前々回の結果
      // stackは、の前回の計算結果
    case _ => fib3(n - 1, stack, sum + stack)
  }

  def fib(n: Int) = fib3(n, 0, 1)
}
