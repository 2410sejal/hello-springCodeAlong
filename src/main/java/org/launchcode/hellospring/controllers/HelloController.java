package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public String helloUsingQueryParameter(@RequestParam String name, Model model){
        String greetings = "Hello "+ name +"!";
        model.addAttribute("greeting",greetings);
        return "hello";
    }
//    handels request using path parameter /hello/sejal
    @GetMapping("hello/{name}")
    public String helloUsingPathVariable(@PathVariable String name, Model model){
        String greetings = "Hello "+ name +"!";
        model.addAttribute("greeting",greetings);
        return "hello";
//        return "redirect:/hello";
    }

    @GetMapping("form")
    public String helloUsingForm(){
        return "form";

    }

    @GetMapping("hellonames")
    public String nameList(Model model){
        List<String> namelist = new ArrayList<>();
        namelist.add("Sejal");
        namelist.add("Sandeep");
        namelist.add("saksham");
        namelist.add("Shreya");
        model.addAttribute("names",namelist);
        return "hello-list";
    }

    @GetMapping("coffee")
    public String coffeeList(Model model){
        List<String> coffeelist = new ArrayList<>();
        coffeelist.add("French Roast");
        coffeelist.add("Espresso");
        coffeelist.add("Kopi Luwak");
        coffeelist.add("Instant");
        model.addAttribute("coffeeOptions ",coffeelist );
        return "chapter-example-coffeeTemplate";
    }



}
