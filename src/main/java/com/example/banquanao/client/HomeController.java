package com.example.banquanao.client;

import com.example.banquanao.sanpham.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private SanPhamService sanPhamService;

    @RequestMapping(value = {"home", ""})
    public String home(Model model){
        model.addAttribute("danhsachsanpham", sanPhamService.tatCaSanPham());
        return "client/home";
    }

    @RequestMapping("dang-nhap")
    public String dangnhap(){
        return "admin/dangnhap";
    }

}
