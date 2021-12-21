package com.example.banquanao.client.shoppingcart;

import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.sanpham.SanPham;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {
    public void themSanPhamVaoGio(SanPham sanPham);
    public void xoaSanPhamTrongGio(SanPham sanPham);
    public Map<SanPham, Integer> sanPhamTrongGioHang();
    public BigDecimal tinhTongTien();
    public void thanhToan(DonHang donhang);
}
