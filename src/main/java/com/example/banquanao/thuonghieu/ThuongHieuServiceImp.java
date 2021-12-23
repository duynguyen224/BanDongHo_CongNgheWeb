package com.example.banquanao.thuonghieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThuongHieuServiceImp implements ThuongHieuService{
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    @Override
    public void themThuongHieu(ThuongHieu thuonghieu) {thuongHieuRepository.save(thuonghieu);
    }

    @Override
    public void xoaThuongHieu(Long id) {
        ThuongHieu thuonghieu = thuongHieuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OPPS, lỗi mất rồi"));
        thuonghieu.setIsDelete(true);
        thuongHieuRepository.save(thuonghieu);
    }

    @Override
    public List<ThuongHieu> tatCaThuongHieu() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public void suaThuongHieu(ThuongHieu thuonghieu) {
        ThuongHieu thuonghieuCu = thuongHieuRepository.findById(thuonghieu.getId())
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        thuonghieuCu.setTenthuonghieu(thuonghieu.getTenthuonghieu());
        thuonghieuCu.setMota(thuonghieu.getMota());

        thuongHieuRepository.save(thuonghieuCu);
    }

    @Override
    public ThuongHieu timKiemThuongHieu(Long id) {
        return thuongHieuRepository.findById(id).orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
    }

    @Override
    public ThuongHieu timKiemThuongHieuTheoTen(String tenthuonghieu) {
        return thuongHieuRepository.timKiemThuongHieuTheoTen(tenthuonghieu);
    }

}
