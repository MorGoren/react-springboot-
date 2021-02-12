package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String home(){
        System.out.println("hi");

//        String fileName = "D://Users/morgoren/Downloads/DataFIle.txt";
//
//        //read file into stream, try-with-resources
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//
//            stream.forEach(System.out::println);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return "index.html";
    }

    @GetMapping("greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @PostMapping("message-submit")
    public String submit(String message, String tag, Model model){
        model.addAttribute("message", message);
        model.addAttribute("tag", tag);
        return "home";
    }
}
