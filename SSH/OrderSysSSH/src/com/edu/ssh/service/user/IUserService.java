package com.edu.ssh.service.user;

import java.util.List;

import com.edu.ssh.dao.user.IUserDao;
import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public interface IUserService {	
	List<User> getUsersByPage(int pageNum,int pageSize);
	int getPageTotal(int pageSize);
	void delete(User user);
	List<UserPosition> getAllPosition();
	void update(User user);
	UserPosition getPositionById(int id);
	void save(User user);
	
	Long getCountByKey(String keyword);
	List<User> getUsersByKey(String keyword);
}
