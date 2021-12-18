package com.example.banquanao.loaisanpham;

import com.example.banquanao.sanpham.SanPham;
import jdk.jfr.Enabled;
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
    private String tenloaisanpham;

    @OneToMany(mappedBy = "loaisanpham")
    private List<SanPham> sanphams;
}
