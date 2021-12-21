package com.example.banquanao.chitietdonhang;

import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.sanpham.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ChiTietDonHangServiceImp implements  ChiTietDonHangService{
    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Override
    public void themDongSanPham(DonHang donHang, SanPham sanPham, Long soluongmua) {
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
        chiTietDonHang.setDonhang(donHang);
        chiTietDonHang.setSanpham(sanPham);
        chiTietDonHang.setSoluongmua(soluongmua);
        chiTietDonHang.setThanhtien(sanPham.getGiaban().multiply(BigDecimal.valueOf(soluongmua)));
        chiTietDonHangRepository.save(chiTietDonHang);
    }

    @Override
    public List<ChiTietDonHang> timChiTietDonHang(Long idDonHang) {
        return chiTietDonHangRepository.timChiTietDonHang(idDonHang);
    }
}
