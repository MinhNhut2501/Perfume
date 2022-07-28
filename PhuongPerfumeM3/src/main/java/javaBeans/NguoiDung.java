package javaBeans;

import java.io.Serializable;

public class NguoiDung implements Serializable{
	private int id_VaiTro;
	private String dtdd;
	private String diaChi;
	private String hoTen;
	private String password;
	private String email;
	private int id;
	public int getId_VaiTro() {
		return id_VaiTro;
	}
	public void setId_VaiTro(int id_VaiTro) {
		this.id_VaiTro = id_VaiTro;
	}
	public String getDtdd() {
		return dtdd;
	}
	public void setDtdd(String dtdd) {
		this.dtdd = dtdd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NguoiDung() {
		super();
	}
	

}
