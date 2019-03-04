package com.htmlism.taro

import simulacrum._

@typeclass trait Applicative[F[_]] extends Apply[F] {
  def pure[A](x: A): F[A]
}