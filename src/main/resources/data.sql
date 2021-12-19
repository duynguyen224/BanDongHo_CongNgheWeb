insert into thuonghieu (tenthuonghieu)
values ('Coolmate'),
       ('Elise'),
       ('Owen'),
       ('Uniqlo'),
       ('Adidas'),
       ('Nike'),
       ('Puma'),
       ('Victoria Secret'),
       ('Gucci'),
       ('Dolce & Gabbana');
commit;

insert into danhmuc(tendanhmuc)
values ('Áo thun'),
       ('Quần jean'),
       ('Sơ mi'),
       ('Áo khoác'),
       ('Quần lót'),
       ('Áo nỉ'),
       ('Áo len'),
       ('Mũ'),
       ('Khẩu trang'),
       ('Khăn choàng');
commit;


insert into sanpham(tensanpham, giaban, tongsoluong, anhchinh, anhphu1, anhphu2, anhphu3, slug, mota, gioitinh,
                    madanhmuc, mathuonghieu)
values ('áo cộc tay', 100000, 100, '/image_upload/TKB.png', 'anh chinh', 'anh chinh', 'anh chinh', 'anh chinh', 'anh chinh', 'nam',
        1, 1);
commit;
