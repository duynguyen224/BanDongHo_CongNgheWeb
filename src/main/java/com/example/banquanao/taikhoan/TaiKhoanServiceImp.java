package com.example.banquanao.taikhoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaiKhoanServiceImp implements TaiKhoanService{
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public void themTaiKhoan(TaiKhoan taikhoan) {taiKhoanRepository.save(taikhoan);
    }

    @Override
    public void xoaTaiKhoan(Long id) {
        TaiKhoan taikhoan = taiKhoanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OPPS, lỗi mất rồi"));
        taiKhoanRepository.delete(taikhoan);
    }
    @Override
    public List<TaiKhoan> tatCaTaiKhoan() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public void suaTaiKhoan(TaiKhoan taiKhoan) {
        TaiKhoan taikhoanCu = taiKhoanRepository.findById(taiKhoan.getId())
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        taikhoanCu.setTentaikhoan(taiKhoan.getTentaikhoan());
        taikhoanCu.setMatkhau(taiKhoan.getMatkhau());

        taiKhoanRepository.save(taikhoanCu);
    }

    @Override
    public TaiKhoan timKiemTaiKhoan(Long id) {
        return taiKhoanRepository.findById(id).orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
    }
}
