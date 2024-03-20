package com.meta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meta.dto.MemberVO;
import com.meta.util.DBManager;

public class MemberDAO {
	/*
	 * String name = null; String userId = null; String pwd = null; String email =
	 * null; String phone = null; int admin = 0;
	 */
	private static MemberDAO instance = new MemberDAO();

	MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public int checkUser(String userid, String pwd) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from member where userid =? ";

		int result = -1;
		try {
			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();
			System.out.println("rs22>>" + rs);
//			if(rs.next()) {
//				System.out.println("rs>>"+ rs.getString("pwd"));
//			}
			if (rs.next()) {
				if (pwd.equals(rs.getString("pwd"))) {
					
					result = 1;
				} else {
					result = 0;// 비밃먼호 틀림
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return result;
	}

	public MemberVO getOneMember(String id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where userid =? ";
		MemberVO vo = new MemberVO();

		try {

			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserid(id);
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}
	public int getUserNumMember(String userid) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int usernum = 0;
		
		String sql = "select usernum from member where userid =?";
		
		try {
			con = DBManager.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			    usernum = rs.getInt("usernum");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return usernum;
	}

	public List<MemberVO> getAllMember(String id) {

		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where userid =? ";

		try {
			MemberVO vo = new MemberVO();

			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserid(id);
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
			}
			list.add(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;
	}

	public int insertMember(MemberVO vo) {
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?, ?, ?, ?, ? ,?)";

		con = DBManager.getConnection();
		try {
			pstmt = con.prepareStatement(sql);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

		return result;
	}

	public int updateMember(MemberVO vo) {

		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update member set name = ?, userid = ?, email = ?, phone = ?, address = ? where userid = ?";

		con = DBManager.getConnection();

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getUserid());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}
	
	   public void deleteMember(int userid) {

		      Connection con = null;
		      PreparedStatement pstmt = null;

		      String sql = "delete from member where userID = ?";

		      try {
		         con = DBManager.getConnection();
		         
		         pstmt = con.prepareStatement(sql);
		         
		         pstmt.setInt(1, userid);
		         
		         pstmt.executeUpdate();

		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         DBManager.close(con, pstmt);
		      }
		   }

}
