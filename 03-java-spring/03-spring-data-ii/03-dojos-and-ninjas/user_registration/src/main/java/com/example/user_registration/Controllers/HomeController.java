package com.example.user_registration.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.user_registration.Models.User;
import com.example.user_registration.Service.UserService;

@Controller
public class HomeController {
	@Autowired
    private UserService userService;
    
	    @RequestMapping("/")
	    public String registerForm(@ModelAttribute("user") User user) {
	        return "login.jsp";
	    }
//	    @RequestMapping("/login")
//	    public String login() {
//	        return "loginPage.jsp";
//	    }
//	    
	    @RequestMapping(value="/registration", method=RequestMethod.POST)

	    	// if result has errors, return the registration page (don't worry about validations just now)
	        // else, save the user in the database, save the user id in session, and redirect them to the /home route
	
	    public String registering(@Valid @ModelAttribute("user") User user, BindingResult result,HttpSession session) {

	    	if(result.hasErrors()) {
	    		return "login.jsp";
		}
		User thisUser=userService.registerUser(user);
		session.setAttribute("userId", thisUser.getId());
		return "redirect:/dashboard";
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,RedirectAttributes errors, Model model, HttpSession session) {
	        // if the user is authenticated, save their user id in session
	        // else, add error messages and return the login page
			boolean isLoggedIn=userService.authenticateUser(email, password);
			if(isLoggedIn) {
				User user=userService.findByEmail(email);
				session.setAttribute("userId", user.getId());
				return "redirect:/dashboard";
			}

			else {
				errors.addFlashAttribute("error", "Email or PassWord is Invalid ,Try Again!");
				return "redirect:/";
			}
		}

	    
	    @RequestMapping("/dashboard")
	    public String home(HttpSession session, Model model) {
	        // get user from session, save them in the model and return the home page
	    	Long userId=(Long) session.getAttribute("userId");
			User thisUser=userService.findUserById(userId);
			model.addAttribute("user",thisUser);
			return "Home.jsp";
	    }
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	        // redirect to login page
	    	session.invalidate();
			return "redirect:/register";
	    }
	}

