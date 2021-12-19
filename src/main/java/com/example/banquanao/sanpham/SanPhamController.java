package com.example.banquanao.sanpham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("")
    public String sanpham(Model model) {
        model.addAttribute("danhsachsanpham", sanPhamRepository.findAll());
        return "admin/sanpham";
    }


    @PostMapping("them-moi-san-pham")
    public String themmoi(SanPham sanpham) throws IOException {
        sanPhamService.themSanPham(sanpham);
        return "redirect:/admin/san-pham";
    }

    @GetMapping("chi-tiet-san-pham/{id}")
    public String chitiet(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("sanpham", sanPhamService.xemSanPham(id));
        return "redirect:/admin/san-pham";
    }

    @GetMapping("xoa-san-pham/{id}")
    public String xoa(@PathVariable(name = "id") Long id) {
        sanPhamService.xoaSanPham(id);
        return "redirect:/admin/san-pham";
    }

}
