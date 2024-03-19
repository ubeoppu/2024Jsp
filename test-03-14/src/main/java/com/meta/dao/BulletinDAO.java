package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meta.dto.BulletinVO;
import com.meta.util.DBManager;

public class BulletinDAO {

	private BulletinDAO(){}
	
	private static BulletinDAO instance = new BulletinDAO();
	
	
	public static BulletinDAO getInstance() {
		return instance;
	}
	
	public List<BulletinVO> selectUserAllBulletin(int userid) {
		
		List<BulletinVO>list = new ArrayList<BulletinVO>();
		
		Connection con = null;
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Bulletin where usernum = ?";
		
		try {
			con = DBManager.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, userid);
			
			rs = pstmt.executeQuery();
			
			System.out.println("rs>>" + rs);
			
			while(rs.next()) {
				BulletinVO vo = new BulletinVO();
				
				vo.setBulletinNum(rs.getInt("bulletinNum"));
				vo.setBulletinTitle(rs.getString("bulletinTitle"));
				vo.setBulletinDate(rs.getDate("bulletinDate"));
				vo.setBulletinContent(rs.getString("bulletinContent"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setName(rs.getString("name"));
				
				list.add(vo);
			}
			System.out.println("list>>>!" + list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
		
		return list;
		
	}
}
