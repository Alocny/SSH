package com.edu.ssh.dao.user;

import java.util.List;

import javax.swing.text.Position;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public class UserDaoImpl implements IUserDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getById(int id) {
		String hql="from User where id=?";
		return (User) sessionFactory.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
	}

	@Override
	public List<User> getUsers() {
		String hql="from User";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public int validate(User user) {
		String hql="select distinct u from User u inner join fetch u.position where u.account=?";
		User dbuser=(User) sessionFactory.getCurrentSession().createQuery(hql).setString(0, user.getAccount()).uniqueResult();
		if(dbuser==null){
			return -1;
		}
		if(dbuser.getPwd().equals(user.getPwd())){
			return dbuser.getPosition().getId();
		}
		return -1;
	}
	
	//获取每页数据
	@Override
	public List<User> getUsersByPage(int pageNum, int pageSize) {
		String hql="select distinct u from User u inner join fetch u.position order by u.id";
		List<User> users=sessionFactory.getCurrentSession().createQuery(hql)
					.setFirstResult((pageNum-1)*pageSize)
					.setMaxResults(pageSize).list();
		return users;
	}
	
	//获取总共多少页
	@Override
	public int getPageTotal(int pageSize) {
		String hql="select count(*) from User";
		Long count=(Long) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		int pageTotal=(int) ((count+pageSize-1)/pageSize);
		return pageTotal;
	}

	@Override
	public void delete(User user) {
		User myuser=(User) sessionFactory.getCurrentSession().get(User.class, user.getId());
		sessionFactory.getCurrentSession().delete(myuser);		
	}

	//获取所有的职位信息
	@Override
	public List<UserPosition> getAllPosition() {
		String hql = "from UserPosition";
		List<UserPosition> positions=sessionFactory.getCurrentSession()
									.createQuery(hql).list();
		return positions;
	}

	@Override
	public void update(User user) {
		User myuser = (User) sessionFactory.getCurrentSession().get(User.class, user.getId());
		myuser.setAccount(user.getAccount());
		myuser.setPwd(user.getPwd());
		myuser.setName(user.getName());
		myuser.setSex(user.getSex());
		myuser.setPhoneNumber(user.getPhoneNumber());
		myuser.setAddress(user.getAddress());
		myuser.setPosition(user.getPosition());
		myuser.setFaceImg(user.getFaceImg());
		sessionFactory.getCurrentSession().update(myuser);
	}

	@Override
	public UserPosition getPositionById(int id) {
		UserPosition position = (UserPosition) sessionFactory.getCurrentSession().get(UserPosition.class, id);
		return position;
	}

	@Override
	public Long getCountByKey(String keyword) {
		String hql="select count(*) from User where name like ?";
		Long count=(Long) sessionFactory.getCurrentSession().createQuery(hql)
					.setString(0, "%"+keyword+"%").uniqueResult();
		return count;
	}

	@Override
	public List<User> getUsersByKey(String keyword) {
		String hql="from User u inner join fetch u.position where u.name like ?";
		List<User> users=sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").list();
		return users;
	}

	@Override
	public int getIdByAccount(String account) {
		String hql="select id from User where account=?";
		int id=(Integer) sessionFactory.getCurrentSession().createQuery(hql).setString(0, account).uniqueResult();
		return id;
	}

}
