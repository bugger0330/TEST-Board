package com.tenco.blog.board.web.dto;

import com.tenco.blog.board.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {

	private int id;
	private String username;
	private String password;
	
	public User toEntity() {
		return User.builder()
				.id(id)
				.username(username)
				.password(password)
				.build();
	}
}
