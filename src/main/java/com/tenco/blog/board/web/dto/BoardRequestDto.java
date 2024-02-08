package com.tenco.blog.board.web.dto;

import com.tenco.blog.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardRequestDto {

	private int id;
	private String title;
	private String content;
	private String username;
	
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.id(id)
				.username(username)
				.build();
	}
	
}
