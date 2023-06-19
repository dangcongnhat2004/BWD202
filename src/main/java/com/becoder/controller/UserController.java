package com.becoder.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.model.UserDtls;
import com.becoder.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {  

	@Autowired
	private UserRepository userRepo;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}

	 @GetMapping("/")
	    public String getUser(Model model, Principal principal) {
	        String email = principal.getName(); // Lấy email của người dùng
	        UserDtls user = userRepo.findByEmail(email); // Tìm người dùng trong cơ sở dữ liệu
	        model.addAttribute("fullName", user.getFullName()); // Truyền thông tin người dùng vào model
		return "user/home";
	}
	@GetMapping("/truongdaihocbachkhoa")
	public String truong1() {
		return ""; 
	}
	
	@RequestMapping("/truongcaodangfpt")
	public String truong2() {
		return "caodang/fpt"; 
	}
	

}