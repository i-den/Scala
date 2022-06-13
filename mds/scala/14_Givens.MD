Passing in 'given' env to a fn
```scala
class PreferredPrompt(val pref: String) {}
```
The 'using' keyword
```scala
object Greeter {
  def greet(name: String)(using prompt: PreferredPrompt): Unit = {
    println(s"Welcome, $name. The system is ready.")
    println(prompt.pref)
  }
}
```
```scala
import JillsPrefs.prompt

object GivensMain extends App {
  println(Greeter.greet("sd"))
  // Welcome, sd. The system is ready.
  // Your Wish:_
}
```
