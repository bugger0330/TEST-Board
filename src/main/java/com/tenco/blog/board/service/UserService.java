package com.tenco.blog.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tenco.blog.board.entity.User;
import com.tenco.blog.board.repository.UserRepository;
import com.tenco.blog.board.web.dto.UserRequestDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public boolean signin(UserRequestDto dto, HttpServletRequest request) {
		User user = userRepository.getUser(dto.getUsername());
		
		if(user != null) {
			if(bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())){
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("username", user.getUsername());
				return true;
			}
		}
		return false;
	}
	
	
	public boolean signup(UserRequestDto dto) {
		User user = User.builder()
				.username(dto.getUsername())
				.password(bCryptPasswordEncoder.encode(dto.getPassword()))
				.build();
		int result = userRepository.signup(user);
		return result != 0;
	}
	
	
	
	
}
