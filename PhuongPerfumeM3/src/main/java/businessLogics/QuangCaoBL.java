package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.QuangCao;

public class QuangCaoBL {
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public static List<QuangCao> docTatCa(){
		List<QuangCao> dsqc = new ArrayList<>();
		try (Connection kn = CSDL.getKetNoi()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery("select * from quangcao");
			while(rs.next()) {
				QuangCao qc = new QuangCao();
				qc.setHinhAnh(rs.getString("hinhAnh"));
				qc.setId(rs.getInt("id"));
				qc.setNgayDang(rs.getDate("ngayDang"));
				qc.setThongDiep(rs.getString("thongDiep"));
				qc.setThongTinChiTiet(rs.getString("thongTinChiTiet"));
				dsqc.add(qc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsqc;
	}
}
