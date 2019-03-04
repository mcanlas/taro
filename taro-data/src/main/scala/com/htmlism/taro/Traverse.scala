package com.htmlism.taro

import simulacrum._

@typeclass trait Traverse[F[_]] {
  def traverse[G[_] : Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]
}