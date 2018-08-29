package com.edu.ssh.service.dish;

import java.util.List;

import com.edu.ssh.entity.Dish;

public interface IDishService {
	void save(Dish dish);
	void delete(Dish dish);
	Dish getById(int id);
	List<Dish> getDishs();
	List<Dish> getDishsByPage(int pageNum,int pageSize);
	int getPageTotal(int pageSize);
	void update(Dish dish);
	Long getCountByKey(String keyword);
	List<Dish> getDishsByKey(String keyword);
}
