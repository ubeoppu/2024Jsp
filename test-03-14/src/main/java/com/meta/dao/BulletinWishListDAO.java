package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meta.dto.BulletinVO;
import com.meta.dto.BulletinWishListVO;
import com.meta.util.DBManager;

public class BulletinWishListDAO {

 	private BulletinWishListDAO(){}
 	
 	private static BulletinWishListDAO instance = new BulletinWishListDAO();
 	
 	public static BulletinWishListDAO getInstace() {
 		return instance;
 	}
 	
 	public List<Integer> getInfoBulletinWishList(int userid){
 		System.out.println(userid);
 		List<Integer>list = new ArrayList<Integer>();
 		
 		Connection con = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		String sql = "select bulletinNum from bulletinBoardWishList where bulletinUserNum = ?";
 		
 		try {
 			con = DBManager.getConnection();
 			
 			pstmt = con.prepareStatement(sql);
 			
 			pstmt.setInt(1, userid);
 			
 			rs = pstmt.executeQuery();
 			
 			System.out.println("rs>>!" + rs);
 			while(rs.next()) {
 				list.add(rs.getInt("bulletinNum"));
 			}
 		}catch(Exception e) {
 			e.printStackTrace();
 		}finally {
 			DBManager.close(con, pstmt, rs);
 		}
 		
 		return list;
 	}
 	
 	public List<BulletinVO> getBulletinWishList(List<Integer> list, int usernum){
 		List<BulletinVO>Volist = new ArrayList<BulletinVO>();
 		
 		Connection con = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		String sql = "select * from bulletin where bulletinNum = ? and userNum =?";
 		
 		try {
 			con = DBManager.getConnection();
 			
 			pstmt = con.prepareStatement(sql);
 			
 			for(int i = 0; i < list.size(); i++) {
 				
 				pstmt.setInt(1, list.get(i));
 				pstmt.setInt(2, usernum);
 				
 				rs = pstmt.executeQuery();
 				
 	 			if(rs.next()) {
 	 				BulletinVO vo = new BulletinVO();
 	 				
 	 				vo.setBulletinNum(rs.getInt("bulletinNum"));
 	 				vo.setBulletinTitle(rs.getString("bulletinTitle"));
 	 				vo.setBulletinDate(rs.getDate("bulletinDate"));
 	 				vo.setBulletinContent(rs.getString("bulletinContent"));
 	 				vo.setReadcount(rs.getInt("readcount"));
 	 				vo.setName(rs.getString("name"));
 	 				
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
