package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.text.SimpleDateFormat

/** 
 *  Controller class.
 *
 *  The annotation [Controller], which are means of attaching
 *  metadata to code.
 *  The responsbility ofthis class is to accept requests
 *  from the user, to interact with the model and to select
 *  the view for response.
 */
@Controller
class HelloController {

    /**
     *  The value parameter is a special case in which
     *  its value can be specified without an explicit
     *  name. In this case, the value given to this
     *  parameter is the content of the app.message.
     *  This message is located at /resources/application.properties
     *  and contains the text "Hola estudiante".
     */
    @Value("\${app.message}")
    private var message: String = "Hello World"

    /**
     * Response to / request
     * 
     * This function is executed when the HTTP route request matches the root URL of the server.  
     * 
     *  The annotation [GetMapping] maps a 'get' request 
     *  to a methodpassinf the "/" path as a patameter.
     *  The method returns the string "welcome", which is
     *  the view for response.
     *
     * @param model the model in MVC (Model-View-Controller pattern)
     * @return the name of the view in MVC
     */
    @GetMapping("/")
    fun welcome(model: MutableMap<String,Any>): String {
        model["message"] =  message
        return "welcome"
    }

    /**
     * Response to /date request
     *
     * This function is executed when the HTTP route request matches the root URL of the server.
     *
     * @return string of how mane days are left till the end of the semester as an HTTP response.
     *
     *         ResponseEntity represents an HTTP response, including headers, body and status.
     */
    @GetMapping("/date")
    fun date(): ResponseEntity<String> {
        val fmt = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        val end = fmt.parse("22/12/2022 00:00:00")
        val milliseconds = end.time - System.currentTimeMillis()
        val days = (milliseconds / (1000 * 3600 * 24))
        val weeks = days.div(7)
        val response: String = "Quedan " + weeks + " semanas y " +
                days % 7 + " días de cuatrimestre"
        val headers = HttpHeaders()
        return ResponseEntity(response , headers, HttpStatus.OK)
    }
}
