package com.example.banquanao;

import com.example.banquanao.chitietdonhang.ChiTietDonHang;
import com.example.banquanao.chitietdonhang.ChiTietDonHangRepository;
import com.example.banquanao.chitietkichco.ChiTietKichCo;
import com.example.banquanao.chitietkichco.ChiTietKichCoRepository;
import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.donhang.DonHangRepository;
import com.example.banquanao.kichco.KichCo;
import com.example.banquanao.kichco.KichCoRepository;
import com.example.banquanao.danhmuc.DanhMuc;
import com.example.banquanao.danhmuc.DanhMucRepository;
import com.example.banquanao.sanpham.SanPham;
import com.example.banquanao.sanpham.SanPhamRepository;
import com.example.banquanao.thuonghieu.ThuongHieu;
import com.example.banquanao.thuonghieu.ThuongHieuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(DanhMucRepository loaiSanPhamRepository
            , SanPhamRepository sanPhamRepository
            , ThuongHieuRepository thuongHieuRepository
            , KichCoRepository kichCoRepository
            , ChiTietKichCoRepository chiTietKichCoRepository
            , DonHangRepository donHangRepository
            , ChiTietDonHangRepository chiTietDonHangRepository){
        return args -> {
            // loai san pham
            DanhMuc quansip = new DanhMuc();
            quansip.setTendanhmuc("quan sip");
            DanhMuc quanjean = new DanhMuc();
            quanjean.setTendanhmuc("quan jean");
            DanhMuc bra = new DanhMuc();
            bra.setTendanhmuc("bra");
            loaiSanPhamRepository.saveAll(List.of(quansip, quanjean, bra));

            // thuong hieu
            ThuongHieu nike = new ThuongHieu();
            nike.setTenthuonghieu("nike");
            ThuongHieu adidas = new ThuongHieu();
            adidas.setTenthuonghieu("adidas");
            ThuongHieu puma = new ThuongHieu();
            puma.setTenthuonghieu("puma");
            thuongHieuRepository.saveAll(List.of(nike, adidas, puma));


            // kich co
            KichCo s = new KichCo();
            s.setTenkichco("s");
            KichCo m = new KichCo();
            m.setTenkichco("m");
            KichCo l = new KichCo();
            l.setTenkichco("l");
            kichCoRepository.saveAll(List.of(s,m,l));


            // san pham
            SanPham sp1 = new SanPham();
            sp1.setTensanpham("áo cộc tay thế hệ mới");
            sp1.setSlug(sp1.getTensanpham());
            sp1.setThuonghieu(nike);
            sp1.setDanhmuc(quansip);

            SanPham sp2 = new SanPham();
            sp2.setTensanpham("san pham 2");
            sp2.setThuonghieu(nike);
            sp2.setDanhmuc(quansip);

            SanPham sp3 = new SanPham();
            sp3.setTensanpham("san pham 3");
            sp3.setThuonghieu(adidas);
            sp3.setDanhmuc(quansip);

            sanPhamRepository.saveAll(List.of(sp1, sp2, sp3));

            // chi tiet kich co
            ChiTietKichCo sp1_s = new ChiTietKichCo();
            sp1_s.setSanpham(sp1);
            sp1_s.setKichco(s);
            sp1_s.setSoluong(100);
            ChiTietKichCo sp1_m = new ChiTietKichCo();
            sp1_m.setSanpham(sp1);
            sp1_m.setKichco(m);
            sp1_m.setSoluong(100);
            ChiTietKichCo sp1_l = new ChiTietKichCo();
            sp1_l.setSanpham(sp1);
            sp1_l.setKichco(l);
            sp1_l.setSoluong(100);
            chiTietKichCoRepository.saveAll(List.of(sp1_s, sp1_m, sp1_l));

            // don hang
            DonHang dh1 = new DonHang();
            dh1.setTenkhachhang("kien");
            dh1.setNgaylap(LocalDate.now());
            DonHang dh2 = new DonHang();
            dh2.setTenkhachhang("duy");
            dh2.setNgaylap(LocalDate.now());
            DonHang dh3 = new DonHang();
            dh3.setTenkhachhang("noname");
            dh3.setNgaylap(LocalDate.now());

            donHangRepository.saveAll(List.of(dh1, dh2, dh3));

            // chi tiet don hang
            ChiTietDonHang ctdh1 = new ChiTietDonHang();
            ctdh1.setDonhang(dh1);
            ctdh1.setChitietkichco(sp1_s);
            ctdh1.setSoluongmua(10);

            ChiTietDonHang ctdh1_1 = new ChiTietDonHang();
            ctdh1_1.setDonhang(dh1);
            ctdh1_1.setChitietkichco(sp1_l);
            ctdh1_1.setSoluongmua(10);

            chiTietDonHangRepository.saveAll(List.of(ctdh1, ctdh1_1));
        };
    }
}
