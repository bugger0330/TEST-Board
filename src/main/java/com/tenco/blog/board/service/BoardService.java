package com.tenco.blog.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.blog.board.entity.Board;
import com.tenco.blog.board.repository.BoardRepository;
import com.tenco.blog.board.web.dto.BoardRequestDto;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public Board select(int id){
		Board list = boardRepository.select(id);
		return list;
	}
	
	public List<Board> selectList(){
		List<Board> list = boardRepository.selectList();
		return list;
	}
	
	public boolean save(BoardRequestDto dto) {
		int result = boardRepository.save(dto.toEntity());
		return result != 0;
	}
	
	public boolean delete(int id) {
		int result = boardRepository.delete(id);
		return result != 0;
	}

	public boolean update(int id, BoardRequestDto dto) {
		dto.setId(id);
		int result = boardRepository.update(dto.toEntity());
		return result != 0;
	}

}
