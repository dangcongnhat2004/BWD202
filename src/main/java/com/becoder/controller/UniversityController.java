package com.becoder.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.becoder.model.University;
import com.becoder.repository.UniversityRepository;

@Controller
public class UniversityController {
    
   
    @Autowired
    private UniversityRepository universityRepository;

    @PostMapping("/dangki-university")
    public String registeruniversity(@ModelAttribute("university") University university) {
        universityRepository.save(university);
        return "redirect:/login-university-vn";
    }
    @GetMapping("/dangki-university")
    public String showRegistrationForm(Model model) {
        model.addAttribute("university", new University());
        return "university/register";
    }
    
    @GetMapping("/mainpage-university")
    public String mainPageUniversity(@RequestParam("university_id") int universityId, Model model) {
        // truy vấn cơ sở dữ liệu để lấy thông tin người dùng dựa trên universityId
        University uni = universityRepository.findByUniversityId(universityId);

        if (uni != null) {
            // đưa thông tin người dùng vào model để hiển thị trên trang chủ
            model.addAttribute("university", uni);

            // trả về tên view để hiển thị trang chủ
            return "admin/home";
        } else {
            // nếu không tìm thấy thông tin người dùng, trả về trang lỗi
            return "login/university-vn";
        }
    }
    
    
    @PostMapping("/login-university-vn")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
           
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        // truy vấn cơ sở dữ liệu để lấy thông tin đăng nhập của admin
        University uni = universityRepository.findByUsername(username);

        // kiểm tra thông tin đăng nhập của người dùng
        if (uni != null && uni.getPassword().equals(password)) {
            // lưu thông tin đăng nhập của admin vào session
            session.setAttribute("university", uni);

         // truyền ID của người đăng nhập vào URL
            redirectAttributes.addAttribute("university_id",uni.getUniversityId());


            
            // chuyển hướng đến trang chủ
            return "redirect:/mainpage-university";
        } else {
            // nếu thông tin đăng nhập không hợp lệ, trả về trang đăng nhập với thông báo lỗi
            return "/login-university-vn";
        }
    }
}
