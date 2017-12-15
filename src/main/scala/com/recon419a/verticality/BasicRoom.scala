package com.recon419a.verticality

case class BasicRoom(override val offset: Coordinate) extends HollowCuboid(Coordinate(8, 4, 8), offset) {
}
