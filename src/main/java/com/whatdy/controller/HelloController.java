package com.whatdy.controller;

import com.whatdy.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "say",method = RequestMethod.GET)

    public String say(){
        return  girlProperties.getCupSize();
    }
    @RequestMapping(value = "say1/{id}",method = RequestMethod.GET)

    public String say1(@PathVariable(value = "id") Integer id){
        return  "id:"+id;
    }
    @RequestMapping(value = "say2",method = RequestMethod.GET)
    public String say2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return  "id:"+id;
    }


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }



}
