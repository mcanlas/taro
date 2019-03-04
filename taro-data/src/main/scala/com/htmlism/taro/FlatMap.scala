package com.htmlism.taro

import simulacrum._

@typeclass trait FlatMap[F[_]] extends Apply[F] {
  @op(">>=") def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
}
