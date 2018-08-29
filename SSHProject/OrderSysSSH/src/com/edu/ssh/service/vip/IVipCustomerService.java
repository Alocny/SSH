package com.edu.ssh.service.vip;

import java.util.List;

import com.edu.ssh.entity.VIPCustomer;

public interface IVipCustomerService {
	void save(VIPCustomer customer);

	void delete(VIPCustomer customer);

	VIPCustomer getById(int id);

	List<VIPCustomer> getVipCutomers();

	List<VIPCustomer> getVipCustomersByPage(int pageNum, int pageSize);

	int getPageTotal(int pageSize);

	void update(VIPCustomer customer);

	Long getCountByKey(String keyword);

	List<VIPCustomer> getVipCustomersByKey(String keyword);
}
