package com.edu.ssh.dao.dish;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edu.ssh.entity.Dish;

public class DishDaoImpl implements IDishDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Dish dish) {
		sessionFactory.getCurrentSession().save(dish);
	}

	@Override
	public void delete(Dish dish) {
		Dish mydish=(Dish) sessionFactory.getCurrentSession()
				.get(Dish.class, dish.getId());
		sessionFactory.getCurrentSession().delete(mydish);
	}

	@Override
	public Dish getById(int id) {
		return (Dish) sessionFactory.getCurrentSession().get(Dish.class, id);
	}

	@Override
	public List<Dish> getDishs() {
		String hql="from Dish";
		List<Dish> dishes = sessionFactory.getCurrentSession()
							.createQuery(hql).list();
		return dishes;
	}

	@Override
	public List<Dish> getDishsByPage(int pageNum, int pageSize) {
		String hql="from Dish";
		List<Dish> dishes=sessionFactory.getCurrentSession().createQuery(hql)
					.setFirstResult((pageNum-1)*pageSize)
					.setMaxResults(pageSize).list();
		return dishes;
	}

	@Override
	public int getPageTotal(int pageSize) {
		String hql="select count(*) from Dish";
		Long count=(Long) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		int pageTotal=(int) ((count+pageSize-1)/pageSize);
		return pageTotal;
	}

	@Override
	public void update(Dish dish) {
		Dish mydish=(Dish) sessionFactory.getCurrentSession()
						.get(Dish.class, dish.getId());
		mydish.setName(dish.getName());
		mydish.setDescription(dish.getDescription());
		mydish.setTxt(dish.getTxt());
		mydish.setImg(dish.getImg());
		mydish.setIsRecommended(dish.getIsRecommended());
		mydish.setPrice(dish.getPrice());
		sessionFactory.getCurrentSession().update(mydish);
	}

	@Override
	public Long getCountByKey(String keyword) {
		String hql="select count(*) from Dish where name like ?";
		Long count=(Long) sessionFactory.getCurrentSession().createQuery(hql)
					.setString(0, "%"+keyword+"%").uniqueResult();
		return count;
	}

	@Override
	public List<Dish> getDishsByKey(String keyword) {
		String hql="from Dish where name like ?";
		List<Dish> dishes=sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").list();
		return dishes;
	}

}
