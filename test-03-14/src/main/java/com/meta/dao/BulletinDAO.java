package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meta.dto.BulletinVO;
import com.meta.util.DBManager;

public class BulletinDAO {

	private BulletinDAO() {
	}

	private static BulletinDAO instance = new BulletinDAO();

	public static BulletinDAO getInstance() {
		return instance;
	}

	public List<BulletinVO> selectUserAllBulletin(String userid) {

		List<BulletinVO> list = new ArrayList<BulletinVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Bulletin where userid = ? order by bulletinNum";

		try {
			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			System.out.println("rs>>" + rs);

			while (rs.next()) {
				BulletinVO vo = new BulletinVO();

				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getDate("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));

				list.add(vo);
			}
			System.out.println("list>>>!" + list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return list;
	}

	public BulletinVO selectOneBulletin(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BulletinVO vo = new BulletinVO();

		String sql = "select * from bulletin where bulletinNum = ?";

		try {
			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setBulletinNum(num);
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setName(rs.getString("name"));
				vo.setBulletinDate(rs.getDate("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setUserid(rs.getString("userid"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}
	public void updateBulletin(BulletinVO vo) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      String sql = "update bulletin set name=?, bulletinTitle=?, bulletinContent=? where bulletinNum = ?";
	      
	      try {
	         con = DBManager.getConnection();
	         
	         pstmt = con.prepareStatement(sql); //sql문 전송, 맵핑
	         
	         pstmt.setString(1, vo.getName());
	         pstmt.setString(2, vo.getBulletinTitle());
	         pstmt.setString(3, vo.getBulletinContent());
	         pstmt.setInt(4, vo.getBulletinNum());
	         
	         pstmt.executeUpdate();//sql문 실행
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	    	  DBManager.close(con, pstmt);
	      }
	   }

	
	public int deleteBulletin(int num) {
		int result = -1;

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from bulletin where bulletinNum = ?";

		try {
			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

		return result;
	}
	
	public void updateReadCount(int BulletinNum) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;

	      String sql = "update bulletin set readcount = readcount+1 where bulletinNum=?";
	      
	      try {
	         con = DBManager.getConnection();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, BulletinNum);
	         
	         pstmt.executeUpdate();
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(con, pstmt);
	      }
	      
	   }

}
