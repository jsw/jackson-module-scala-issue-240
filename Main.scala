import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

trait M
case class F(label: String) extends M
case class C(m: Option[M])

object Main extends Application {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  println(mapper.writeValueAsString(C(Some(F("foo")))))
}
