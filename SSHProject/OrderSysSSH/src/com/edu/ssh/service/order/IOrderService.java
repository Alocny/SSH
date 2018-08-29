package com.edu.ssh.service.order;

import java.util.List;

import com.edu.ssh.entity.Order;
import com.edu.ssh.entity.OrderState;

public interface IOrderService {
	void save(Order order);
	void delete(Order order);
	Order getById(int id);
	List<Order> getOrders();
	void update(Order order);
	OrderState getOrderStateById(int id);
}
