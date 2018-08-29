package com.edu.ssh.service.user;

import java.util.List;

import com.edu.ssh.dao.user.IUserDao;
import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao;
	
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUsersByPage(int pageNum, int pageSize) {
		return userDao.getUsersByPage(pageNum, pageSize);
	}

	@Override
	public int getPageTotal(int pageSize) {
		return userDao.getPageTotal(pageSize);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);		
	}

	@Override
	public List<UserPosition> getAllPosition() {
		
		return userDao.getAllPosition();
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public UserPosition getPositionById(int id) {
		// TODO Auto-generated method stub
		return userDao.getPositionById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);		
	}

	@Override
	public Long getCountByKey(String keyword) {
		// TODO Auto-generated method stub
		return userDao.getCountByKey(keyword);
	}

	@Override
	public List<User> getUsersByKey(String keyword) {
		// TODO Auto-generated method stub
		return userDao.getUsersByKey(keyword);
	}

}
