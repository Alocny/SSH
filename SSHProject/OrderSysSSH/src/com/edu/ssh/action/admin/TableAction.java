package com.edu.ssh.action.admin;

import java.util.List;

import com.edu.ssh.entity.Table;
import com.edu.ssh.service.table.ITableService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class TableAction implements ModelDriven<Table> {
	private ITableService tableService;

	private Table table;

	private Integer currentPage5;

	public ITableService getTableService() {
		return tableService;
	}

	public void setTableService(ITableService tableService) {
		this.tableService = tableService;
	}

	public Integer getCurrentPage5() {
		return currentPage5;
	}

	public void setCurrentPage5(Integer currentPage5) {
		this.currentPage5 = currentPage5;
	}

	@Override
	public Table getModel() {
		if (table == null)
			table = new Table();
		return table;
	}

	private void showByPage(int pageSize) {
		System.out.println(currentPage5);
		if (currentPage5 == null) {
			currentPage5 = 1;
		}
		int pageTotal5 = tableService.getPageTotal(pageSize);
		if (currentPage5 < 1) {
			currentPage5 = 1;
		}
		if (currentPage5 > pageTotal5) {
			currentPage5 = pageTotal5;
		}
		ActionContext.getContext().getSession()
				.put("currentPage5", currentPage5);
		ActionContext.getContext().getSession().put("pageTotal5", pageTotal5);
		List<Table> tables = tableService.getTablesByPage(currentPage5,
				pageSize);
		ActionContext.getContext().getSession().put("tables", tables);
	}

	public String list() {
		showByPage(4);
		return "list";
	}

	public String add() {
		tableService.save(table);
		return "success";
	}
	
	public String delete(){
		tableService.delete(table);
		return "success";
	}
	
	public String update(){
		tableService.update(table);
		return "success";
	}
}
