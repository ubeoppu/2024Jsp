package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meta.dto.BulletinVO;
import com.meta.dto.ContentVO;
import com.meta.util.DBManager;

public class ContentWishListDAO {

	private static ContentWishListDAO instance = new ContentWishListDAO();
	
	private ContentWishListDAO(){}
	
	public static ContentWishListDAO getInstace() {
		return instance;
	}
	
	public List<Integer> getContentNums(String userid){
 		System.out.println(userid);
 		List<Integer>list = new ArrayList<Integer>();
 		
 		Connection con = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
		String sql = "select contentNum from contentWishList where userid = ?";
 		
 		try {
 			con = DBManager.getConnection();
 			
 			pstmt = con.prepareStatement(sql);
 			
 			pstmt.setString(1, userid);
 			
 			rs = pstmt.executeQuery();
 			
 			System.out.println("rs>>!" + rs);
 			while(rs.next()) {
 				list.add(rs.getInt("ContentNum"));
 			}
 			System.out.println("dao List값 >>" + list);
 		}catch(Exception e) {
 			e.printStackTrace();
 		}finally {
 			DBManager.close(con, pstmt, rs);
 		}
 		
 		return list;
 	}
 	
 	public List<ContentVO> getContentWishList(List<Integer> list){
 		List<ContentVO>Volist = new ArrayList<ContentVO>();
 		
 		Connection con = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		String sql = "select * from content where contentNum = ?";
 		
 		try {
 			con = DBManager.getConnection();
 			
 			pstmt = con.prepareStatement(sql);
 			
 			for(int i = 0; i < list.size(); i++) {
 				
 				pstmt.setInt(1, list.get(i));
 				
 				rs = pstmt.executeQuery();
 				
 	 			if(rs.next()) {
 	 				ContentVO vo = new ContentVO();
 	 				
 	 				vo.setContentNum(rs.getInt("contentNum"));
 	 				vo.setContentName(rs.getString("contentName"));
 	 				vo.setGenre(rs.getString("genre"));
 	 				vo.setActor(rs.getString("actor"));
 	 				vo.setYear(rs.getInt("year"));
 	 				vo.setStory(rs.getString("story"));
 	 				vo.setPoster(rs.getString("poster"));
 	 				
 	 				Volist.add(vo);
 	 				
 	 			}
 			}
 			
 			
 			

 			
 		}catch(Exception e) {
 			e.printStackTrace();
 		}finally {
 			DBManager.close(con, pstmt, rs);
 		}
 		
 		return Volist;
 	}
}
