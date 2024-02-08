package com.tenco.blog.board.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.blog.board.entity.Board;
import com.tenco.blog.board.service.BoardService;
import com.tenco.blog.board.web.dto.BoardRequestDto;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;

    @PostMapping("/board/save")
    public ResponseEntity<?> save(BoardRequestDto dto){
    	boolean result = boardService.save(dto);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @PostMapping("/board/{id}/update")
    public ResponseEntity<?> update(@PathVariable int id, BoardRequestDto dto){
    	boolean result = boardService.update(id, dto);
    	return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @PostMapping("/board/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable int id){
    	boolean result = boardService.delete(id);
    	return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
    
    @GetMapping("/board/select/{id}")
    public ResponseEntity<?> select(@PathVariable int id){
    	Board list = boardService.select(id);
    	System.out.println("불러옴?" + list);
    	return new ResponseEntity<Board>(list, HttpStatus.OK);
    }
    
    @GetMapping("/board/select/list")
    public ResponseEntity<?> selectList(){
    	List<Board> list = boardService.selectList();
    	return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
    }
}
