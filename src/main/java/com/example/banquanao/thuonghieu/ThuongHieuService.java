package com.example.banquanao.thuonghieu;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThuongHieuService {
    public void themThuongHieu(ThuongHieu thuonghieu);
    public void xoaThuongHieu(Long id);
    public List<ThuongHieu> tatCaThuongHieu();
    public void suaThuongHieu(ThuongHieu thuonghieu);
    public ThuongHieu timKiemThuongHieu(Long id);
}
