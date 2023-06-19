package com.becoder.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.model.Admin;
import com.becoder.repository.AdminReponsitory;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminReponsitory adminrepon;
	
	@ModelAttribute
	private void Admin(Model m, Principal p) {
		String username = p.getName();
		Admin admin = adminrepon.findByUsername(username);
		m.addAttribute("admin", admin);
	}
	 @GetMapping("/")
	    public String getAdmin(Model model, Principal principal) {
	        String username = principal.getName(); // Lấy email của người dùng
	        Admin admin = adminrepon.findByUsername(username);// Tìm người dùng trong cơ sở dữ liệu
	        model.addAttribute("username", admin.getUsername()); // Truyền thông tin người dùng vào model
		return "admin/admin";
	}
	
}
