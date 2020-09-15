package ru.pekchiorckin.rest.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class ReminderController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Greeting greeting() {
        return new Greeting("One", "Привет");

    }

    //    @RequestMapping(value="/post", method = RequestMethod.POST)
//    public void hello(@RequestBody String greeting) {
//        System.out.println(greeting);
//
//    }
//    consumes = "application/json", produces = "application/json"
    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public Greeting createUser(@RequestParam("id") String id, @RequestParam("content") String content) {
        System.out.println(id);
        return new Greeting(id, content);
    }

    @RequestMapping(value = "post1", method = RequestMethod.POST)
    @ResponseBody
    public Greeting createUser(@RequestBody Greeting greeting) {
        System.out.println(greeting);
        return greeting;
    }
}
