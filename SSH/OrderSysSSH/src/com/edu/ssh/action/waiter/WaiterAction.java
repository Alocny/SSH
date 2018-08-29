package com.edu.ssh.action.waiter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.Dish;
import com.edu.ssh.entity.Order;
import com.edu.ssh.entity.OrderContent;
import com.edu.ssh.entity.Table;
import com.edu.ssh.service.dish.IDishService;
import com.edu.ssh.service.order.IOrderService;
import com.edu.ssh.service.table.ITableService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class WaiterAction {
	private IDishService dishService;
	private ITableService tableService;
	private IOrderService orderService;

	private Integer currentPage4;

	// 接受Order参数
	private Integer tableId;
	private Integer waiterId;
	private Integer stateId;
	private Integer[] dishId;
	private Integer[] dishNumber;

	public Integer[] getDishId() {
		return dishId;
	}

	public void setDishId(Integer[] dishId) {
		this.dishId = dishId;
	}

	public Integer[] getDishNumber() {
		return dishNumber;
	}

	public void setDishNumber(Integer[] dishNumber) {
		this.dishNumber = dishNumber;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public Integer getCurrentPage4() {
		return currentPage4;
	}

	public void setCurrentPage4(Integer currentPage4) {
		this.currentPage4 = currentPage4;
	}

	public IDishService getDishService() {
		return dishService;
	}

	public void setDishService(IDishService dishService) {
		this.dishService = dishService;
	}

	public ITableService getTableService() {
		return tableService;
	}

	public void setTableService(ITableService tableService) {
		this.tableService = tableService;
	}

	public String list() {
		System.out.println("DishAction list");

		List<Dish> dishes = dishService.getDishs();
		ActionContext.getContext().getSession().put("wdishes", dishes);
		List<Table> wtables = tableService.getTablesisFree();
		ActionContext.getContext().getSession().put("wtables", wtables);
		return "list";
	}

	public String test() {
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Table> wtables = tableService.getTablesisFree();

		Gson gson = new Gson();
		String gsontables = gson.toJson(wtables);
		System.out.println(gsontables);
		try {
			ServletActionContext.getResponse().getWriter().print(gsontables);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String payservice() {

		return "payservice";
	}

	public String orderok() {

		Order order = new Order();
		order.setBeginTime(new Date());
		order.setState(orderService.getOrderStateById(stateId));
		order.setWaiterId(waiterId);
		order.setTableId(tableId);
		Set<OrderContent> foods=new HashSet<OrderContent>();
		OrderContent food=null;
		for(int i=0;i<dishId.length;i++){
			food=new OrderContent();
			food.setDish(dishService.getById(dishId[i]));
			food.setDishNumber(dishNumber[i]);
			food.setOrder(order);
			foods.add(food);
		}
		order.setFood(foods);
		System.out.println(order);

		orderService.save(order);
		
		Table table = new Table();
		table.setId(tableId);
		table.setIsFree('否');
		tableService.update(table);
		
		return "orderok";
	}

}
