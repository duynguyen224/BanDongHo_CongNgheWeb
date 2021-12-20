package com.example.banquanao.sanpham;

import com.example.banquanao.danhmuc.DanhMuc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SanPhamServiceImp implements SanPhamService{
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> tatCaSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public void themSanPham(SanPham sanpham) {
        sanpham.setSlug(sanpham.getTensanpham());
        sanPhamRepository.save(sanpham);
    }

    @Override
    public void xoaSanPham(Long id) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        // nó còn relationship tới chitietkichco
        sanPhamRepository.delete(sanPham);
    }

    @Override
    public void suaSanPham(SanPham sanpham) {
        SanPham sanphamCu = sanPhamRepository.findById(sanpham.getId())
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        sanphamCu.setTensanpham(sanpham.getTensanpham());
        sanphamCu.setGiaban(sanpham.getGiaban());
        sanphamCu.setGioitinh(sanpham.getGioitinh());
        // thêm đủ các trường sửa vào đây
        // tôi đang mắc cái ảnh nên chưa làm
        sanPhamRepository.save(sanphamCu);
    }

    @Override
    public SanPham timKiemSanPham(Long id) {
        return sanPhamRepository.findById(id).orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
    }

}
