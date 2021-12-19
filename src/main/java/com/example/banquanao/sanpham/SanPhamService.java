package com.example.banquanao.sanpham;

import org.springframework.stereotype.Service;

@Service
public interface SanPhamService {
    public void themSanPham(SanPham sanpham);
    public void xoaSanPham(Long id);
    public SanPham xemSanPham(Long id);
}
