package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.UserInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

//    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)  //GetMapping(value=parameter)
    @GetMapping("/query")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "1";
    }
    @PostMapping("/post")
    public String sayHello(@RequestBody UserInfo userInfo){
        return "Hello" + userInfo.getFirstname() + " " + userInfo.getLastname() + "!";
    }

    @PutMapping("/put/{firstname}/{lastname}")
    public String sayHello(@PathVariable String firstname, @PathVariable String lastname) {
        return "Hello " + firstname + " " + lastname;
    }
}
