package com.github.study.Daily1

/**
 * Created by tamaki on 2015/02/08.
 */
class WordCount {

  //------------------------------------------------------
  // ワードカウント問題
  // https://gist.github.com/j5ik2o/7210762
  //------------------------------------------------------
  // val lines = List("apple banana", "orange apple mango", "kiwi papaya orange","mango orange muscat apple")
  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    val fruitsList = lines.foldLeft("") { (x, y) => x + " " + y }
    fruitsList.split(" ").groupBy(identity).map{
      case (key, value) => (key, value.length)
    }
  }

//  /**
//   * 勉強会をやる発端となったダメコード
//   * @param lines
//   * @return
//   */
//  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
//    lines.foldLeft(new scala.collection.mutable.HashMap[String, Int]) { (b, line) =>
//      line.split(" ").map( m => {
//        val cnt:Int = b.get(m).getOrElse(0) + 1
//        b.put(m, cnt)
//      })
//      b
//    }.toMap
//  }

}
