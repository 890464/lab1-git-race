package es.unizar.webeng.mycontroller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

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
    
}
