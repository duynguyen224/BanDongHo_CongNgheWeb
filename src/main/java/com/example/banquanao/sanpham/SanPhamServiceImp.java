package com.example.banquanao.sanpham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SanPhamServiceImp implements SanPhamService{
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public void themSanPham(SanPham sanpham) {
        sanPhamRepository.save(sanpham);
    }

    @Override
    public void xoaSanPham(Long id) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OPPS, lỗi mất rồi"));
        // nó còn relationship tới chitietkichco
        sanPhamRepository.delete(sanPham);
    }

    @Override
    public SanPham xemSanPham(Long id) {
        SanPham sanpham = sanPhamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OPPS, lỗi mất rồi"));
        return sanpham;
    }
}
