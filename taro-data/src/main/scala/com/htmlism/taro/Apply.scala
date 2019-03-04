package com.htmlism.taro

import simulacrum._

@typeclass trait Apply[F[_]] extends Functor[F] {
  @op("<*>") def ap[A, B](fa: F[A])(ff: F[A => B]): F[B]
}