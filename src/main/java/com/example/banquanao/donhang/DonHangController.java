package com.example.banquanao.donhang;

import com.example.banquanao.chitietdonhang.ChiTietDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/don-hang")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;
    @Autowired
    private ChiTietDonHangService chiTietDonHangService;

    @RequestMapping("")
    public String donhang(Model model) {
        model.addAttribute("danhsachdonhang", donHangService.tatCaDonHang());
        return "admin/donhang";
    }

    @GetMapping("xem-don-hang/{id}")
    public String xem(@PathVariable(name = "id") Long id, Model model, Model modelChiTietDonHang) {
        model.addAttribute("donhang", donHangService.timKiemDonHang(id));
        Long idDonHang = donHangService.timKiemDonHang(id).getId();
        modelChiTietDonHang.addAttribute("chitietdonhang", chiTietDonHangService.timChiTietDonHang(idDonHang));
        return "admin/donhang_xem";
    }

    @PostMapping("xem-don-hang/{id}")
    public String sua(@ModelAttribute DonHang donHang, @PathVariable(name = "id") Long id) {
        donHangService.suaDonHang(donHang);
        return "redirect:/admin/don-hang";
    }


}
