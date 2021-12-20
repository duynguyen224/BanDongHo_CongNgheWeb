package com.example.banquanao.thuonghieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("admin/thuong-hieu")
public class ThuongHieuController {
    @Autowired
    private ThuongHieuService thuongHieuService;

    @RequestMapping("")
    public String thuonghieu(Model model) {
        model.addAttribute("danhsachthuonghieu", thuongHieuService.tatCaThuongHieu());
        return "admin/thuonghieu";
    }
    @PostMapping("them-moi-thuong-hieu")
    public String themmoi(ThuongHieu thuonghieu) throws IOException {
        thuongHieuService.themThuongHieu(thuonghieu);
        return "redirect:/admin/thuong-hieu";
    }
    @GetMapping("xoa-thuong-hieu/{id}")
    public String xoa(@PathVariable(name = "id") Long id) {
        thuongHieuService.xoaThuongHieu(id);
        return "redirect:/admin/thuong-hieu";
    }

    @GetMapping("sua-thuong-hieu/{id}")
    public String sua(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("thuonghieu", thuongHieuService.timKiemThuongHieu(id));
        return "admin/thuonghieu_sua";
    }

    @PostMapping("sua-thuong-hieu/{id}")
    public String sua(@ModelAttribute ThuongHieu thuonghieu, @PathVariable(name = "id") Long id){
        thuongHieuService.suaThuongHieu(thuonghieu);
        return "redirect:/admin/thuong-hieu";
    }
    @GetMapping("xem-thuong-hieu/{id}")
    public String xem(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("thuonghieu", thuongHieuService.timKiemThuongHieu(id));
        return "admin/thuonghieu_xem";
    }

}
