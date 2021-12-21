package com.example.banquanao.donhang;

import com.example.banquanao.chitietdonhang.ChiTietDonHang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "donhang")

public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate ngaylap;
    private String trangthai;
    private String diachigiaohang;
    private String sodienthoai;
    private String tenkhachhang;
    private String email;
    private BigDecimal tongtien;

    @OneToMany(mappedBy = "donhang")
    private List<ChiTietDonHang> chitietdonhangs;

}