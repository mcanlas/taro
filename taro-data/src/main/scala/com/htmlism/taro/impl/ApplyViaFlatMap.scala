package com.htmlism.taro
package impl

/**
  * Satisfies the contract established in `Apply` by using a method from `FlatMap`.
  */
trait ApplyViaFlatMap[F[_]] extends Apply[F] {
  self: FlatMap[F] =>

  def ap[A, B](fa: F[A])(ff: F[A => B]): F[B] =
    flatMap(ff)(f => map(fa)(f))
}
