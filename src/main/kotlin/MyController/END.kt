import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, World!"
    }
}
