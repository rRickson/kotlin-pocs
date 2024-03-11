import org.yaml.snakeyaml.Yaml
import java.io.FileInputStream
import java.io.FileWriter
import java.io.PrintWriter
import java.lang.Exception

fun main(args: Array<String>) {
    generateCode()
}

fun generateCode(){
    try {
        val yamlFile = Yaml()
        val inputStream = FileInputStream("src/main/resources/classes.yaml")
        val yamlData = yamlFile.load<Map<String, Any>>(inputStream)

        for((className, properties) in yamlData){
            val writer = PrintWriter(FileWriter("src/main/kotlin/$className.kt"))
            writer.println("class $className {")
            for ((propertyName, _) in (properties as Map<*,*>) ){
                for((_, attributes) in (properties as Map<*, ArrayList<*>>)){
                    if(propertyName == "property"){
                        val attName= attributes[0]
                        val attDefaultValue = attributes[1]
                        val attType = attributes[2]
                        writer.println("private val $attName: $attType = \"$attDefaultValue\"")
                    }
                }
            }
            writer.println("}")
            writer.println()
            writer.close()
        }
    }catch (e:Exception){
        e.printStackTrace()
    }
}