package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javaBeans.NguoiDung;

public class NguoiDungBL {
	public static NguoiDung docTheoEmailPassword(String email,String password) {
		NguoiDung nd = null;
		String sql = "select * from nguoidung where email = '" + email + "' and password = '"+ password +"'  ";
		try (Connection con = CSDL.getKetNoi()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				 nd = new NguoiDung();
				 nd.setDiaChi(rs.getString("diachi"));
				 nd.setDtdd(rs.getString("dtdd"));
				 nd.setEmail(rs.getString("email"));
				 nd.setHoTen(rs.getString("hoten"));
				 nd.setId(rs.getInt("id"));
				 nd.setId_VaiTro(rs.getInt("id_vaitro"));
				 nd.setPassword(rs.getString("password"));		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nd;
	}
	
}
