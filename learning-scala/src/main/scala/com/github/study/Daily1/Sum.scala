package com.github.study.Daily1

class Sum {
  def getSum(numbers: List[Int]): Long = {
    numbers.foldLeft(0){(x, y) => x + y}
  }

//  def sum(numbers: List[Int]) = {
//    def getSum() = {
//      numbers match {
//        case head :: tail => sum(head, )
//      }
//    }
//  }

}
