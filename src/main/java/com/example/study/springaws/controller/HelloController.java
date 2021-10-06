package com.example.study.springaws.controller;

import com.example.study.springaws.dto.HelloResponseDto;
import com.example.study.springaws.service.posts.PostsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, 
                                        @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
    
}
