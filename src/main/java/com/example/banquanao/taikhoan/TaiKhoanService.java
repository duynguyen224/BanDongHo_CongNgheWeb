package com.example.banquanao.taikhoan;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaiKhoanService {
    public void themTaiKhoan(TaiKhoan taikhoan);
    public void xoaTaiKhoan(Long id);
    public List<TaiKhoan> tatCaTaiKhoan();
    public void suaTaiKhoan(TaiKhoan taikhoan);
    public TaiKhoan timKiemTaiKhoan(Long id);
}
