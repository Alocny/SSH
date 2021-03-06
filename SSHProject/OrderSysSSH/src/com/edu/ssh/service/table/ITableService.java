package com.edu.ssh.service.table;

import java.util.List;

import com.edu.ssh.entity.Table;

public interface ITableService {
	void save(Table table);

	void delete(Table table);

	Table getById(int id);

	List<Table> getTables();

	List<Table> getTablesByPage(int pageNum, int pageSize);

	int getPageTotal(int pageSize);

	void update(Table table);
	
	List<Table> getTablesisFree();

}
