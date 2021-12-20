package com.example.banquanao.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gio-hang")
public class ClientGioHangController {
    @GetMapping("")
    public String giohang(){
        return "client/giohang";
    }
}
