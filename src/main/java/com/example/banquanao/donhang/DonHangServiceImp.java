package com.example.banquanao.donhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DonHangServiceImp implements DonHangService {
    @Autowired
    private DonHangRepository donHangRepository;

    //    BigDecimal tongtien
    public void themDonHang(DonHang donHang, BigDecimal tongtien) {
        donHang.setNgaylap(LocalDate.now());
        donHang.setTrangthai("dangxuly");
        donHang.setTongtien(tongtien);
        donHangRepository.save(donHang);
    }

    @Override
    public DonHang donHangMoiNhat() {
        return donHangRepository.donHangMoiNhat();
    }

    @Override
    public List<DonHang> tatCaDonHang() {
        return donHangRepository.findAll();
    }
    @Override
    public DonHang timKiemDonHang(Long id) {
        return donHangRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("OPPS, lỗi mất rồi"));
    }
    @Override
    public void suaDonHang(DonHang donhang) {
        DonHang donhangCu = donHangRepository.findById(donhang.getId())
                .orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
        donhangCu.setTrangthai(donhang.getTrangthai());
        donHangRepository.save(donhangCu);
    }


}
