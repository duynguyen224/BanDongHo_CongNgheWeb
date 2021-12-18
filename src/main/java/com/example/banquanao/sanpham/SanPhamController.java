package com.example.banquanao.sanpham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping("sanpham")
    public String sanpham(Model model){
        model.addAttribute("danhsachsanpham", sanPhamRepository.findAll());
        return "admin/sanpham";
    }
}
