package com.github.study.nnp

import scala.annotation.tailrec

/**
  * Created by tamaki on 2015/02/08.
  */
trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int = {
    list.last
  }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int = {
    list.init.last
  }

  def nth(n: Int, list: List[Int]): Int = {
    list.apply(n)
  }

  def length(list: List[Int]): Int = {
    list.length
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def isPalindrome(list: List[Int]): Boolean = {
//    val center = list.length / 2
//    @tailrec
//    def recloop(n: Int): Boolean = {
//      if (n == center) {
//        true
//      } else if (list.apply(n) == list.apply(list.length - 1 - n)) {
//        recloop(n + 1)
//      } else {
//        false
//      }
//    }
//    recloop(0)
    list == list.reverse
  }

//  val nested = List(List(1, 1), 2, List(3, List(5, 8)))

  def flatten(nested: List[Any]): List[Any] = {
    nested match {
      // xは、head => A
      // xsは、tail => List[A]
      // ::: Listの連結
      // :: Listの最初に要素を追加　
      case (x: List[_]) :: (xs: List[_]) => flatten(x) ::: flatten(xs)
      case y :: (ys: List[_])            => y :: flatten(ys)
      case Nil                           => Nil
    }
  }

  // val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
//  def compress(list: List[Symbol]): List[Symbol] = {
//    @tailrec
//    def loop(n: Int, acc: List[Symbol]): List[Symbol] = {
//      val symbol = list.apply(n)
//      if(n == list.length -1) {
//        acc
//      } else if(acc.contains(symbol)) {
//        loop(n + 1, acc)
//      } else {
//        loop(n + 1, acc :+ symbol )
//      }
//    }
//    loop(0, List.empty)
//  }

  // val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  def compress(list: List[Symbol]): List[Symbol] = {
    @tailrec
    def loop(n: Int, acc: List[Symbol], rest: List[Symbol]): List[Symbol] = {
      rest match {
        case _ if n == list.length - 1        => acc
        case head :: tail if n == 0           => loop(n + 1, acc :+ head, tail)
        case head :: tail if head == acc.last => loop(n + 1, acc, tail)
        case head :: tail                     => loop(n + 1, acc :+ head, tail)
      }
    }
    loop(0, List.empty, list)
  }

  // val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  def pack(list: List[Symbol]): List[List[Symbol]] = {
    @tailrec
    def loop(n: Int,
             acc: List[List[Symbol]],
             rest: List[Symbol]): List[List[Symbol]] = {
      rest match {
        case _ if n == list.length  => acc
        case head :: tail if n == 0 => loop(n + 1, acc :+ List(head), tail)
        case head :: tail if head == acc.last.last =>
          loop(n + 1, acc.updated(acc.length - 1, acc.last :+ head), tail)
        case head :: tail => loop(n + 1, acc :+ List(head), tail)
      }
    }
    loop(0, List(), list)
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] = {
    // List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    val symbolList: List[List[Symbol]] = pack(list)
    symbolList.map(list => (list.length, list.head))
  }

}
