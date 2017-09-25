package car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import car.dto.MemberVO;
import car.util.DBUtil;


public class UpdateDao {
	
	private static String sql;
	public static void update(MemberVO mem) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		sql = "UPDATE member SET pwd = ? , name = ? , mail = ? , addr = ? , phone = ?  WHERE id = ?";
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getPassword());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getEmail());
			pstmt.setString(4, mem.getAddr());
			pstmt.setString(5, mem.getPhone());
			pstmt.setString(6, mem.getId());

			pstmt.executeQuery();

		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			close(con, pstmt);
		}
	}

	private static void close(Connection conn, Statement stmt) throws SQLException {
		if (conn != null)
			conn.close();
		if (stmt != null)
			stmt.close();
	}
	
}
