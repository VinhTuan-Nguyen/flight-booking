package com.paymentgateway.paymentservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  // Chỉ định HomeController là Controller
public class HomeController {
    // Khi user truy cập vào endpoint / thì homepage() được gọi
    @GetMapping("/")
    public String homepage() {
        return "index";  // Trả về trang index.html
    }

    // @RequestMapping(value = "/")
    // public String index() {
    //   return "index";
    // }
    
    // Có thể mapping thêm các endpoint khác nữa...
}
