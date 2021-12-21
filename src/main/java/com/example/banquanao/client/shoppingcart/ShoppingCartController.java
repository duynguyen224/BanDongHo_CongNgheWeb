package com.example.banquanao.client.shoppingcart;

import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.donhang.DonHangService;
import com.example.banquanao.sanpham.SanPham;
import com.example.banquanao.sanpham.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("gio-hang")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private DonHangService donHangService;

    @GetMapping("")
    public String giohang(Model modelGiohang, Model ModelTongTien, Model modelDonHang) throws InterruptedException {
        // dừng 1 giây để hiện cái modal lên cho ngầu
        Thread.sleep(800);
        modelGiohang.addAttribute("giohang", shoppingCartService.sanPhamTrongGioHang());
        ModelTongTien.addAttribute("tongtien", shoppingCartService.tinhTongTien());
        modelDonHang.addAttribute("donhang", new DonHang());
        return "client/giohang";
    }

    @GetMapping("them-vao-gio/{id}")
    public String themVaoGio(@PathVariable(name = "id") Long id){
        SanPham sanPham = sanPhamService.timKiemSanPham(id);
        shoppingCartService.themSanPhamVaoGio(sanPham);
        return "redirect:/gio-hang";
    }

//    , @RequestParam(name = "tongtien")BigDecimal tongtien
    @PostMapping("thanh-toan")
    public String thanhToan(@ModelAttribute DonHang donhang){
        donHangService.themDonHang(donhang, shoppingCartService.tinhTongTien());
        shoppingCartService.thanhToan(donHangService.donHangMoiNhat());
        return "client/thanhcong";
    }
}