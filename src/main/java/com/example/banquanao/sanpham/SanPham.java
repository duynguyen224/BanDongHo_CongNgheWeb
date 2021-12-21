package com.example.banquanao.sanpham;

import com.example.banquanao.chitietdonhang.ChiTietDonHang;
import com.example.banquanao.danhmuc.DanhMuc;
import com.example.banquanao.thuonghieu.ThuongHieu;
import com.example.banquanao.utils.Slug;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
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
    //private Float giaban;
    private BigDecimal giaban;
    private Integer tongsoluong;
    private String anhchinh;
    private String anhphu1;
    private String anhphu2;
    private String anhphu3;
    private String slug;
    private String mota;
    private String gioitinh;
    private Boolean isDelete = false;
    @Transient
    private BigDecimal thanhtien;

    @ManyToOne
    @JoinColumn(name = "madanhmuc", referencedColumnName = "id")
    private DanhMuc danhmuc;

    @ManyToOne
    @JoinColumn(name = "mathuonghieu", referencedColumnName = "id")
    private ThuongHieu thuonghieu;

    @OneToMany(mappedBy = "sanpham")
    private List<ChiTietDonHang> chitietdonhangs;

    public void setSlug(String slug) {
        this.slug = Slug.toSlug(slug);
    }

    public void setAnhchinh(String anhchinh) {
        this.anhchinh = "/image_upload/" + anhchinh;
    }

    public void setAnhphu1(String anhphu1) {
        this.anhphu1 = "/image_upload/" + anhphu1;
    }
    public void setAnhphu2(String anhphu2) {
        this.anhphu2 = "/image_upload/" + anhphu2;
    }
    public void setAnhphu3(String anhphu3) {
        this.anhphu3 = "/image_upload/" + anhphu3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SanPham sanPham = (SanPham) o;

        return id.equals(sanPham.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
