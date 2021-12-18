package com.example.banquanao.chitietkichco;

import com.example.banquanao.chitietdonhang.ChiTietDonHang;
import com.example.banquanao.kichco.KichCo;
import com.example.banquanao.sanpham.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chitietkichco")

public class ChiTietKichCo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer soluong;

    @ManyToOne
    @JoinColumn(name = "makichco", referencedColumnName = "id")
    private KichCo kichco;

    @ManyToOne
    @JoinColumn(name = "masanpham", referencedColumnName = "id")
    private SanPham sanpham;

    @OneToMany(mappedBy = "chitietkichco")
    private List<ChiTietDonHang> chitietdonhangs;


}
