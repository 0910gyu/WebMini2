package car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import car.dto.MemberVO;
import car.util.DBUtil;

public class JoinDao {
	private static String sql;

	public static void memberJoin(MemberVO mem) {
		Connection c = null;
		PreparedStatement pstmt = null;
		sql = "insert into member values (?,?,?,?,?,?)";
		try {
			c = DBUtil.getConnection();
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getAddr());
			pstmt.setString(6, mem.getPhone());
			pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, pstmt);
		}

	}
}
