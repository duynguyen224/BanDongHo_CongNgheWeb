insert into thuonghieu (tenthuonghieu)
values ('Casio'),
       ('Rolex'),
       ('Philip');
commit;

insert into danhmuc (tendanhmuc)
values ('Đồng hồ cơ'),
       ('Đồng hồ thông minh'),
       ('Đồng hồ pin');
commit;


insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
             madanhmuc, mathuonghieu)
values ('Đồng hồ 1', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', 'nu',
        1, 1);
commit;
insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                    madanhmuc, mathuonghieu)
values ('Đồng hồ 1', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', 'nu',
        1, 1);
commit;
insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                    madanhmuc, mathuonghieu)
values ('Đồng hồ 1', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', 'nu',
        1, 1);
commit;insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                           madanhmuc, mathuonghieu)
       values ('Đồng hồ 1', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
               '/image_upload/TKB.png', '/image_upload/TKB.png',
               '/image_upload/TKB.png', 'nu',
               1, 1);
commit;insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                           madanhmuc, mathuonghieu)
       values ('kien', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
               '/image_upload/TKB.png', '/image_upload/TKB.png',
               '/image_upload/TKB.png', 'nu',
               1, 1);
commit;

insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                    madanhmuc, mathuonghieu)
values ('nguyen duc duy', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', 'nu',
        2, 2);
commit;

insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                    madanhmuc, mathuonghieu)
values ('tran trung kien', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', 'nam',
        3, 3);
commit;

insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                    madanhmuc, mathuonghieu)
values ('Đồng hồ 4', 100000, 100, '/image_upload/TKB.png', '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', '/image_upload/TKB.png',
        '/image_upload/TKB.png', 'nam',
        1, 2);
commit;

insert into donhang(ngaylap, trangthai, diachigiaohang, sodienthoai, tenkhachhang, email)
values (CURRENT_DATE, 'dangxuly', 'hà nội', '123456', 'kiên', 'kien@gmail.com');
commit;
insert into donhang(ngaylap, trangthai, diachigiaohang, sodienthoai, tenkhachhang, email)
values (CURRENT_DATE, 'dahuy', 'hà nội', '123456', 'duy', 'kien@gmail.com');
commit;
insert into donhang(ngaylap, trangthai, diachigiaohang, sodienthoai, tenkhachhang, email)
values (CURRENT_DATE, 'thanhcong', 'hà nội', '123456', 'duyyyyyyyy', 'kien@gmail.com');
commit;

insert into chitietdonhang(soluongmua, madonhang, masanpham)
values (100, 1, 1);
commit;
insert into chitietdonhang(soluongmua, madonhang, masanpham)
values (100, 1, 2);
commit;
insert into chitietdonhang(soluongmua, madonhang, masanpham)
values (100, 1, 3);
commit;