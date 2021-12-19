package com.example.banquanao.kichco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/kich-co")
public class KichCoController {
    @GetMapping()
    public String kichco(){
        return "admin/kichco";
    }
}
