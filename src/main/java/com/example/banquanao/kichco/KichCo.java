package com.example.banquanao.kichco;

import com.example.banquanao.chitietkichco.ChiTietKichCo;
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
@Table(name = "kichco")

public class KichCo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenkichco;
    private String mota;

    @OneToMany(mappedBy = "kichco")
    private List<ChiTietKichCo> chitietkichcos;
}