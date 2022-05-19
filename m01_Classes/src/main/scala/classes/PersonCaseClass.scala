package classes

case class PersonCaseClass(name: String, age: Int) {

}

object PersonCaseClass {

  def apply(name: String, age: Int): PersonCaseClass = {
    if name.isEmpty then 
      throw new IllegalArgumentException("Name cannot be empty")
    new PersonCaseClass(name.toUpperCase(), age)
  }
}
