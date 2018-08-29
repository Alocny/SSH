package com.edu.ssh.dao.vip;

import java.util.List;

import com.edu.ssh.entity.VIPCustomer;

public interface IVipCustomerDao {
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
