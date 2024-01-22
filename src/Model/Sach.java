package Model;

import java.util.Date;

public class Sach {
	private int ID;
	private String MaSach;
	private String TenSach;
	private String TenTacGia;
	private Date NgayXuatBan;
	private int SoLuong;
	private double GiaTien;
	
	public Sach(int iD, String maSach, String tenSach, String tenTacGia, Date ngayXuatBan, int soLuong,
			double giaTien) {
		super();
		ID = iD;
		MaSach = maSach;
		TenSach = tenSach;
		TenTacGia = tenTacGia;
		NgayXuatBan = ngayXuatBan;
		SoLuong = soLuong;
		GiaTien = giaTien;
	}

	public Sach() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaSach() {
		return MaSach;
	}

	public void setMaSach(String maSach) {
		MaSach = maSach;
	}

	public String getTenSach() {
		return TenSach;
	}

	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}

	public String getTenTacGia() {
		return TenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}

	public Date getNgayXuatBan() {
		return NgayXuatBan;
	}

	public void setNgayXuatBan(Date ngayXuatBan) {
		NgayXuatBan = ngayXuatBan;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public double getGiaTien() {
		return GiaTien;
	}

	public void setGiaTien(double giaTien) {
		GiaTien = giaTien;
	}

	public void setNgaySinh(long time) {
		// TODO Auto-generated method stub
		
	}
}