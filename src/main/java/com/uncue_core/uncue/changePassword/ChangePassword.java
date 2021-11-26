package com.uncue_core.uncue.changePassword;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ChangePassword implements Serializable {

	private String oldPassword;

	private String newPassword;

}
