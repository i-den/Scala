#### Lists
All lists are built from two fundamental building blocks, Nil and :: (pronounced “cons”).

The infix operator, ::, expresses list extension at the front

```scala
val fruits = "apples" :: ("oranges" :: ("pears" :: Nil))
// List(apples, oranges, pears)
```

::: - concat
```scala
val others = List("1", "2", "3")
val thirds = fruits ::: others
// List(apples, oranges, pears, 1, 2, 3)
```

```scala
val abcde = List('a', 'b', 'c', 'd', 'e')
abcde.last // e
abcde.init // List(a, b, c, d)
```
```scala
thirds.zipWithIndex
// (apples,0), (oranges,1), (pears,2), (1,3), (2,4), (3,5)
```