package com.github.study.Daily1

class Sum {
  def getSum(numbers: List[Int]): Long = {
    numbers.foldLeft(0){(x, y) => x + y}
  }

}
