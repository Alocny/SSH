package com.edu.ssh.service.login;

import com.edu.ssh.entity.User;

public interface IloginService {
	int validate(User user);
	int getIdByAccount(String account);
}
