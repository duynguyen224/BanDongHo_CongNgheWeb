package com.example.banquanao.sanpham;

import com.example.banquanao.danhmuc.DanhMuc;
import com.example.banquanao.thuonghieu.ThuongHieu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SanPhamService {
    public List<SanPham> tatCaSanPham();
    public void themSanPham(SanPham sanpham);
    public void xoaSanPham(Long id);
    public void suaSanPham(SanPham sanpham);
    public SanPham timKiemSanPham(Long id);
    public List<SanPham> lay4SanPham();
    public List<SanPham> timTheoGioiTinh(String gioitinh);
    public List<SanPham> timTheoTenSanPham(String ten);
    public List<SanPham> timKiemTheoThuongHieu(ThuongHieu thuonghieu);
}
