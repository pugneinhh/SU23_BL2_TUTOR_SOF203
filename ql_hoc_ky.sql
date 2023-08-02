USE quan_ly_mon_hoc;

CREATE TABLE hoc_ky (
    id INT IDENTITY PRIMARY KEY,
    ten NVARCHAR (255) NOT NULL,
    co_so NVARCHAR (255) NOT NULL,
    ngay_bat_dau DATE NULL,
    ngay_ket_thuc DATE NULL,
    so_sv_nhap_hoc int NOT NULL
);

GO

INSERT INTO hoc_ky(ten, co_so, ngay_bat_dau, ngay_ket_thuc, so_sv_nhap_hoc) VALUES
('SPRING 2021', 'Ha Noi', NULL, NULL, 2000),
('SUMMER 2021', 'Ha Noi', NULL, NULL, 2510),
('FALL 2021', 'Ha Noi', NULL, NULL, 20000),
('FALL 2021', 'HCM', NULL, NULL, 17000);

GO
