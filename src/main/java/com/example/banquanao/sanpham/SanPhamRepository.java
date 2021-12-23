package com.example.banquanao.sanpham;

import com.example.banquanao.thuonghieu.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    @Query("SELECT s FROM SanPham s WHERE s.gioitinh LIKE %:gioitinh%")
    List<SanPham> timKiemTheoGioiTinh(@Param("gioitinh") String gioitinh);

    @Query("SELECT s FROM SanPham s WHERE s.tensanpham LIKE %:tensanpham%")
    List<SanPham> timKiemTheoTenSanPham(@Param("tensanpham") String tensanpham);

    @Query("SELECT s FROM SanPham s WHERE s.thuonghieu = ?1 ")
    List<SanPham> timKiemSanPhamTheoThuongHieu(ThuongHieu thuongHieu);

}
