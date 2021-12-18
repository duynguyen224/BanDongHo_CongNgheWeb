package com.example.banquanao.danhmuc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DanhMucController {
    @GetMapping("danhmuc")
    public String danhmuc(){
        return "admin/danhmuc";
    }
}
