package com.example.banquanao.kichco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KichCoController {
    @GetMapping("kichco")
    public String kichco(){
        return "admin/kichco";
    }
}
