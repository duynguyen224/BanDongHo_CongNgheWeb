package com.example.banquanao.chitietdonhang;

import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.sanpham.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chitietdonhang")

public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long soluongmua;
    @Transient
    private BigDecimal thanhtien;

    @ManyToOne
    @JoinColumn(name = "madonhang", referencedColumnName = "id")
    private DonHang donhang;

    @ManyToOne
    @JoinColumn(name = "masanpham", referencedColumnName = "id")
    private SanPham sanpham;

    public BigDecimal getThanhtien() {
        return sanpham.getGiaban().multiply(BigDecimal.valueOf(soluongmua));
    }
}
