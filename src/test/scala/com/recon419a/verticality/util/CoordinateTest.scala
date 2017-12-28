package com.recon419a.verticality.util

import org.scalatest.{FlatSpec, Matchers}

class CoordinateTest extends FlatSpec with Matchers {
  "+" should "add two positive coordinates correctly" in {
    Coordinate(1, 1, 1) + Coordinate(2, 3, 5) shouldBe Coordinate(3, 4, 6)
  }

  it should "handle negative arguments" in {
    Coordinate(1, -2, 4) + Coordinate(-3, 5, -8) shouldBe Coordinate(-2, 3, -4)
  }

  "-" should "handle a basic case" in {
    Coordinate(1, -3, 4) - Coordinate(2, -2, 8) shouldBe Coordinate(-1, -1, -4)
  }

  "/" should "handle a basic case" in {
    Coordinate(2, 4, -8) / 2 shouldBe Coordinate(1, 2, -4)
  }

  it should "round appropriately" in {
    Coordinate(2, 4, -8) / 3 shouldBe Coordinate(0, 1, -2)
  }

  "<<=" should "return true for a coordinate equal in all dimensions" in {
    (Coordinate(1, 2, 3) <<= Coordinate(1, 2, 3)) shouldBe true
  }

  it should "fail if any one dimension is higher" in {
    (Coordinate(0, 0, 1) <<= Coordinate(0, 0)) shouldBe false
    (Coordinate(0, 1) <<= Coordinate(0, 0)) shouldBe false
    (Coordinate(1, 0) <<= Coordinate(0, 0)) shouldBe false
  }

  it should "fail if two dimensions are significantly lower and the third is higher" in {
    (Coordinate(0, 0, 1) <<= Coordinate(100, 100)) shouldBe false
  }

  "to" should "produce an inclusive range along a single axis" in {
    Coordinate(0, 0) to Coordinate(0, 0, 1) shouldBe List(Coordinate(0, 0), Coordinate(0, 0, 1))
  }

  it should "produce an inclusive range along two axes" in {
    Coordinate(0, 0) to Coordinate(0, 1, 1) shouldBe List(Coordinate(0, 0), Coordinate(0, 0, 1),
      Coordinate(0, 1), Coordinate(0, 1, 1))
  }

  it should "produce an inclusive range along three axes" in {
    Coordinate(0, 0) to Coordinate(1, 1, 1) shouldBe List(Coordinate(0, 0), Coordinate(0, 0, 1),
      Coordinate(0, 1), Coordinate(0, 1, 1), Coordinate(1, 0), Coordinate(1, 0, 1), Coordinate(1, 1),
      Coordinate(1, 1, 1))
  }

  "apply" should "default to zero for z" in {
    Coordinate(1, 2) shouldBe Coordinate(1, 2)
  }

  it should "correctly parse from a size" in {
    Coordinate(Size(1, 2, 3)) shouldBe Coordinate(0, 1, 2)
  }
}
