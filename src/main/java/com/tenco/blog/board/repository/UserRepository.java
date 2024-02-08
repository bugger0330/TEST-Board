package com.tenco.blog.board.repository;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.blog.board.entity.User;

@Mapper
public interface UserRepository {
	
	public User getUser(String username);
	public int signup(User user);

}
