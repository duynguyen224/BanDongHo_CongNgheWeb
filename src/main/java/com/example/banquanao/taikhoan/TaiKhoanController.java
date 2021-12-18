package com.example.banquanao.taikhoan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaiKhoanController {
    @GetMapping("taikhoan")
    public String taikhoan(){
        return "admin/taikhoan";
    }
}
