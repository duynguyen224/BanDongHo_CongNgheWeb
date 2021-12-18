package com.example.banquanao.chitietdonhang;

import com.example.banquanao.chitietkichco.ChiTietKichCo;
import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.kichco.KichCo;
import com.example.banquanao.sanpham.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private Integer soluongmua;

    @ManyToOne
    @JoinColumn(name = "madonhang", referencedColumnName = "id")
    private DonHang donhang;

    @ManyToOne
    @JoinColumn(name = "machitietkichco", referencedColumnName = "id")
    private ChiTietKichCo chitietkichco;


}
