package com.ckirkendall3.luckynumbers

import org.scalatest.FunSuite

class LuckyNumberAppTest extends FunSuite {

  val app = new LuckyNumberApp
  test("Test no input - all lucky numbers") {
    assert(app.processRequest(Array.empty, new LuckyNumberCalculator).contains("998, 1000"))
  }

  test("Test lucky numbers") {
    assert(app.processRequest(Array("1"), new LuckyNumberCalculator).contains("is a Lucky Number"))
    assert(app.processRequest(Array("683"), new LuckyNumberCalculator).contains("is a Lucky Number"))
    assert(app.processRequest(Array("709"), new LuckyNumberCalculator).contains("is a Lucky Number"))
  }

  test("Test unlucky numbers") {
    assert(app.processRequest(Array("3"), new LuckyNumberCalculator).contains("is not a Lucky Number"))
    assert(app.processRequest(Array("200"), new LuckyNumberCalculator).contains("is not a Lucky Number"))
    assert(app.processRequest(Array("800"), new LuckyNumberCalculator).contains("is not a Lucky Number"))
  }

  test("Test passing in a non integer") {
    assert(app.processRequest(Array("test"), new LuckyNumberCalculator).contains("Value must be a number"))
  }

  test("Test passing in too many arguments") {
    assert(app.processRequest(Array("1", "12"), new LuckyNumberCalculator).contains("Invalid number of arguments"))
  }

}
