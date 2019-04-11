package com.ckirkendall3.luckynumbers

object LuckyNumberApp extends App {
  println((new LuckyNumberApp).processRequest(args, new LuckyNumberCalculator))
}

class LuckyNumberApp {
  def processRequest(args: Array[String], calculator: LuckyNumberCalculator): String = {
    val resultString = {
      args.length match {
        case 1 =>
          try {
            val number = args(0).toInt
            if (number <= 0 || number > 1000) "Value must be between 1 and 1000:  Usage: luckyNumber [value: Int]"
            else {
              val path = calculator.luckyNumberPath(args(0).toInt, Set.empty, Set.empty, Set.empty)
              if (path.contains(1)) args(0) + " is a Lucky Number"
              else args(0) + "is not a Lucky Number"
            }
          } catch {
            case nfe: NumberFormatException => "Value must be a number: Usage: luckyNumber [value: Int]\""
          }
        case 0 =>
          calculator.generateAllLuckyNumbers(1, 1000).mkString(", ")
        case _ => "Invalid number of arguments: Usage: luckyNumber [value: Int]"
      }
    }
    resultString
  }
}
