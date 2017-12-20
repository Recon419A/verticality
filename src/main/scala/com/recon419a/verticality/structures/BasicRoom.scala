package com.recon419a.verticality.structures

import com.recon419a.verticality.structures.cuboids.HollowCuboid
import com.recon419a.verticality.util.Coordinate

case class BasicRoom(override val offset: Coordinate) extends HollowCuboid(Coordinate(8, 4, 8), offset) {
}
