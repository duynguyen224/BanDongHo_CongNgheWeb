package com.example.banquanao.client;

import com.example.banquanao.sanpham.SanPhamService;
import com.example.banquanao.taikhoan.TaiKhoan;
import com.example.banquanao.taikhoan.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @RequestMapping(value = {"home", ""})
    public String home(Model model){
        model.addAttribute("danhsachsanpham", sanPhamService.tatCaSanPham());
        return "client/home";
    }

    @GetMapping("admin/dang-nhap")
    public String dangnhap(Model model){
        model.addAttribute("taikhoan", new TaiKhoan());
        return "admin/dangnhap";
    }

    @PostMapping("/admin/dang-nhap")
    public String login(@ModelAttribute TaiKhoan taikhoan){
        if(taiKhoanService.kiemTraDangNhap(taikhoan.getTentaikhoan(), taikhoan.getMatkhau())){
            return "redirect:/admin";
        }else{
            return "redirect:/admin/dang-nhap";
        }
    }

}
