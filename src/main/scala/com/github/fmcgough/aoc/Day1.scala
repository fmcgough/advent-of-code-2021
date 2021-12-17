package com.github.fmcgough.aoc

import scala.io.Source

object Day1 extends App {

  val classLoader = getClass.getClassLoader
  val values: Seq[Int] = Source.fromResource("day1.txt").mkString.linesIterator.toSeq.map(_.toInt)

  val increases = values.zip(values.drop(1)).count { case (x, y) => y > x }

  println(s"Day 1: $increases")

  val sliding = values.sliding(3).toSeq
  val slidingIncreases = sliding.zip(sliding.drop(1)).count { case (xs, ys) => ys.sum > xs.sum }

  println(s"Sliding increases: $slidingIncreases")
}
