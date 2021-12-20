package com.example.banquanao.danhmuc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DanhMucServiceImp implements DanhMucService {
//    @Autowired
//    private DanhMucRepository danhMucRepository;
//
//    @Override
//    public List<DanhMuc> tatCaDanhMuc() {
//        return danhMucRepository.findAll();
//    }

    @Autowired
    private DanhMucRepository danhMucRepository;
    @Override
    public void themDanhMuc(DanhMuc danhmuc) {danhMucRepository.save(danhmuc);
    }

    @Override
    public void xoaDanhMuc(Long id) {
        DanhMuc danhmuc = danhMucRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OPPS, lỗi mất rồi"));
        danhmuc.setIsDelete(true);
        danhMucRepository.save(danhmuc);
    }

    @Override
    public List<DanhMuc> tatCaDanhMuc() {
        return danhMucRepository.findAll();
    }

    @Override
    public void suaDanhMuc(DanhMuc danhmuc) {
        DanhMuc danhmucCu = danhMucRepository.findById(danhmuc.getId())
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        danhmucCu.setTendanhmuc(danhmuc.getTendanhmuc());
        danhmucCu.setMota(danhmuc.getMota());
        danhMucRepository.save(danhmucCu);
    }

    @Override
    public DanhMuc timKiemDanhMuc(Long id) {
        return danhMucRepository.findById(id).orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
    }


}
