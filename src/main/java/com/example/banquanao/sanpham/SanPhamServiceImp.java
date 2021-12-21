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
        sanPham.setIsDelete(true);
        sanPhamRepository.save(sanPham);
    }

//    @Override
//    public void suaSanPham(SanPham sanpham) {
//        SanPham sanphamCu = sanPhamRepository.findById(sanpham.getId())
//                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
//        sanphamCu.setTensanpham(sanpham.getTensanpham());
//        sanphamCu.setGiaban(sanpham.getGiaban());
//        sanphamCu.setGioitinh(sanpham.getGioitinh());
//        sanphamCu.setTongsoluong(sanpham.getTongsoluong());
//        sanphamCu.setAnhchinh(sanpham.getAnhchinh().substring(14));
//        sanphamCu.setAnhphu1(sanpham.getAnhphu1().substring(14));
//        sanphamCu.setAnhphu2(sanpham.getAnhphu2().substring(14));
//        sanphamCu.setAnhphu3(sanpham.getAnhphu3().substring(14));
//        sanPhamRepository.save(sanphamCu);
//    }

    @Override
    public void suaSanPham(SanPham sanpham) {
        SanPham sanphamCu = sanPhamRepository.findById(sanpham.getId())
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        sanphamCu.setTensanpham(sanpham.getTensanpham());
        sanphamCu.setGiaban(sanpham.getGiaban());
        sanphamCu.setGioitinh(sanpham.getGioitinh());
        sanphamCu.setTongsoluong(sanpham.getTongsoluong());

        if(sanphamCu.getAnhchinh().equals(sanpham.getAnhchinh())){
            sanphamCu.setAnhchinh(sanpham.getAnhchinh().substring(14));
        }
        if(sanphamCu.getAnhphu1().equals(sanpham.getAnhphu1())){
            sanphamCu.setAnhphu1(sanpham.getAnhphu1().substring(14));
        }
        if(sanphamCu.getAnhphu2().equals(sanpham.getAnhphu2())){
            sanphamCu.setAnhphu2(sanpham.getAnhphu2().substring(14));
        }
        if(sanphamCu.getAnhphu3().equals(sanpham.getAnhphu3())){
            sanphamCu.setAnhphu3(sanpham.getAnhphu3().substring(14));
        }
        sanPhamRepository.save(sanphamCu);
    }

    @Override
    public SanPham timKiemSanPham(Long id) {
        return sanPhamRepository.findById(id).orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
    }

    @Override
    public List<SanPham> lay4SanPham() {
        return sanPhamRepository.findAll().subList(1,5);
    }

    @Override
    public List<SanPham> timTheoGioiTinh(String gioitinh) {
        return sanPhamRepository.timKiemTheoGioiTinh(gioitinh);
    }

    @Override
    public List<SanPham> timTheoTenSanPham(String ten) {
        return sanPhamRepository.timKiemTheoTenSanPham(ten);
    }

}
