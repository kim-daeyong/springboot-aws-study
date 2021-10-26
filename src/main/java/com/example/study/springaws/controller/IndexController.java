package com.example.study.springaws.controller;

import javax.servlet.http.HttpSession;

import com.example.study.springaws.config.auth.LoginUser;
import com.example.study.springaws.config.auth.dto.SessionUser;
import com.example.study.springaws.service.posts.PostsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
        // 머스타치 스타터 덕분에 경로와 파일 확장자는 자동으로 지정된다.
        // src/main/resources/templates/index.mustache 로 전환되어 View Resolver가 처리
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("post", postsService.findById(id));
        return "posts-update";
    }
}
