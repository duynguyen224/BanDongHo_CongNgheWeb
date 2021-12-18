package com.example.banquanao.trangchu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
    @GetMapping(value = {"/", "/trangchu"})
    public String trangchu(){
        return "admin/trangchu";
    }
}
