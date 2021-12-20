package com.example.banquanao.sanpham;

import com.example.banquanao.danhmuc.DanhMuc;
import com.example.banquanao.danhmuc.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
@RequestMapping("admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private DanhMucService danhMucService;

    @RequestMapping("")
    public String sanpham(Model model) {
        model.addAttribute("danhsachsanpham", sanPhamService.tatCaSanPham());
        return "admin/sanpham";
    }


    @GetMapping("them-moi-san-pham")
    public String themmoi(Model modelsanpham, Model danhsachdanhmuc){
        modelsanpham.addAttribute("sanpham", new SanPham());
        danhsachdanhmuc.addAttribute("danhsachdanhmuc", danhMucService.tatCaDanhMuc());
        return "admin/sanpham_them";
    }

    @PostMapping("them-moi-san-pham")
    public String themmoi(@ModelAttribute SanPham sanpham) throws IOException {
        sanPhamService.themSanPham(sanpham);
        return "redirect:/admin/san-pham";
    }

    @GetMapping("sua-san-pham/{id}")
    public String sua(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("sanpham", sanPhamService.timKiemSanPham(id));
        return "admin/sanpham_sua";
    }

    @PostMapping("sua-san-pham/{id}")
    public String sua(@ModelAttribute SanPham sanpham, @PathVariable(name = "id") Long id){
        sanPhamService.suaSanPham(sanpham);
        return "redirect:/admin/san-pham";
    }

    @GetMapping("xem-san-pham/{id}")
    public String xem(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("sanpham", sanPhamService.timKiemSanPham(id));
        return "admin/sanpham_xem";
    }

    @GetMapping("xoa-san-pham/{id}")
    public String xoa(@PathVariable(name = "id") Long id) {
        sanPhamService.xoaSanPham(id);
        return "redirect:/admin/san-pham";
    }

}
