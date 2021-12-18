package com.example.banquanao.thuonghieu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThuongHieuController {

    @GetMapping("thuonghieu")
    public String test(){
        return "admin/thuonghieu";
    }

}
