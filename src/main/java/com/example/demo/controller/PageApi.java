package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取页面
 *
 * @author 杨正
 */
@Controller
@RequestMapping("/page")
public class PageApi {

    @RequestMapping("{page}")
    public String page(@PathVariable String page, Model model) {
        model.addAttribute("name", "杨正");
        System.out.println("跳转的页面为：" + page);
        return page;
    }
}
