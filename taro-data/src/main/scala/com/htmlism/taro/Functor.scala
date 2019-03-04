package com.htmlism.taro

import simulacrum._

@typeclass trait Functor[F[_]] {
  /**
    * Changes the inner type `A` to `B`.
    *
    * @param fa A wrapped value
    * @param f A function from `A` to `B`
    */
  def map[A, B](fa: F[A])(f: A => B): F[B]
}