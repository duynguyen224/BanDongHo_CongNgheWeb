package com.example.banquanao.taikhoan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/tai-khoan")
public class TaiKhoanController {
    @GetMapping
    public String taikhoan(){
        return "admin/taikhoan";
    }
}
