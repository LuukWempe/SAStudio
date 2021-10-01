package com.stedin.HighVoltage.controllers;

import com.stedin.HighVoltage.model.users.AppUser;
import com.stedin.HighVoltage.repositories.AppUserRepository;
import com.stedin.HighVoltage.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class WebController {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	public WebController() {}

    @Autowired
    private AppUserRepository appUserRepository;



	private static final Logger logger = LoggerFactory.getLogger(WebController.class);


	@GetMapping({"/", "/home", "/index"})
	public String home() {
		return "home";		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}

	//return logout page
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "/logout";
	}

	@GetMapping("/open/**")
	public String open() {
		return "open";
	}


	@GetMapping("/admin/**")
	public String admin() {
		return "admin";
	}


	@GetMapping({"redirectLogin", "/dashboard"})
	public String getDashBoard() {

		try {
			AppUser user = appUserService.getActiveUser();
            if (!(user.isActivated())) {
                return "/trainee/accountsettings_firsttime";
            } else {
                String role = user.getRole();
                return "redirect:/home";
                		//+ role.toLowerCase() + "/dashboard";
            }
		} catch (Exception e) {
			return "/login";
		}
	}

    @GetMapping("/settings")
    public String accountsettings() {
        return "/settings";
    }
    

	@PostMapping("/login")
	public String validateLogin() {
		return "/dashboardpages/dashboardpage";
	}

    @PostMapping("/changepassword")
    public String changepassword(String new_password, String confirm_password) {

        //If new password equals confirmation password then update the database
        if (new_password.equals(confirm_password)) {
            appUserService.changePassword(new_password);

            //If it's the users first time, then set their account
            //to activated
            AppUser user = appUserService.getActiveUser();
            if (!user.isActivated()) {
                user.setActivated(true);
                appUserRepository.save(user);
            }

            return "redirect:/redirectLogin";
        }

        return "redirect:/trainee/accountsettings";
    }


	@PostMapping("/register")
	public String register(String username,
						   String firstName,
						   String lastName,
						   String email,
						   String password,
						   String role,
						   boolean enabled,
						   boolean activated,
						   Date dateofbirth,
						   String zipcode,
						   String street,
						   String streetNr,
						   String city,
						   String country,
						   String telephonenumber,
						   String bootcamp){

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		appUserService.registerUser(username,
				firstName,
				lastName,
				email,
				encoder.encode(password),
				role,
				enabled,
				activated,
				dateofbirth,
				zipcode,
				street,
				streetNr,
				city,
				country,
				telephonenumber,
				bootcamp);

		return "/dashboardpages/dashboardpage";
	}
}