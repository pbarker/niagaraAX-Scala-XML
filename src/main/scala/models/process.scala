package models
import scala.xml._
import scala.xml.transform._

/**
 * Created by Grillz on 8/11/14.
 */
class process {
  def run {

    val fullXML = XML.loadFile("./src/batch_data/newxml1.xml")
    val totalBoxes = 10
    var currentVAV = 1

    def attriProcess(attr : String): String = {
      val a = attr.split(":")
      val sString = a(0)
      val i = a(1).toInt
      val i2 =  i + ((currentVAV - 1) * 100)
      val iString = i2.toString
      val newNew = sString + ":" + iString
      newNew
    }

    object t1 extends RewriteRule {
      override def transform(n: Node): Seq[Node] = n match {
        case e @ <p>{therms @ _*}</p> if e.attributes("n").text == "objectId"  =>
          val att = e.attributes("v").text
          val attriNew = attriProcess(att)
          e.asInstanceOf[Elem] % Attribute(null, "v", attriNew , Null)

        case other => other
      }
    }

    object rt1 extends RuleTransformer(t1)

    object t2 extends RewriteRule {
      override def transform(n: Node): Seq[Node] = n match {
        case e @ <p>{therms @ _*}</p> if e.attributes("n").text == "VAV" + currentVAV  => rt1(e)
        case other => other
      }
    }

    object rt2 extends RuleTransformer(t2)

    var newXML = rt2(fullXML)
    currentVAV += 1

    for (i <- 0 to totalBoxes){
      //println(i)
      newXML = rt2(newXML)
      currentVAV += 1

    }

    println(newXML)

  }

}
