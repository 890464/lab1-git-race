import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.image.Raster

@RestController
class MyController {

    @GetMapping("/hello")
            /**
             *  The value parameter is a special case in which
             *  its value can be specified without an explicit
             *  name. In this case, the value given to this
             *  parameter is the content of the app.message.
             *  This message is located at /resources/application.properties
             *  and contains the text "Hola estudiante".
             */
    fun sayHello(): String {
        return "Hello, World!"
    }
    var count = 0
    @getMapping("count")
    fun countTimes() : int {
        count = count + 1
        return count
    }
    fun main(args: Array<String>) {

        // Creates a reader instance which takes
        // input from standard input - keyboard
        val reader = Scanner(System.`in`)
        print("Enter a number: ")

        // nextInt() reads the next integer from the keyboard
        var integer:Int = reader.nextInt()

        // println() prints the following line to the output screen
        println("You entered: $integer")
    }
}
