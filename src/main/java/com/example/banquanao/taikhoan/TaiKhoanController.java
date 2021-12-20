package com.example.banquanao.taikhoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("admin/tai-khoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @RequestMapping("")
    public String taikhoan(Model model) {
        model.addAttribute("danhsachtaikhoan", taiKhoanService.tatCaTaiKhoan());
        return "admin/taikhoan";
    }
    @PostMapping("them-moi-tai-khoan")
    public String themmoi(TaiKhoan taiKhoan) throws IOException {
        taiKhoanService.themTaiKhoan(taiKhoan);
        return "redirect:/admin/tai-khoan";
    }
    @GetMapping("xoa-tai-khoan/{id}")
    public String xoa(@PathVariable(name = "id") Long id) {
        taiKhoanService.xoaTaiKhoan(id);
        return "redirect:/admin/tai-khoan";
    }
    @GetMapping("sua-tai-khoan/{id}")
    public String sua(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("taikhoan", taiKhoanService.timKiemTaiKhoan(id));
        return "admin/taikhoan_sua";
    }

    @PostMapping("sua-tai-khoan/{id}")
    public String sua(@ModelAttribute TaiKhoan taikhoan, @PathVariable(name = "id") Long id){
        taiKhoanService.suaTaiKhoan(taikhoan);
        return "redirect:/admin/tai-khoan";
    }
    @GetMapping("xem-tai-khoan/{id}")
    public String xem(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("taikhoan", taiKhoanService.timKiemTaiKhoan(id));
        return "admin/taikhoan_xem";
    }
}
