package com.htmlism.taro
package instances

import com.htmlism.taro.syntax._

object UseEvidence extends App {
  4 |+| 4

  4.some >>= (n => Some(n + 1))

  println {
    List(1, 2, 3)
      .traverse { n => println(n); Option(n) }
  }

  println {
    List(1, 2, 3)
      .traverse(n => if (n > 1) None else Some(n))
  }
}
