package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.SanPham;

public class SanPhamBL {
	
	public static List<SanPham> docTatCa(){
		String sql = "select * from sanpham";
		List<SanPham> dssp = taoDanhSach(sql);
		return dssp;
	}
	
	public static SanPham docTheoId(int idSanPham) {
		String sql = "select * from sanpham where id ="+idSanPham;
		List<SanPham> dssp = taoDanhSach(sql);
		if(dssp.size()>0)
			return dssp.get(0);
		else
			return null;
	}
	
	public static List<SanPham> docTheoLoai(int idLoai){
		String sql = "select * from sanpham where id_loai="+idLoai;
		List<SanPham> dssp = taoDanhSach(sql);
		return dssp;
	}
	
	public static List<SanPham> docTheoThuongHieu(int idThuongHieu){
		String sql = "select * from sanpham where id_thuonghieu="+idThuongHieu;
		List<SanPham> dssp = taoDanhSach(sql);
		return dssp;
	}
	
	public static List<SanPham> docTheoTen(String tenSanPham){
		String sql = "select * from sanpham where tensanpham like='%"+tenSanPham+"%'";
		List<SanPham> dssp = taoDanhSach(sql);
		return dssp;
	}
	
	public static List<SanPham> sanPhamMoi(int top){
		String sql = "select * from sanpham order by ngaytao desc limit 0,"+top;
		List<SanPham> dssp = taoDanhSach(sql);
		return dssp;
	}
	
    public static List<SanPham> banChayNhat(int top){
        String sql = "select s.*,sum(c.soluong) as tslb from sanpham s inner join chitietdonhang c " +
                     "on c.id_sanpham = s.id group by 1 order by tslb desc limit 0,"+top;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }

    public static List<SanPham> giamGiaNhieu(int top){
        String sql= "select s.*, s.dongia-s.dongiaKM as giamGia from sanpham s order by giamGia desc limit 0,"+top;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }
	
    public static int tongSoTrang(int soDongTrang) {
    	List<SanPham> dssp = taoDanhSach("select * from sanpham");
    	int tongSoDong = dssp.size();
    	int tongSoTrang = tongSoDong/soDongTrang + (tongSoDong%soDongTrang==0?0:1);
    	return tongSoTrang;
    }
    
    public static List<SanPham> sanPhamTrang(int trang,int soDongTrang){
    	int viTriDau = (trang==1?0:(trang-1)*soDongTrang);
    	String sql = "select * from sanpham limit " + viTriDau + "," + soDongTrang;
    	List<SanPham> dssp = taoDanhSach(sql);
    	return dssp;
    }
	
	
	public static List<SanPham> taoDanhSach(String sql){
		List<SanPham> dssp = null;
		try (Connection con = CSDL.getKetNoi()){
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dssp = new ArrayList<>();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMoTa(rs.getString("mota"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dssp.add(sp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssp;
	}

}
