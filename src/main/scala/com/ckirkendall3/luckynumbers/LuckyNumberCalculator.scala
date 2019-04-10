package com.ckirkendall3.luckynumbers

class LuckyNumberCalculator {

  def generateAllLuckyNumbers(min: Int, max: Int): List[Int] = {
    val range = List.range(min, max + 1)
    var knownNumbers = Set.empty[Int]
    var luckyNumbers = Set.empty[Int]
    range.foreach(value => {
      val path = luckyNumberPath(value, Set.empty[Int], knownNumbers, luckyNumbers)
      knownNumbers = knownNumbers ++ path
      if (path.contains(1)) {
        luckyNumbers = luckyNumbers ++ path
      }
    })
    luckyNumbers.toList.sorted
  }

  def luckyNumberPath(value: Int, path: Set[Int], knownNumbers: Set[Int], luckyNumbers: Set[Int]): Set[Int] = {
    if (knownNumbers.contains(value)) {
      if (luckyNumbers.contains(value)) path + 1 else path
    } else {
      val currentPath = path + value
      val next = calculateDigitSquareSum(value, 0)
      if (currentPath.contains(next)) {
        currentPath + next
      } else {
        luckyNumberPath(next, currentPath, knownNumbers, luckyNumbers)
      }
    }
  }

  def calculateDigitSquareSum(value: Int, result: Int): Int = {
    value match {
      case x if x < 0 => throw new IllegalArgumentException()
      case x if x < 10 => result + sqr(value)
      case _ => calculateDigitSquareSum(value / 10, result + sqr(value % 10))
    }
  }

  private def sqr(x: Int) = x * x
}
