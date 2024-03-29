USE [master]
GO
/****** Object:  Database [bandonghoJAVA]    Script Date: 12/23/2021 11:15:16 PM ******/
CREATE DATABASE [bandonghoJAVA]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bandonghoJAVA', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\bandonghoJAVA.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'bandonghoJAVA_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\bandonghoJAVA_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [bandonghoJAVA] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [bandonghoJAVA].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [bandonghoJAVA] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET ARITHABORT OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [bandonghoJAVA] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [bandonghoJAVA] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET  DISABLE_BROKER 
GO
ALTER DATABASE [bandonghoJAVA] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [bandonghoJAVA] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [bandonghoJAVA] SET  MULTI_USER 
GO
ALTER DATABASE [bandonghoJAVA] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [bandonghoJAVA] SET DB_CHAINING OFF 
GO
ALTER DATABASE [bandonghoJAVA] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [bandonghoJAVA] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [bandonghoJAVA] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [bandonghoJAVA] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [bandonghoJAVA] SET QUERY_STORE = OFF
GO
USE [bandonghoJAVA]
GO
/****** Object:  Table [dbo].[chitietdonhang]    Script Date: 12/23/2021 11:15:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chitietdonhang](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[soluongmua] [bigint] NULL,
	[madonhang] [bigint] NULL,
	[masanpham] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danhmuc]    Script Date: 12/23/2021 11:15:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danhmuc](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[is_delete] [bit] NULL,
	[mota] [varchar](255) NULL,
	[slug] [varchar](255) NULL,
	[tendanhmuc] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[donhang]    Script Date: 12/23/2021 11:15:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[donhang](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[diachigiaohang] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[ngaylap] [date] NULL,
	[sodienthoai] [varchar](255) NULL,
	[tenkhachhang] [varchar](255) NULL,
	[tongtien] [numeric](19, 2) NULL,
	[trangthai] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sanpham]    Script Date: 12/23/2021 11:15:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanpham](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[anhchinh] [varchar](255) NULL,
	[anhphu1] [varchar](255) NULL,
	[anhphu2] [varchar](255) NULL,
	[anhphu3] [varchar](255) NULL,
	[giaban] [numeric](19, 2) NULL,
	[gioitinh] [varchar](255) NULL,
	[is_delete] [bit] NULL,
	[mota] [varchar](255) NULL,
	[slug] [varchar](255) NULL,
	[tensanpham] [varchar](255) NULL,
	[tongsoluong] [int] NULL,
	[madanhmuc] [bigint] NULL,
	[mathuonghieu] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[taikhoan]    Script Date: 12/23/2021 11:15:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[taikhoan](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[matkhau] [varchar](255) NULL,
	[tentaikhoan] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[thuonghieu]    Script Date: 12/23/2021 11:15:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thuonghieu](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[is_delete] [bit] NULL,
	[mota] [varchar](255) NULL,
	[slug] [varchar](255) NULL,
	[tenthuonghieu] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[chitietdonhang] ON 

INSERT [dbo].[chitietdonhang] ([id], [soluongmua], [madonhang], [masanpham]) VALUES (10, 3, 5, 2)
INSERT [dbo].[chitietdonhang] ([id], [soluongmua], [madonhang], [masanpham]) VALUES (11, 2, 6, 4)
INSERT [dbo].[chitietdonhang] ([id], [soluongmua], [madonhang], [masanpham]) VALUES (12, 3, 6, 8)
SET IDENTITY_INSERT [dbo].[chitietdonhang] OFF
GO
SET IDENTITY_INSERT [dbo].[danhmuc] ON 

INSERT [dbo].[danhmuc] ([id], [is_delete], [mota], [slug], [tendanhmuc]) VALUES (1, 0, N'', NULL, N'Automatic Watch')
INSERT [dbo].[danhmuc] ([id], [is_delete], [mota], [slug], [tendanhmuc]) VALUES (2, 0, N'', NULL, N'Quartz Watch')
INSERT [dbo].[danhmuc] ([id], [is_delete], [mota], [slug], [tendanhmuc]) VALUES (3, 0, N'', NULL, N'Swiss Watch')
INSERT [dbo].[danhmuc] ([id], [is_delete], [mota], [slug], [tendanhmuc]) VALUES (4, 0, N'', NULL, N'Smart Watch')
SET IDENTITY_INSERT [dbo].[danhmuc] OFF
GO
SET IDENTITY_INSERT [dbo].[donhang] ON 

INSERT [dbo].[donhang] ([id], [diachigiaohang], [email], [ngaylap], [sodienthoai], [tenkhachhang], [tongtien], [trangthai]) VALUES (5, N'hung yen', N'duy@gmail.com', CAST(N'2021-12-23' AS Date), N'0123124123', N'nguyen duc duy', CAST(9000.00 AS Numeric(19, 2)), N'dangxuly')
INSERT [dbo].[donhang] ([id], [diachigiaohang], [email], [ngaylap], [sodienthoai], [tenkhachhang], [tongtien], [trangthai]) VALUES (6, N'dong anh', N'kien@gmail.com', CAST(N'2021-12-23' AS Date), N'0123012412', N'tran trung kien', CAST(162000.00 AS Numeric(19, 2)), N'dangxuly')
SET IDENTITY_INSERT [dbo].[donhang] OFF
GO
SET IDENTITY_INSERT [dbo].[sanpham] ON 

INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (2, N'/image_upload/nam1.webp', N'/image_upload/nam2.webp', N'/image_upload/nam4.webp', N'/image_upload/nam5.webp', CAST(3000.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-', N'Rolex DATEJUS 36', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (3, N'/image_upload/nam2.webp', N'/image_upload/nam3.webp', N'/image_upload/nam7.webp', N'/image_upload/nam4.webp', CAST(5000.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-oyster-perpetual-submariner', N'Rolex OYSTER PERPETUAL Submariner', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (4, N'/image_upload/nam3.webp', N'/image_upload/nam8.webp', N'/image_upload/nam4.webp', N'/image_upload/nam5.webp', CAST(6000.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-cosmograph-daytona', N'Rolex Cosmograph Daytona', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (5, N'/image_upload/nam4.webp', N'/image_upload/nam5.webp', N'/image_upload/nam6.webp', N'/image_upload/nam8.webp', CAST(7000.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-yacht-master-ii', N'Rolex Yacht-Master II', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (6, N'/image_upload/nu8.webp', N'/image_upload/nu7.webp', N'/image_upload/nu6.webp', N'/image_upload/nu5.webp', CAST(8000.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-sea-dweller', N'Rolex SEA-DWELLER', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (7, N'/image_upload/nu3.webp', N'/image_upload/nu8.webp', N'/image_upload/nu7.webp', N'/image_upload/nu6.webp', CAST(10000.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-pearlmaster-39', N'Rolex Pearlmaster 39', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (8, N'/image_upload/nu2.webp', N'/image_upload/nu3.webp', N'/image_upload/nu4.webp', N'/image_upload/nu5.webp', CAST(50000.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-lady-datejust', N'Rolex Lady-Datejust', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (9, N'/image_upload/nu4.webp', N'/image_upload/nu7.webp', N'/image_upload/nu6.webp', N'/image_upload/nu5.webp', CAST(60000.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'rolex-day-date-36', N'Rolex Day-Date 36', 100, 1, 1)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (10, N'/image_upload/nam8.webp', N'/image_upload/nam3.webp', N'/image_upload/nam2.webp', N'/image_upload/nam1.webp', CAST(2000.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'philippe-auguste-pa-5552', N'PHILIPPE AUGUSTE PA-555.2', 100, 2, 2)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (11, N'/image_upload/nam12.webp', N'/image_upload/nam7.webp', N'/image_upload/nam6.webp', N'/image_upload/nam2.webp', CAST(1000.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'philippe-auguste-pa5002e', N'Philippe Auguste PA5002E', 1000, 2, 2)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (12, N'/image_upload/nu1.webp', N'/image_upload/nu3.webp', N'/image_upload/nu2.webp', N'/image_upload/nu8.webp', CAST(1000.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'philippe-auguste-pa5008f', N'Philippe Auguste PA5008F', 100, 2, 2)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (13, N'/image_upload/apple1.webp', N'/image_upload/apple2.webp', N'/image_upload/apple3.webp', N'/image_upload/apple2.webp', CAST(500.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'apple-watch-s6-lte-40mm', N'Apple Watch S6 LTE 40mm', 100, 4, 3)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (14, N'/image_upload/apple3.webp', N'/image_upload/apple2.webp', N'/image_upload/apple1.webp', N'/image_upload/apple3.webp', CAST(600.00 AS Numeric(19, 2)), N'nam', 1, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'apple-watch-se-44mm', N'Apple Watch SE 44mm', 100, 4, 3)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (15, N'/image_upload/apple1.webp', N'/image_upload/apple3.webp', N'/image_upload/apple2.webp', N'/image_upload/apple1.webp', CAST(400.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'apple-watch-series-7-lte-45mm', N'Apple Watch Series 7 LTE 45mm', 100, 4, 3)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (16, N'/image_upload/nam10.webp', N'/image_upload/nam11.webp', N'/image_upload/nam4.webp', N'/image_upload/nam2.webp', CAST(300.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'orient-rf-qd0009s10b', N'Orient RF-QD0009S10B', 100, 2, 4)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (17, N'/image_upload/nam7.webp', N'/image_upload/nam6.webp', N'/image_upload/nam2.webp', N'/image_upload/nam4.webp', CAST(300.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'orient-rf-qd0011l10b', N'Orient RF-QD0011L10B', 100, 2, 4)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (18, N'/image_upload/nam3.webp', N'/image_upload/nam2.webp', N'/image_upload/nam1.webp', N'/image_upload/nam6.webp', CAST(200.00 AS Numeric(19, 2)), N'nam', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'casio-ltp-2022vb-1c', N'Casio LTP-2022VB-1C', 100, 3, 5)
INSERT [dbo].[sanpham] ([id], [anhchinh], [anhphu1], [anhphu2], [anhphu3], [giaban], [gioitinh], [is_delete], [mota], [slug], [tensanpham], [tongsoluong], [madanhmuc], [mathuonghieu]) VALUES (19, N'/image_upload/nam12.webp', N'/image_upload/nam3.webp', N'/image_upload/nam2.webp', N'/image_upload/nam1.webp', CAST(100.00 AS Numeric(19, 2)), N'nu', 0, N'Today the Datejust is available in three sizes: 31, 36 and 41 mm. Each version comes with a large selection of dials in different colours, finishes and materials. ', N'casio-mtp-2022vb-1c', N'Casio MTP-2022VB-1C', 100, 3, 5)
SET IDENTITY_INSERT [dbo].[sanpham] OFF
GO
SET IDENTITY_INSERT [dbo].[taikhoan] ON 

INSERT [dbo].[taikhoan] ([id], [matkhau], [tentaikhoan]) VALUES (1, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[taikhoan] OFF
GO
SET IDENTITY_INSERT [dbo].[thuonghieu] ON 

INSERT [dbo].[thuonghieu] ([id], [is_delete], [mota], [slug], [tenthuonghieu]) VALUES (1, 0, N'', NULL, N'Rolex')
INSERT [dbo].[thuonghieu] ([id], [is_delete], [mota], [slug], [tenthuonghieu]) VALUES (2, 0, N'', NULL, N'Philips')
INSERT [dbo].[thuonghieu] ([id], [is_delete], [mota], [slug], [tenthuonghieu]) VALUES (3, 0, N'', NULL, N'Apple')
INSERT [dbo].[thuonghieu] ([id], [is_delete], [mota], [slug], [tenthuonghieu]) VALUES (4, 0, N'', NULL, N'Orient')
INSERT [dbo].[thuonghieu] ([id], [is_delete], [mota], [slug], [tenthuonghieu]) VALUES (5, 0, N'', NULL, N'Casio')
SET IDENTITY_INSERT [dbo].[thuonghieu] OFF
GO
ALTER TABLE [dbo].[chitietdonhang]  WITH CHECK ADD  CONSTRAINT [FK6jmy0lnfoerkp33ln97l07pho] FOREIGN KEY([madonhang])
REFERENCES [dbo].[donhang] ([id])
GO
ALTER TABLE [dbo].[chitietdonhang] CHECK CONSTRAINT [FK6jmy0lnfoerkp33ln97l07pho]
GO
ALTER TABLE [dbo].[chitietdonhang]  WITH CHECK ADD  CONSTRAINT [FKmub7f864w1wfwbuo70ll8qfsd] FOREIGN KEY([masanpham])
REFERENCES [dbo].[sanpham] ([id])
GO
ALTER TABLE [dbo].[chitietdonhang] CHECK CONSTRAINT [FKmub7f864w1wfwbuo70ll8qfsd]
GO
ALTER TABLE [dbo].[sanpham]  WITH CHECK ADD  CONSTRAINT [FK41ccsjk9f4bs0o97qg2vo54sa] FOREIGN KEY([madanhmuc])
REFERENCES [dbo].[danhmuc] ([id])
GO
ALTER TABLE [dbo].[sanpham] CHECK CONSTRAINT [FK41ccsjk9f4bs0o97qg2vo54sa]
GO
ALTER TABLE [dbo].[sanpham]  WITH CHECK ADD  CONSTRAINT [FKja468m75y1j0w9j0pmncoqpo6] FOREIGN KEY([mathuonghieu])
REFERENCES [dbo].[thuonghieu] ([id])
GO
ALTER TABLE [dbo].[sanpham] CHECK CONSTRAINT [FKja468m75y1j0w9j0pmncoqpo6]
GO
USE [master]
GO
ALTER DATABASE [bandonghoJAVA] SET  READ_WRITE 
GO
