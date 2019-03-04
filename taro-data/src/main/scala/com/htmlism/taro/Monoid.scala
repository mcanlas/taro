package com.htmlism.taro

import simulacrum._

@typeclass trait Monoid[A] extends Semigroup[A] {
  def zero: A
}