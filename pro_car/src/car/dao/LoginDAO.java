package car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import car.dto.MemberVO;
import car.util.DBUtil;

public class LoginDAO {

	private static LoginDAO instance;

	private LoginDAO() {
	}

	public static LoginDAO getInstance() {
		if (instance == null) {
			instance = new LoginDAO();
		}
		return instance;
	}

	private static String sql;

	public int loginCheck(String id, String pwd) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPW = "";
		int x = -1;
		sql = "select password from member id=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbPW = rs.getString("password");

				if (dbPW.equals(pwd)) {
					x = 1;
				} else {
					x = 0;
				}
			} else {
				x = -1;
			}

		} catch (Exception e) {

		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return x;

	}

	public MemberVO getUserInfo(String id) {

		Connection c = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;

		sql = "select * from member where id=?";
		try {
			c = DBUtil.getConnection();
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("mail"));
				member.setAddr(rs.getString("addr"));
				member.setPhone(rs.getString("phone"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, pstmt, rs);
		}
		return member;

	}
}