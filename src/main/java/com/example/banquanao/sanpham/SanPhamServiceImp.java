package com.example.banquanao.sanpham;

import com.example.banquanao.danhmuc.DanhMuc;
import com.example.banquanao.thuonghieu.ThuongHieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SanPhamServiceImp implements SanPhamService {
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

    @Override
    public void suaSanPham(SanPham sanpham) {
        SanPham sanphamCu = sanPhamRepository.findById(sanpham.getId())
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        sanphamCu.setTensanpham(sanpham.getTensanpham());
        sanphamCu.setGiaban(sanpham.getGiaban());
        sanphamCu.setGioitinh(sanpham.getGioitinh());
        sanphamCu.setTongsoluong(sanpham.getTongsoluong());

        // nếu có thay đổi ảnh mới


        // nếu ảnh không có thay đổi gì
        if(!sanpham.getAnhchinh().equals("/image_upload/")){
            sanphamCu.setAnhchinh(sanpham.getAnhchinh().substring(14));
        }
        if(!sanpham.getAnhphu1().equals("/image_upload/")){
            sanphamCu.setAnhphu1(sanpham.getAnhphu1().substring(14));
        }
        if(!sanpham.getAnhphu2().equals("/image_upload/")){
            sanphamCu.setAnhphu2(sanpham.getAnhphu2().substring(14));
        }
        if(!sanpham.getAnhphu3().equals("/image_upload/")){
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
        return sanPhamRepository.findAll().subList(1, 5);
    }

    @Override
    public List<SanPham> timTheoGioiTinh(String gioitinh) {
        return sanPhamRepository.timKiemTheoGioiTinh(gioitinh);
    }

    @Override
    public List<SanPham> timTheoTenSanPham(String ten) {
        return sanPhamRepository.timKiemTheoTenSanPham(ten);
    }

    @Override
    public List<SanPham> timKiemTheoThuongHieu(ThuongHieu thuonghieu) {
        return sanPhamRepository.timKiemSanPhamTheoThuongHieu(thuonghieu);
    }

}
