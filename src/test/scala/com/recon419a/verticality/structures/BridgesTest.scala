package com.recon419a.verticality.structures

import com.recon419a.verticality.structures.Bridges.{BridgeAtrium, bridgeFlags}
import com.recon419a.verticality.util.Coordinate
import org.scalatest.{FlatSpec, Matchers}

class BridgesTest extends FlatSpec with Matchers {
  "atrium" should "be a BridgeAtrium" in {
    Bridges.atrium shouldBe BridgeAtrium
  }

  "bridgeFlags" should "return an empty for an empty" in {
    bridgeFlags(WingFlags()) shouldBe WingFlags()
  }

  it should "return north and east true for a fill" in {
    bridgeFlags(WingFlags.fill()) shouldBe WingFlags(north = true, east = true)
  }

  it should "return north true for a north-south-east WingFlags" in {
    bridgeFlags(WingFlags(north = true, east = true, south = true)) shouldBe WingFlags(north = true)
  }

  it should "return east true for an east-west WingFlags" in {
    bridgeFlags(WingFlags(east = true, west = true)) shouldBe WingFlags(east = true)
  }

  it should "map over each floor" in {
    val floors = Seq.fill(3)(WingFlags.random())
    bridgeFlags(floors) shouldBe floors.map(bridgeFlags)
  }

  "BridgeAtrium" should "have a 33-block structure as its wings" in {
    BridgeAtrium.wingStructure.voxels.size shouldBe 33
  }

  it should "have a wing structure with maxCoordinate (6, 0, 0)" in {
    BridgeAtrium.wingStructure.maxCoordinate shouldBe Coordinate(6, 0, 0)
  }

  it should "have an empty center structure" in {
    BridgeAtrium.centerStructure shouldBe Structure()
  }
}
