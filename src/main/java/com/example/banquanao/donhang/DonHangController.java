package com.example.banquanao.donhang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonHangController {
    @GetMapping("donhang")
    public String donhang(){
        return "admin/donhang";
    }
}
