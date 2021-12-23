package com.example.banquanao.client;

import com.example.banquanao.sanpham.SanPhamService;
import com.example.banquanao.thuonghieu.ThuongHieu;
import com.example.banquanao.thuonghieu.ThuongHieuService;
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
    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping("")
    public String sanpham(Model modelSanPham, Model modelThuongHieu){
        modelSanPham.addAttribute("danhsachsanpham", sanPhamService.tatCaSanPham());
        modelThuongHieu.addAttribute("danhsachthuonghieu", thuongHieuService.tatCaThuongHieu());
        return "client/sanpham";
    }

    // đây là hàm lọc theo giới tính
    @GetMapping("gioi-tinh/{gioitinh}")
    public String sanpham_gioitinh(@PathVariable(name = "gioitinh") String gioitinh, Model model, Model modelThuongHieu){
        model.addAttribute("danhsachsanpham", sanPhamService.timTheoGioiTinh(gioitinh));
        modelThuongHieu.addAttribute("danhsachthuonghieu", thuongHieuService.tatCaThuongHieu());
        return "client/sanpham";
    }

    // đây là hàm lọc theo giới tính
    @GetMapping("thuong-hieu/{thuonghieu}")
    public String sanpham_thuonghieu(@PathVariable(name = "thuonghieu") String tenthuonghieu, Model model, Model modelThuongHieu){
        ThuongHieu thuonghieu = thuongHieuService.timKiemThuongHieuTheoTen(tenthuonghieu); // tìm kiếm thương hiệu từ tên thương hiệu
        model.addAttribute("danhsachsanpham", sanPhamService.timKiemTheoThuongHieu(thuonghieu));
        modelThuongHieu.addAttribute("danhsachthuonghieu", thuongHieuService.tatCaThuongHieu());
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
