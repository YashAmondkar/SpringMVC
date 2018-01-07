package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Login;
import com.bean.UserDetails;
import com.service.UserService;

@Controller
@RequestMapping("/library")
public class HomeController {
	
	@Autowired
	private UserService userService;
  
	@RequestMapping("/user/home")
	public String home(){
		return "Home";
	}
	
	@RequestMapping("/admin/home")
	public String adminhome() {
		return "adminLibraryHome";
	}
	
	@RequestMapping("/admin/repository")
	public String adminhome(@ModelAttribute Login login,BindingResult results){
		
		if(results.hasErrors()) {
			return "adminLogin";
		}
		
		if(((login.getUserId()).equalsIgnoreCase("admin")) && (login.getPassword()).equals("admin123")) {
			return "adminLibraryHome";
		}else {
			System.out.println("Admin incorrect details , retry");
			return "adminLogin";
		}
	}
			
	@RequestMapping("/user/login")
	public String userLogin(Model model){
		model.addAttribute("login",new Login());
		return "Login";
	}
		
	@RequestMapping("/user/validate")
	public String validateUserLoginDetails(@ModelAttribute Login login,BindingResult results) throws Exception {		
		UserDetails userDetails;
		
		if(results.hasErrors()) {
			return "Login";
		}
		
		userDetails = userService.validateUserDetails(login);
				
		if (userDetails!= null){
			return "redirect:books";
		}else {
			System.out.println("Invalid userId and password ... retry");
			return "Login";
		}		
	}
				
	@RequestMapping("/admin/login")
	public String adminLogin(Model model){
		model.addAttribute("login", new Login());
		return "adminLogin";
	}

	
	@RequestMapping("/user/register")
	public String userRegistration(Model model){
		model.addAttribute("userDetails",new UserDetails());
		return "Registration";
	}
	
	@RequestMapping("/user/adduser")
	public String addUserDetails(@Valid @ModelAttribute("userDetail") UserDetails userDetail,BindingResult result){

		if(result.hasErrors()){
			System.out.println(result);
			return "Registration";
		}
		
		try {
			userService.addUserDetails(userDetail);
			return "Login";
		} catch (Exception e) {
			e.printStackTrace();
			return "Registration";
		}
	}
	
	@RequestMapping("/admin/allusers")
	public String fetchAllUsers(Model model) {

		List<UserDetails> userDetails;
		try {
			userDetails = userService.getAllUserDetails();
			model.addAttribute("listUsers", userDetails);
			return "UserDetails";			
		} catch (Exception e) {
			e.printStackTrace();
			return "adminLibraryHome";
		}		
	}
	
	@RequestMapping("/admin/edituser")
	public String modifyUserDetails(@RequestParam("userid") String userId,Model model){
		UserDetails userDetails;		
		try {
			userDetails = userService.modifyUserDetails(userId);
			model.addAttribute(userDetails);
			return "EditUserDetails";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:allusers";
		}
	}
			
	
	@RequestMapping("/admin/saveuserdetails")
	public String editUserDetails(@Valid @ModelAttribute("userDetail") UserDetails userDetail,BindingResult result){

		if(result.hasErrors()){
			return "redirect:allusers";
		}
		
		try {
			userService.editUserDetails(userDetail);
			return "redirect:allusers";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:allusers";
		}
	}
	
	@RequestMapping("/admin/deleteuser")
	public String deleteUserDetails(@RequestParam("userid") String userId){
        
		try {
			userService.deleteUserDetails(userId);
			return "redirect:allusers";
		} catch (Exception e) {
			e.printStackTrace();
			return "adminLibraryHome";
		}
	}
	

}
