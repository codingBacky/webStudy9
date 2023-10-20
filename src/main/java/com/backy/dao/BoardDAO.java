package com.backy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.backy.dto.BoardVO;
import com.backy.util.DBManager;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() throws SQLException {
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from board order by num desc";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setName(rs.getString("name"));
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("Email"));
				vo.setTitle(rs.getString("title"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	public BoardVO selectOneByNum(int num) {
		String sql = "select * from board where num=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = new BoardVO();
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("Email"));
				vo.setTitle(rs.getString("title"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps, rs);
		}
		return vo;
	}
	
	//등록
	public int insertBoard(BoardVO vo) {
		int result = -1;
		String sql = "insert into board(num, pass, name, email,  title, content)"
				+ "values(board_seq.nextval,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getPass());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getTitle());
			ps.setString(5, vo.getContent());
			result = ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		return result;
	}
	
	
}