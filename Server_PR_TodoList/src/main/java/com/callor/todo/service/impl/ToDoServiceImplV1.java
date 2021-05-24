package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todo.config.DBConnection;
import com.callor.todo.model.ListVO;
import com.callor.todo.service.ToDoService;

public class ToDoServiceImplV1 implements ToDoService {

	protected Connection dbConn;

	public ToDoServiceImplV1() {
		dbConn = DBConnection.getDBConnection();
	}

	protected List<ListVO> select(PreparedStatement pStr) throws SQLException {

		List<ListVO> tdList = new ArrayList<ListVO>();
		ResultSet rSet = pStr.executeQuery();

		while (rSet.next()) {
			ListVO lVO = new ListVO();
			lVO.setTd_seq(rSet.getLong("td_seq"));
			lVO.setTd_date(rSet.getString("td_date"));
			lVO.setTd_time(rSet.getString("td_time"));
			lVO.setTd_todo(rSet.getString("td_todo"));
			lVO.setTd_place(rSet.getString("td_place"));
			tdList.add(lVO);
		}
		rSet.close();
		return tdList;
	}

	@Override
	public Integer insert(ListVO listVO) {
		// TODO 입력하기
		
		String sql = " INSERT INTO tbl_todolist ";
		sql += " ( ";
		sql += " td_seq," ;
		sql += " td_date," ;
		sql += " td_time," ;
		sql += " td_todo," ;
		sql += " td_place ) " ;
		sql += " VALUES ( seq_todo.NEXTVAl, ?, ?, ?, ? ) " ;
		
		PreparedStatement pStr = null ;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			pStr.setString(1, listVO.getTd_date());
			pStr.setString(2, listVO.getTd_time());
			pStr.setString(3, listVO.getTd_todo());
			pStr.setString(4, listVO.getTd_place());
			Integer result = pStr.executeUpdate();
			
			System.out.println("입력성공");
			pStr.close();
			return result ;
			
		} catch (SQLException e) {
			System.out.println("입력실패");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<ListVO> selectAll() {
		// TODO 모든 내역 출력

		String sql = "SELECT * FROM tbl_todolist ";
		sql += " ORDER BY td_seq DESC ";
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			List<ListVO> tdList = this.select(pStr);
			pStr.close();
			return tdList;

		} catch (SQLException e) {
			System.out.println("SQL 확인 요망.");
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ListVO selectBySeq(Long td_seq) {
		List<ListVO> lVO = new ArrayList<ListVO>();
		String sql = " SELECT * FROM tbl_todolist ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null ;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);
			
			lVO = this.select(pStr);
			
			return lVO.get(0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<ListVO> selectByDate(String td_date) {
		// TODO 날짜별검색
		
		List<ListVO> lVO = new ArrayList<ListVO>();
		String sql = " SELECT * FROM tbl_todolist ";
		sql += " WHERE td_date = ? ";
		
		PreparedStatement pStr = null ;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, td_date);
			
			lVO = this.select(pStr);
			
			return lVO;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<ListVO> selectByText(String text) {
		// TODO 내용으로 검섹
		return null;
	}

	@Override
	public Integer update(Long td_seq) {
		// TODO 수정하기
		
		ListVO tdVO = this.selectBySeq(td_seq);
		
		String sql = " UPDATE tbl_todolist SET ";
		sql += " td_date=?, ";
		sql += " td_time=?, ";
		sql += " td_todo=?, ";
		sql += " td_place=? ";
		sql += " WHERE td_seq = ?  ";
		
		PreparedStatement pStr = null ;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_todo());
			pStr.setString(4, tdVO.getTd_place());
			pStr.setLong(5, td_seq);
			return pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer delete(Long td_seq) {
		// TODO 삭제하기
		
		String sql = " DELETE FROM tbl_todolist ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);
			Integer result = pStr.executeUpdate();
			
			pStr.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
