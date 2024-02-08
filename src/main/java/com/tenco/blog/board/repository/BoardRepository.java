package com.tenco.blog.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.blog.board.entity.Board;

@Mapper
public interface BoardRepository {
	
	public Board select(int id);
	public List<Board> selectList();
	public int save(Board board);
	public int delete(int id);
	public int update(Board board);
	

}
