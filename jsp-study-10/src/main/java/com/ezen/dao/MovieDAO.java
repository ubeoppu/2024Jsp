package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	
	private static MovieDAO instance = new MovieDAO();
	
	private MovieDAO() {
		
	}
	
	public static MovieDAO getInstace() {
		return instance;
	}
	
	//전체 리스트 가져오기
	public List<MovieVO> movieList() {
		String sql = "select * from movie";
		
		List<MovieVO> list= new ArrayList<MovieVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getInt("price"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setPoster(rs.getString("poster"));
				vo.setSynopsis(rs.getString("Synopsis"));
				
				list.add(vo);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	//한 영화 가져오기
	public MovieVO getOneMovie(int code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieVO vo = new MovieVO();
		String sql = "select * from movie where code = ?";
		
		
		try {
		con = DBManager.getConnection();
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, code);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			vo.setCode(Integer.parseInt(rs.getString("code")));
			vo.setTitle(rs.getString("title"));
			vo.setPrice(rs.getInt("price"));
			vo.setDirector(rs.getString("director"));
			vo.setActor(rs.getString("actor"));
			vo.setPoster(rs.getString("poster"));
			vo.setSynopsis(rs.getString("Synopsis"));

		}
		System.out.println("vo>>>!!" + vo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, con);
		}
		return vo;
		
	}
	
	//영화 수정
	public void updateMovie(MovieVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update movie set title=?, price=?, director=?,actor=?, poster=?, synopsis=?"
				+ "where code = ?";
		
		try {
		con = DBManager.getConnection();
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo.getTitle());
		pstmt.setInt(2, vo.getPrice());
		pstmt.setString(3, vo.getDirector());
		pstmt.setString(4, vo.getActor());
		pstmt.setString(5, vo.getPoster());
		pstmt.setString(6, vo.getSynopsis());
		pstmt.setInt(7, vo.getCode());
		
		pstmt.executeUpdate();
		


		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt, con);
		}
	}
	
	//영화 추가
	public void insertMovie(MovieVO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into movie (code, title, price, director, actor, poster, synopsis)"
				+ "values(movie_seq.nextval, ?, ?, ?, ?, ?, ?)";
		

		try {
		con = DBManager.getConnection();
		
		pstmt = con.prepareStatement(sql);
		System.out.println(vo.getTitle());
		pstmt.setString(1, vo.getTitle());
		pstmt.setInt(2, vo.getPrice());
		pstmt.setString(3, vo.getDirector());
		pstmt.setString(4, vo.getActor());
		pstmt.setString(5, vo.getPoster());
		pstmt.setString(6, vo.getSynopsis());
		
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt, con);
		}
	}
	
	//영화 삭제
	public void deleteMovie(int code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from movie where code =?";
		
  try {	
		con = DBManager.getConnection();
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, code);
		
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt, con);
		}
	}

	public static MovieDAO getInstance() {
		return instance;
	}
}