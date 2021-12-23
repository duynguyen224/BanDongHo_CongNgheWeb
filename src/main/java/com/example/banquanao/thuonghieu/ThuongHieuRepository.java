package com.example.banquanao.thuonghieu;

import com.example.banquanao.sanpham.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Long> {
    @Query("SELECT s FROM ThuongHieu s WHERE s.tenthuonghieu LIKE %:tenthuonghieu%")
    ThuongHieu timKiemThuongHieuTheoTen(@Param("tenthuonghieu") String tenthuonghieu);

}
