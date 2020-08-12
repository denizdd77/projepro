

// HTTP requests are handled by a controller. These components are identified by the @RestController annotation
// handles GET requests for /greeting by returning a new instance of the Greeting class:

// GetMapping annotation, ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
package com.example.restservice.demo;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.demo.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class    GreetingController {

    private static final String template = "Date: %s!";
    private final AtomicLong counter = new AtomicLong();

   //public String controlList(@RequestBody List<Emre> tickets) {


    @GetMapping("/Tickets")
    public String controlList(String tickets) {
        Ticket t = new Ticket();
        return ";";

    }


    // @RequestMapping(value = "/greeting", method = RequestMethod.POST)

    /*@PostMapping("/greetings")
    public  @ResponseBody
    Greeting greeting(@RequestParam(value = "name", defaultValue = "11/08/2020 , 14:37") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

     */


}