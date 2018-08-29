package com.edu.ssh.service.login;

import com.edu.ssh.dao.user.IUserDao;
import com.edu.ssh.entity.User;

public class LoginServiceImpl implements IloginService {
	private IUserDao dao;
	
	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public int validate(User user) {
		
		return dao.validate(user);
	}

	@Override
	public int getIdByAccount(String account) {
		// TODO Auto-generated method stub
		return dao.getIdByAccount(account);
	}

}
