package com.example.banquanao.client;

import com.example.banquanao.sanpham.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("san-pham")
public class ClientSanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("")
    public String sanpham(){
        return "client/sanpham";
    }

    @GetMapping("chi-tiet-san-pham")
    public String chitiet(){
        // tìm sản phẩm theo id và show nó lên

        return "client/chitietsanpham";
    }

    @GetMapping("chi-tiet-san-pham/{id}")
    public String chitiettheoid(@PathVariable(name = "id") Long id, Model model){
        // tìm sản phẩm theo id và show nó lên

        return "client/chitietsanpham";
    }

}
