package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.ListVO;

public interface ToDoService {
	
	// 입력
	public Integer insert(ListVO listVO);

	// 전체리스트 입력
	public List<ListVO> selectAll();
	// SEQ 검색
	public ListVO selectBySeq(Long td_seq);
	// 날짜별 검색
	public List<ListVO> selectByDate(String td_date);
	// 할 일 검색
	public List<ListVO> selectByText(String text);
	
	
	// 수정
	public Integer update(Long td_seq);
	
	// 삭제
	public Integer delete(Long td_seq);
}
