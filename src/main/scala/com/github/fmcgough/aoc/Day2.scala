package com.github.fmcgough.aoc

import scala.io.Source

object Day2 extends App {

  val classLoader = getClass.getClassLoader
  val lines: Seq[String] = Source.fromResource("day2.txt").mkString.linesIterator.toSeq

  val (p, q) = lines.foldLeft((0, 0)) { case ((x, y), next) =>
    val direction = next.takeWhile(_ != ' ')
    val increment = next.dropWhile(_ != ' ').trim.toInt

    direction match {
      case "forward" => (x + increment, y)
      case "down" => (x, y + increment)
      case "up" => (x, y - increment)
    }
  }

  println(s"Solution: ${p * q}")

  val (p2, q2, aim) = lines.foldLeft((0, 0, 0)) { case ((x, y, a), next) => 
    val direction = next.takeWhile(_ != ' ')
    val increment = next.dropWhile(_ != ' ').trim.toInt

    direction match {
      case "down" => (x, y, a + increment)
      case "up" => (x, y, a - increment)
      case "forward" => (x + increment, y + (a * increment), a)
    }
  }

  println(s"Part 2: ${p2 * q2}")
}
