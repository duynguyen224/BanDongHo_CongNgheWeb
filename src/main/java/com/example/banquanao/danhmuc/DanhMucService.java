package com.example.banquanao.danhmuc;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DanhMucService {
    public List<DanhMuc> tatCaDanhMuc();
    public void themDanhMuc(DanhMuc danhmuc);
    public void xoaDanhMuc(Long id);
    public void suaDanhMuc(DanhMuc danhmuc);
    public DanhMuc timKiemDanhMuc(Long id);
}
