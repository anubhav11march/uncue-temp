package com.uncue_core.uncue.changePassword;

import com.uncue_core.uncue.AuthRestApi.AuthRestAPIService;
import com.uncue_core.uncue.dto.ReturningMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${BaseUrl}")
public class PasswordResetController {

	@Autowired
	ChangePasswordService changePasswordService;

	@Autowired
	AuthRestAPIService authRestAPIService;

	@PostMapping("${resetPasswordUrl}")
	public ReturningMessage passwordUpdate(@RequestBody ChangePassword changePassword) throws Exception {
		return changePasswordService.passwordUpdate(changePassword);
	}
	
	@GetMapping("${logoutUrl}")
	public ReturningMessage authenticateUser() {
		return authRestAPIService.logout();
	}
}
