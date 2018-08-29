package com.edu.ssh.dao.table;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edu.ssh.entity.Table;


public class TableDaoImpl implements ITableDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Table table) {
		sessionFactory.getCurrentSession().save(table);
	}

	@Override
	public void delete(Table table) {
		Table mytable = (Table) sessionFactory.getCurrentSession().get(Table.class, table.getId());
		sessionFactory.getCurrentSession().delete(mytable);
	}

	@Override
	public Table getById(int id) {
		String hql = "from Table where id = ?";
		Table table = (Table) sessionFactory.getCurrentSession()
				.createQuery(hql).setInteger(0, id).uniqueResult();
		return table;
	}

	@Override
	public List<Table> getTables() {
		String hql = "from Table";
		List<Table> tables = sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return tables;
	}

	@Override
	public List<Table> getTablesByPage(int pageNum, int pageSize) {
		String hql = "from Table";
		List<Table> tables = sessionFactory.getCurrentSession()
				.createQuery(hql).setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
		return tables;
	}

	@Override
	public int getPageTotal(int pageSize) {
		String hql = "select count(*) from Table";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql)
				.uniqueResult();
		int pageTotal = (int) ((count + pageSize - 1) / pageSize);
		return pageTotal;
	}

	@Override
	public void update(Table table) {
		sessionFactory.getCurrentSession().update(table);
	}

	@Override
	public List<Table> getTablesisFree() {
		String hql = "from Table where isFree=?";
		List<Table> tables = sessionFactory.getCurrentSession().createQuery(hql)
								.setString(0, "是").list();
		return tables;
	}

}
