package com.edu.ssh.dao.user;

import java.util.List;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public interface IUserDao {
	void save(User user);
	void delete(User user);
	User getById(int id);
	int getIdByAccount(String account);
	UserPosition getPositionById(int id);
	List<User> getUsers();
	int validate(User user);
	List<User> getUsersByPage(int pageNum,int pageSize);
	int getPageTotal(int pageSize);
	List<UserPosition> getAllPosition();
	void update(User user);
	Long getCountByKey(String keyword);
	List<User> getUsersByKey(String keyword);
}
