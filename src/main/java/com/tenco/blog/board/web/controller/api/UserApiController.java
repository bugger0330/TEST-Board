package com.tenco.blog.board.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.blog.board.service.UserService;
import com.tenco.blog.board.web.dto.UserRequestDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/signin")
	public ResponseEntity<?> signin(UserRequestDto dto, HttpServletRequest request){
		boolean result = userService.signin(dto, request);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@PostMapping("/user/signup")
	public ResponseEntity<?> signup(UserRequestDto dto){
		boolean result = userService.signup(dto);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@PostMapping("/get/userinfo")
	public ResponseEntity<?> getSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		return new ResponseEntity<String>(username, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
