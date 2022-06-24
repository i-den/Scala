### Options
Wrapper for something that is there or not
```scala
  val a: Option[Int] = Some(4)
  val b: Option[Int] = None

  def unsafeMethod(): String = null
  def backupMethod(): String = "Valid Result"

  val canBeNull = Option(unsafeMethod()) // None

  val chainedOption = Option(unsafeMethod())
                        .orElse(Option(backupMethod()))
```
```scala
  val config: Map[String, String] = Map(
    "host" -> "1.2.3.4",
    "port" -> "80")

  val host = config.get("host")
  val port = config.get("port")

  /*
    if (host != null) {
      if (port != null) {
        return ....
      }
    }
  */
  val connected: Option[String] = host.flatMap(h => port.flatMap(p => Some(s"$h:$p"))
    .orElse(Some("No Port")))
    .orElse(Some("No Host"))

  println(connected)
```