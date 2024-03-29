package com.becoder.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.becoder.model.Admin;
import com.becoder.model.University;
import com.becoder.repository.AdminReponsitory;

@Controller
public class AdminController {
    @Autowired
    private AdminReponsitory adminRepository;

    @GetMapping("/admin-register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/register";
    }

    @PostMapping("/admin-register")
    public String registerAdmin(@ModelAttribute("admin") Admin admin) {
        adminRepository.save(admin);
        return "redirect:/login-admin-vn";
    }
    
    @GetMapping("/mainpage-admin")
    public String mainpageadmin(@RequestParam("username") String username, Model model) {
        // truy vấn cơ sở dữ liệu để lấy thông tin người dùng dựa trên universityId
        Admin uni = adminRepository.findByUsername(username);

        if (uni != null) {
            // đưa thông tin người dùng vào model để hiển thị trên trang chủ
            model.addAttribute("username", uni);

            // trả về tên view để hiển thị trang chủ
            return "admin/admin";
        } else {
            // nếu không tìm thấy thông tin người dùng, trả về trang lỗi
            return "/";
        }
    }
    
    
    @PostMapping("/login-admin-vn")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        // truy vấn cơ sở dữ liệu để lấy thông tin đăng nhập của admin
        Admin admin = adminRepository.findByUsername(username);

        // kiểm tra thông tin đăng nhập của người dùng
        if (admin != null && admin.getPassword().equals(password)) {
            // lưu thông tin đăng nhập của admin vào session
        	session.setAttribute("username", admin);
        	  // truyền ID của người đăng nhập vào URL
            redirectAttributes.addAttribute("username",admin.getUsername());

            // chuyển hướng đến trang admin
            return "redirect:/mainpage-admin";
        } else {
            // nếu thông tin đăng nhập không hợp lệ, trả về trang đăng nhập với thông báo lỗi
            return "/";
        }
    }
}
