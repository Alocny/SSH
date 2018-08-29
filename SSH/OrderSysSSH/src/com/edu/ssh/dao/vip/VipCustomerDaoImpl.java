package com.edu.ssh.dao.vip;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edu.ssh.entity.VIPCustomer;

public class VipCustomerDaoImpl implements IVipCustomerDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(VIPCustomer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void delete(VIPCustomer customer) {
		VIPCustomer mycustomer = (VIPCustomer) sessionFactory
				.getCurrentSession().get(VIPCustomer.class, customer.getId());
		sessionFactory.getCurrentSession().delete(mycustomer);
	}

	@Override
	public VIPCustomer getById(int id) {
		String hql = "from VIPCustomer where id = ?";
		VIPCustomer customer = (VIPCustomer) sessionFactory.getCurrentSession()
				.createQuery(hql).setInteger(0, id).uniqueResult();
		return customer;
	}

	@Override
	public List<VIPCustomer> getVipCutomers() {
		String hql = "from VIPCustomer";
		List<VIPCustomer> customers = sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return customers;
	}

	@Override
	public List<VIPCustomer> getVipCustomersByPage(int pageNum, int pageSize) {
		String hql = "from VIPCustomer";
		List<VIPCustomer> customers = sessionFactory.getCurrentSession()
				.createQuery(hql).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
		return customers;
	}

	@Override
	public int getPageTotal(int pageSize) {
		String hql = "select count(*) from VIPCustomer";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql)
				.uniqueResult();
		int pageTotal = (int) ((count + pageSize - 1) / pageSize);
		return pageTotal;
	}

	@Override
	public void update(VIPCustomer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	@Override
	public Long getCountByKey(String keyword) {
		String hql = "select count(*) from VIPCustomer where name like ?";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql)
				.setString(0, "%" + keyword + "%").uniqueResult();
		return count;
	}

	@Override
	public List<VIPCustomer> getVipCustomersByKey(String keyword) {
		String hql = "from VIPCustomer where name like ?";
		List<VIPCustomer> customers = sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%" + keyword + "%").list();
		return customers;
	}

}
