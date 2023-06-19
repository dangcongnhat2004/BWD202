package com.becoder.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.model.UserDtls;
import com.becoder.service.UserService;



@Controller
public class HomeController {

	@Autowired
	private UserService userService;


	@RequestMapping("/home")
	public String homepageVN() {
		return "homepage";
	}
	
	@RequestMapping("/home-uk")
	public String homepageEL() {
		return "homepageel";
	}
	@RequestMapping("/gioithieu-vn")
	public String gioithieuvn() {
		return "gioithieuvn";
	}
	
	@RequestMapping("/daihoc-vn")
	public String listdaihoc() {
		return "daihoc-vn";
	}
	@RequestMapping("/caodang-vn")
	public String listcaodang() {
		return "caodang-vn";
	}
	@RequestMapping("/optionlogin")
	public String option() {
		return "login/option";
	}
	@GetMapping("/login-student-vn")
	public String loginStudent() {
		return "login";
	}
	@RequestMapping("/login-university-vn")
	public String loginUniversity() {
		return "login/university-vn";
	}
	@RequestMapping("/login-admin-vn")
	public String loginAdmin() {
		return "login/admin-vn";
	}
	@RequestMapping("/timkiem-vn")
	public String timkiemVN() {
		return "timkiem-vn";
	}
	@RequestMapping("/tintuyensinh-vn")
	public String tintuyensinhVN() {
		return "login/message";
	}
	@RequestMapping("/sukien-vn")
	public String sukienVN() {
		return "login/message";
	}
	
	@RequestMapping("/thongtin-2")
	public String thongtin2() {
        return "thongtin2";
	}
	@RequestMapping("/xemthemnganh-vn")
	public String xemthemnganhVN() {
		return "nhomnganh-vn";
	}

    @RequestMapping("/thongtin-1")
    public String thongtin1() {
        return "thongtin1";
	}
    @RequestMapping("/xemthemsukien-vn")
    public String xemthemsukien() {
    	return "login/message";
    }
    @RequestMapping("/thongtin-3")
    public String thongtin3() {
    	return "thongtin3";
    	
    }
    @RequestMapping("/xemthemtintuc-vn")
    public String xemthemtintuc() {
    	return "login/message";
    }
    @RequestMapping("/student-ui")
    public String login() {
        return "student-ui"; // Trang chọn loại người dùng đăng nhập
    }
    @GetMapping("/login/student-vn")
    public String getLoginPage(){
        return "login/student-vn";
    }
    @RequestMapping("/nganh-supham")
    public String nganhsupham(){
    	return "nhomnganh/sp";
    }
    @RequestMapping("/nganh-cntt")
    public String nganhcntt(){
    	return "nhomnganh/cntt";
    }
    @RequestMapping("/nganh-nong-lam-ngunghiep")
    public String nganhnonglamngu(){
    	return "nhomnganh/nlnn";
    }
    @RequestMapping("/nganh-khoa-hoc-co-ban")
    public String nganhkhcb(){
    	return "nhomnganh/khcb";
    }
    @RequestMapping("/nganh-bao-chi-va-khoa-hoc-xa-hoi")
    public String nganhbckhxh(){
    	return "nhomnganh/bckhxh";
    }
    @RequestMapping("/nganh-kinh-doanh-va-quan-li")
    public String nganhkdvql(){
    	return "nhomnganh/kd";
    }
    @RequestMapping("/nganh-luat-nhan-van")
    public String nganhluatnhanvan(){
    	return "nhomnganh/lnv";
    }
    @RequestMapping("/nganh-nt-tm-dh")
    public String nttmdh() {
        return "nhomnganh/nttmdh";
    }
    @RequestMapping("/danh-sach-cac-truong-dao-tao-cntt")
	public String cnttdaotao() {
		return "danhsachcactruong/dscntt";
	}
    
    @RequestMapping("/daihoc-conglap")
    public String daihocconglap() {
    	return "truongdaihocvacaodang/conglap";
    }
    
    @RequestMapping("/daihoc-tuthuc")
    public String daihoctuthuc() {
    	return "truongdaihocvacaodang/tuthuc";
    }
    
    @RequestMapping("/caodang")
    public String caodang() {
    	return "truongdaihocvacaodang/caodang";
    }
	
	
	
	@RequestMapping("/truong-dhvh")
	public String viethan() {
		return "daotao/truongdaihocviethan";
	}

	
	@GetMapping("/")
	public String index() {
		return "homepage";
	}

	@GetMapping("/signin")
	public String login1() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new UserDtls());
	    return "register";
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session) {

		// System.out.println(user);

		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			UserDtls userDtls = userService.createUser(user);
			if (userDtls != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}
		}

		return "redirect:/register";
	}
	
	@RequestMapping("/chuong-trinh-dao-tao-cntt-bach-khoa-da-nang")
       public String ctdtcnttbkdn() {
		return "chuongtrinhdaotao/daihocbachkhoa";
	}
}