package com.saravana.myproject1;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello() {
        return "Hello! This is Saravana's Project";
    }

    @RequestMapping(value="/hello/{id}",method=RequestMethod.GET)
    public String sayHello(@PathVariable("id") String id) {
        return "Hello! This is " +id+"'s Project ";
    }
}
/*
Learned these

RestController
RequestMapping
RequestMethod
PathVariable

 */

