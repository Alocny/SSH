package com.edu.ssh.service.dish;

import java.util.List;

import com.edu.ssh.dao.dish.IDishDao;
import com.edu.ssh.entity.Dish;

public class DishServiceImpl implements IDishService {
	private IDishDao dishDao;

	public IDishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(IDishDao dishDao) {
		this.dishDao = dishDao;
	}

	@Override
	public void save(Dish dish) {
		dishDao.save(dish);
	}

	@Override
	public void delete(Dish dish) {
		dishDao.delete(dish);
	}

	@Override
	public Dish getById(int id) {

		return dishDao.getById(id);
	}

	@Override
	public List<Dish> getDishs() {
		// TODO Auto-generated method stub
		return dishDao.getDishs();
	}

	@Override
	public List<Dish> getDishsByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dishDao.getDishsByPage(pageNum, pageSize);
	}

	@Override
	public int getPageTotal(int pageSize) {
		// TODO Auto-generated method stub
		return dishDao.getPageTotal(pageSize);
	}

	@Override
	public void update(Dish dish) {
		dishDao.update(dish);
	}

	@Override
	public Long getCountByKey(String keyword) {
		// TODO Auto-generated method stub
		return dishDao.getCountByKey(keyword);
	}

	@Override
	public List<Dish> getDishsByKey(String keyword) {
		// TODO Auto-generated method stub
		return dishDao.getDishsByKey(keyword);
	}

}
