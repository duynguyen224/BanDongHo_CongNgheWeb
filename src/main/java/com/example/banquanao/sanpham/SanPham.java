package com.example.banquanao.sanpham;

import com.example.banquanao.chitietkichco.ChiTietKichCo;
import com.example.banquanao.loaisanpham.DanhMuc;
import com.example.banquanao.thuonghieu.ThuongHieu;
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
@Table(name = "sanpham")

public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tensanpham;
    private Float giaban;
    private Integer tongsoluong;
    private String anhchinh;
    private String anhphu1;
    private String anhphu2;
    private String anhphu3;
    private String slug;
    private String mota;
    private Boolean gioitinh;

    @ManyToOne
    @JoinColumn(name = "maloaisanpham", referencedColumnName = "id")
    private DanhMuc loaisanpham;

    @ManyToOne
    @JoinColumn(name = "mathuonghieu", referencedColumnName = "id")
    private ThuongHieu thuonghieu;

    @OneToMany(mappedBy = "sanpham")
    private List<ChiTietKichCo> chitietkichcos;
}
