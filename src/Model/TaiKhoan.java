package Model;

public class TaiKhoan {
	 private int ma_tai_khoan;
	    private String ten_dang_nhap;
	    private String mat_khau;
	    private boolean tinh_trang;
	    private String Mail;

	    public String getMail() {
			return Mail;
		}

		public void setMail(String mail) {
			Mail = mail;
		}

		public int getMa_tai_khoan() {
	        return ma_tai_khoan;
	    }

	    public void setMa_tai_khoan(int ma_tai_khoan) {
	        this.ma_tai_khoan = ma_tai_khoan;
	    }

	    public String getTen_dang_nhap() {
	        return ten_dang_nhap;
	    }

	    public void setTen_dang_nhap(String ten_dang_nhap) {
	        this.ten_dang_nhap = ten_dang_nhap;
	    }

	    public String getMat_khau() {
	        return mat_khau;
	    }

	    public void setMat_khau(String mat_khau) {
	        this.mat_khau = mat_khau;
	    }

	    public boolean isTinh_trang() {
	        return tinh_trang;
	    }

	    public void setTinh_trang(boolean tinh_trang) {
	        this.tinh_trang = tinh_trang;
	    }
}
