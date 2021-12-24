package com.example.banquanao.client.shoppingcart;

import com.example.banquanao.chitietdonhang.ChiTietDonHangRepository;
import com.example.banquanao.chitietdonhang.ChiTietDonHangService;
import com.example.banquanao.donhang.DonHang;
import com.example.banquanao.donhang.DonHangService;
import com.example.banquanao.sanpham.SanPham;
import com.example.banquanao.sanpham.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImp  implements ShoppingCartService{
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private ChiTietDonHangService chiTietDonHangService;

    private Map<SanPham, Integer> giohang = new HashMap<>();

    @Override
    public void themSanPhamVaoGio(SanPham sanPham) {
        if(giohang.containsKey(sanPham)){
            giohang.replace(sanPham, giohang.get(sanPham) + 1);
        }else{
            giohang.put(sanPham, 1);
        }
    }

    @Override
    public void xoaSanPhamTrongGio(SanPham sanPham) {
        if(giohang.containsKey(sanPham)){
            if(giohang.get(sanPham) > 1){
                giohang.replace(sanPham, giohang.get(sanPham) - 1);
            }
            else if(giohang.get(sanPham) == 1){
                giohang.remove(sanPham);
            }
        }
    }

    @Override
    public Map<SanPham, Integer> sanPhamTrongGioHang() {
        return Collections.unmodifiableMap(giohang);
    }

    @Override
    public BigDecimal tinhTongTien() {
        return giohang.entrySet().stream()
                .map(entry -> entry.getKey().getGiaban().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public void thanhToan(DonHang donHang) {
        SanPham sanPham;
        for(Map.Entry<SanPham, Integer> entry : giohang.entrySet()){
            sanPham = sanPhamRepository.findById(entry.getKey().getId()).orElseThrow(() -> new IllegalStateException("OPPS, lỗi mất rồi"));
            if(sanPham.getTongsoluong() < entry.getValue()){
                //
                //
                // throw exception khi không đủ số lượng
                //
                //
            }
            entry.getKey().setTongsoluong(sanPham.getTongsoluong() - entry.getValue());
            chiTietDonHangService.themDongSanPham(donHang, sanPham, (long)entry.getValue());
        }
        giohang.clear();
    }
}
