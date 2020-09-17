package org.final_proj.domain;

import lombok.Data;

@Data
public class UserVO {
	private String userId;
	private String userPwd;
	private String rePwd;
	private String userName;
	private String mailAddress;
	private String address;
	private String regdate;
	private char enabled;
}