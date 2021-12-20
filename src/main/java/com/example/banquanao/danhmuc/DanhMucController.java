package com.example.banquanao.danhmuc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("admin/danh-muc")
public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;


    @RequestMapping("")
    public String danhmuc(Model model) {
        model.addAttribute("danhsachdanhmuc", danhMucService.tatCaDanhMuc());
        return "admin/danhmuc";
    }
    @PostMapping("them-moi-danh-muc")
    public String themmoi(DanhMuc danhmuc) throws IOException {
        danhMucService.themDanhMuc(danhmuc);
        return "redirect:/admin/danh-muc";
    }
    @GetMapping("xoa-danh-muc/{id}")
    public String xoa(@PathVariable(name = "id") Long id) {
        danhMucService.xoaDanhMuc(id);
        return "redirect:/admin/danh-muc";
    }
    @GetMapping("sua-danh-muc/{id}")
    public String sua(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("danhmuc", danhMucService.timKiemDanhMuc(id));
        return "admin/danhmuc_sua";
    }

    @PostMapping("sua-danh-muc/{id}")
    public String sua(@ModelAttribute DanhMuc danhmuc, @PathVariable(name = "id") Long id){
        danhMucService.suaDanhMuc(danhmuc);
        return "redirect:/admin/danh-muc";
    }
    @GetMapping("xem-danh-muc/{id}")
    public String xem(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("danhmuc", danhMucService.timKiemDanhMuc(id));
        return "admin/danhmuc_xem";
    }
}
