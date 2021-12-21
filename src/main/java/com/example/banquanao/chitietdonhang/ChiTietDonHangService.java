package com.example.banquanao.chitietdonhang;

import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.sanpham.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChiTietDonHangService {
    public void themDongSanPham(DonHang donHang, SanPham sanPham, Long soluongmua);

    public List<ChiTietDonHang> timChiTietDonHang(Long idDonHang);
}
