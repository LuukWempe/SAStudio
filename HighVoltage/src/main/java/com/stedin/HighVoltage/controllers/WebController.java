package com.stedin.HighVoltage.controllers;

import com.stedin.HighVoltage.model.FileManager;
import com.stedin.HighVoltage.model.users.AppUser;
import com.stedin.HighVoltage.repositories.AppUserRepository;
import com.stedin.HighVoltage.repositories.StationRepository;
import com.stedin.HighVoltage.services.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @Autowired
    private FileManager fileManager;



	//private static final Logger logger = LoggerFactory.getLogger(WebController.class);


	@GetMapping({"/", "/home", "/index"})
	public String home(Model model) {
		model.addAttribute("user",appUserService.getActiveUser());
		return "/home";		
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	//return logout page
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "/login";
	}
	
	@PostMapping("/login")
	public String validateLogin() {
		return "/home";
	}

	@GetMapping("/open/**")
	public String open() {
		return "open";
	}


	@GetMapping("redirectLogin")
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
    
    @PostMapping("/updatesettings")
    public String updateSettings() {
    	return "/settings";
    }
    
    @GetMapping("/importio")
    public String getImportIO(){
    	//FileManager.importIO();
    	return "/importio";
    }
    
    @PostMapping("/read_scd")
    public String readscd(){
    	fileManager.importSCD("HighVoltage/src/main/resources/static/scd.xml");
    	return "redirect:/home";
    }
    
    @PostMapping("/importio")
    public String importio(){
    	fileManager.importSCD("HighVoltage/src/main/resources/static/station.xml");
    	return "/importio";
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

        return "redirect:/settings";
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

		return "/home";
	}
}