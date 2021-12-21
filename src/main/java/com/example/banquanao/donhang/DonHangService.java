package com.example.banquanao.donhang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface DonHangService{
//    , BigDecimal tongtien
    public void themDonHang(DonHang donHang, BigDecimal tongtien);
    public DonHang donHangMoiNhat();

    public List<DonHang> tatCaDonHang();
    public DonHang timKiemDonHang(Long id);
    public void suaDonHang(DonHang donhang);


}
