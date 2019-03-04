package com.htmlism.taro

import com.htmlism.taro.syntax._

package object instances {
  implicit val intMonoid: Monoid[Int] =
    new Monoid[Int] {
      def zero: Int = 0

      def append(x: Int, y: Int): Int =
        x + y
    }

  implicit val optionMonad: Monad[Option] =
    new Monad[Option] with impl.ApplyViaFlatMap[Option] {
      def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] =
        fa.flatMap(f)

      def map[A, B](fa: Option[A])(f: A => B): Option[B] =
        fa.map(f)

      def pure[A](x: A): Option[A] =
        Some(x)
    }

  implicit val listMonad: Monad[List] =
    new Monad[List] with impl.ApplyViaFlatMap[List] {
      def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] =
        fa.flatMap(f)

      def map[A, B](fa: List[A])(f: A => B): List[B] =
        fa.map(f)

      def pure[A](x: A): List[A] =
        List(x)
    }

  implicit val listTraverse: Traverse[List] =
    new Traverse[List] {
      def traverse[G[_] : Applicative, A, B](fa: List[A])(f: A => G[B]): G[List[B]] = {
        // using a zero structure in context
        val gzero = List.empty[B].pure[G]

        val greverse =
          fa.foldLeft(gzero) { (acc, elem) =>
            val gx = f(elem)
            val gappend = acc.map(xs => (x: B) => x :: xs)

            gx <*> gappend
          }

        greverse.map(_.reverse)
      }
    }

  implicit class IdOpsOption[A](x: A) {
    def some: Option[A] =
      Some(x)
  }

  implicit class IdOpsApplicative[A](x: A) {
    def pure[F[_]: Applicative]: F[A] =
      Applicative[F].pure(x)
  }
}
