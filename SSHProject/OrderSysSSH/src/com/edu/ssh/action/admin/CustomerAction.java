package com.edu.ssh.action.admin;

import java.util.List;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.VIPCustomer;
import com.edu.ssh.service.vip.IVipCustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction implements ModelDriven<VIPCustomer> {
	private VIPCustomer customer;

	private IVipCustomerService customerService;

	private Integer currentPage3;

	public Integer getCurrentPage3() {
		return currentPage3;
	}

	public void setCurrentPage3(Integer currentPage3) {
		this.currentPage3 = currentPage3;
	}

	public IVipCustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(IVipCustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public VIPCustomer getModel() {
		if (customer == null)
			customer = new VIPCustomer();
		return customer;
	}

	private void showByPage(int pageSize) {
		System.out.println(currentPage3);
		if (currentPage3 == null) {
			currentPage3 = 1;
		}
		int pageTotal3 = customerService.getPageTotal(pageSize);
		if (currentPage3 < 1) {
			currentPage3 = 1;
		}
		if (currentPage3 > pageTotal3) {
			currentPage3 = pageTotal3;
		}
		ActionContext.getContext().getSession().put("currentPage3", currentPage3);
		ActionContext.getContext().getSession().put("pageTotal3", pageTotal3);
		List<VIPCustomer> customers = customerService.getVipCustomersByPage(
				currentPage3, pageSize);
		ActionContext.getContext().getSession().put("customers", customers);
	}

	public String list() {
		showByPage(3);
		return "list";
	}

	public String add() {
		customerService.save(customer);
		return "success";
	}
	
	public String delete(){
		customerService.delete(customer);
		return "success";
	}

	public String update(){
		customerService.update(customer);
		return "success";
	}
}
