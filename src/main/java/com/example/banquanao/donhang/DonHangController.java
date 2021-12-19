package com.example.banquanao.donhang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/don-hang")
public class DonHangController {
    @GetMapping()
    public String donhang(){
        return "admin/donhang";
    }
}
