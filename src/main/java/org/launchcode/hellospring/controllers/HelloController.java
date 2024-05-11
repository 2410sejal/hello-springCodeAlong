package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
//    handles request at path /hello
    @RequestMapping(value="hello",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String hello(String name){
        return "Hello "+ name + "!";
    }
//handles request at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye,Spring!";
    }
//    hendels request using query param /queryparam?name=sejal
    @GetMapping("queryparam")
    @ResponseBody
    public String helloUsingQueryParameter(@RequestParam String name){
        return " Hello "+ name + " ! ";
    }
//    handels request using path parameter /hello/sejal
    @GetMapping("hello/{name}")
//    @ResponseBody
    public String helloUsingPathVariable(@PathVariable String name){
        return " Hello "+ name + " ! ";
//        return "redirect:/hello";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloUsingForm(){
        return "<html>"+
                    "<body>"+
                        "<form action = 'hello' method = 'post'>"+
                             "<input type ='text' name='name'/>"+
                             "<input type ='Submit' Value= 'Click here'/>"+
                         "</form>" +
                     "</body>" +
                "</html>";
    }

}
