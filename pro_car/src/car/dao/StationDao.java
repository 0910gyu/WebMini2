package car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import car.dto.StationVO;
import car.util.DBUtil;

public class StationDao {
	public static String sql;

	//충전소 정보 리스트에 담기
	public static ArrayList<StationVO> infoStation(int code) {
		StationVO st = null;
		Connection c = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StationVO> sList = new ArrayList<>();

		sql = "select * from station where code=?";
		try {
			c = DBUtil.getConnection();
			pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idNum = rs.getInt(1);
				String csNm = rs.getString(2);
				String addr = rs.getString(3);
				String dpNm = rs.getString(4);
				String lat = rs.getString(5);
				String longI = rs.getString(6);
				sList.add(new StationVO(idNum, csNm, addr, dpNm, lat, longI));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(c, pstmt, rs);
		}
		return sList;
	}
	
	// 입력한 충전소 리스트에 담기
	public static StationVO staDetail(String keyName) {
		StationVO st = null;
		Connection c = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "select * from station where csnm=?";
		
		try {
			c = DBUtil.getConnection();
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1, keyName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			int id = rs.getInt(1);
			String csnm = rs.getString(2);
			String addr = rs.getString(3);
			String cpnm = rs.getString(4);
			String lat = rs.getString(5);
			String longi = rs.getString(6);
			st = new StationVO(id,csnm,addr,cpnm,lat,longi);
			}
			System.out.println(st.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, pstmt, rs);
		}
		return st;
	}
}
