package com.ckirkendall3.luckynumbers

import org.scalatest.FunSuite

class LuckyNumberCalculatorTest extends FunSuite {

  val calculator = new LuckyNumberCalculator
  test("Test the sum of the squares of the digits") {
    assert(calculator.calculateDigitSquareSum(9, 0) === 81)
    assert(calculator.calculateDigitSquareSum(15, 0) === 26)
    assert(calculator.calculateDigitSquareSum(234, 0) === 29)
    assert(calculator.calculateDigitSquareSum(67, 0) === 85)
    assert(calculator.calculateDigitSquareSum(100, 0) === 1)
  }

  test("Total of all lucky numbers from 1 to 100 is 143") {
    val luckyNumbers = calculator.generateAllLuckyNumbers(1, 1000)
    assert(luckyNumbers.contains(1000))
    assert(luckyNumbers.length === 143)
    assert(luckyNumbers.contains(100))
   }

  test("Lucky path of a number extends until it detects a duplicate") {
    val path = calculator.luckyNumberPath(19, Set.empty, Set.empty, Set.empty)
    assert(path.contains(19))
    assert(path.contains(68))
    assert(path.contains(100))
    assert(path.contains(1))
  }
}
