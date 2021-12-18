package com.example.banquanao.thuonghieu;

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
@Table(name = "thuonghieu")

public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenthuonghieu;

    @OneToMany(mappedBy = "thuonghieu")
    private List<SanPham> sanphams;
}