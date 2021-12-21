package com.example.banquanao.donhang;

import com.example.banquanao.sanpham.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Long> {

    @Query(value = "select top 1 * from DonHang dh order by dh.id desc", nativeQuery = true)
    public DonHang donHangMoiNhat();

}
