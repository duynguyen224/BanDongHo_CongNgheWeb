package com.example.banquanao.chitietdonhang;

import com.example.banquanao.donhang.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, Long> {

    @Query(value = "select * from ChiTietDonHang ctdh where ctdh.madonhang = ?1", nativeQuery = true)
    public List<ChiTietDonHang> timChiTietDonHang(Long idDonHang);
}
