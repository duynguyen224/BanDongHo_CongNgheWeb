package com.example.banquanao.thuonghieu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/thuong-hieu")
public class ThuongHieuController {

    @GetMapping()
    public String test(){
        return "admin/thuonghieu";
    }

}
