package com.example.banquanao.danhmuc;

import com.example.banquanao.sanpham.SanPham;
import com.example.banquanao.utils.Slug;
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
@Table(name = "danhmuc")

public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug;
    private String tendanhmuc;

    @OneToMany(mappedBy = "danhmuc")
    private List<SanPham> sanphams;

    public void setSlug(String slug) {
        this.slug = Slug.toSlug(slug);
    }
}
