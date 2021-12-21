package com.example.banquanao.client;

import com.example.banquanao.sanpham.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("san-pham")
public class ClientSanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("")
    public String sanpham(Model model){
        model.addAttribute("danhsachsanpham", sanPhamService.tatCaSanPham());
        return "client/sanpham";
    }

    // đây là hàm lọc theo giới tính
    @GetMapping("gioi-tinh/{gioitinh}")
    public String sanpham_gioitinh(@PathVariable(name = "gioitinh") String gioitinh, Model model){
        model.addAttribute("danhsachsanpham", sanPhamService.timTheoGioiTinh(gioitinh));
        return "client/sanpham";
    }

    // đây là hàm tìm kiếm tên sản phẩm
    @GetMapping("search")
    public String sanpham_search_theo_ten(@RequestParam(name = "search_tensanpham") String tensanpham, Model model){
        model.addAttribute("danhsachsanpham", sanPhamService.timTheoTenSanPham(tensanpham));
        return "client/sanpham";
    }

    @GetMapping("chi-tiet-san-pham/{id}")
    public String chitiettheoid(@PathVariable(name = "id") Long id, Model model, Model modelSanPhamTuongTu){
        // tìm sản phẩm theo id và show nó lên
        model.addAttribute("sanpham", sanPhamService.timKiemSanPham(id));
        modelSanPhamTuongTu.addAttribute("sanphamtuongtu", sanPhamService.lay4SanPham());
        return "client/chitietsanpham";
    }

    @GetMapping("chi-tiet-san-pham_/{id}")
    public String chitiettheoid_(@PathVariable(name = "id") Long id, Model model, Model modelSanPhamTuongTu){
        // tìm sản phẩm theo id và show nó lên
        model.addAttribute("sanpham", sanPhamService.timKiemSanPham(id));
        //modelSanPhamTuongTu.addAttribute("sanphamtuongtu", sanPhamService.lay4SanPham());
        return "client/chitietsanpham_";
    }

}
