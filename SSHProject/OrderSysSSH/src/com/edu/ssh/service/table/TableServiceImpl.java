package com.edu.ssh.service.table;

import java.util.List;

import com.edu.ssh.dao.table.ITableDao;
import com.edu.ssh.entity.Table;

public class TableServiceImpl implements ITableService {
	private ITableDao tableDao;
	
	public ITableDao getTableDao() {
		return tableDao;
	}
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	
	@Override
	public void save(Table table) {
		tableDao.save(table);
	}

	@Override
	public void delete(Table table) {
		tableDao.delete(table);
	}

	@Override
	public Table getById(int id) {
		// TODO Auto-generated method stub
		return tableDao.getById(id);
	}

	@Override
	public List<Table> getTables() {
		// TODO Auto-generated method stub
		return tableDao.getTables();
	}

	@Override
	public List<Table> getTablesByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return tableDao.getTablesByPage(pageNum, pageSize);
	}

	@Override
	public int getPageTotal(int pageSize) {
		// TODO Auto-generated method stub
		return tableDao.getPageTotal(pageSize);
	}

	@Override
	public void update(Table table) {
		tableDao.update(table);
	}

	@Override
	public List<Table> getTablesisFree() {
		// TODO Auto-generated method stub
		return tableDao.getTablesisFree();
	}

}
