package javaBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import businessLogics.SanPhamBL;

public class GioHang implements Serializable{
	private Hashtable<Integer, Integer> dsh;
	public GioHang() {
		dsh = new Hashtable<Integer, Integer>();		
	}
	
	public void them(int idsp,int slm) {
		if(dsh.containsKey(idsp)) 
			dsh.replace(idsp,dsh.get(idsp)+slm);
		else
			dsh.put(idsp, slm);
	}

	public int soMatHang() {
		return dsh.size();
	}
	
	public double tongTien() {
		double tt = 0;
		for(int idsp:dsh.keySet()) {
			SanPham sp = SanPhamBL.docTheoId(idsp);
			tt += sp.getDonGiaKM()*dsh.get(idsp);
		}
		return tt;
	}
	
	public List<SanPhamMua> dsSPMua(){
		List<SanPhamMua> ds = new ArrayList<SanPhamMua>();
		for(int idsp:dsh.keySet()) {
			SanPham sp = SanPhamBL.docTheoId(idsp);
			SanPhamMua spm = new SanPhamMua();
			spm.setDonGia(sp.getDonGia());
			spm.setDonGiaKM(sp.getDonGiaKM());
			spm.setHienThi(sp.getHienThi());
			spm.setHinhAnh(sp.getHinhAnh());
			spm.setId(sp.getId());
			spm.setIdLoai(sp.getIdLoai());
			spm.setIdThuongHieu(sp.getIdThuongHieu());
			spm.setMoTa(sp.getMoTa());
			spm.setNgayTao(sp.getNgayTao());
			spm.setSoLuong(sp.getSoLuong());
			spm.setTenSanPham(sp.getTenSanPham());
			spm.setSoLuongMua(dsh.get(idsp));
			ds.add(spm);
		}
		
		return ds;
		
		
	}
}
