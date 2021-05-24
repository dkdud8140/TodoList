package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ListVO {

	private Long td_seq ;
	private String td_date;
	private String td_time;
	private String td_todo;
	private String td_place;

}
