package com.edu.ssh.service.vip;

import java.util.List;

import com.edu.ssh.dao.vip.IVipCustomerDao;
import com.edu.ssh.entity.VIPCustomer;

public class VipCustomerServiceImpl implements IVipCustomerService {
	private IVipCustomerDao customerDao;
	
	public IVipCustomerDao getCustomerDao() {
		return customerDao;
	}
	
	public void setCustomerDao(IVipCustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public void save(VIPCustomer customer) {
		customerDao.save(customer);
	}

	@Override
	public void delete(VIPCustomer customer) {
		customerDao.delete(customer);
	}

	@Override
	public VIPCustomer getById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getById(id);
	}

	@Override
	public List<VIPCustomer> getVipCutomers() {
		// TODO Auto-generated method stub
		return customerDao.getVipCutomers();
	}

	@Override
	public List<VIPCustomer> getVipCustomersByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return customerDao.getVipCustomersByPage(pageNum, pageSize);
	}

	@Override
	public int getPageTotal(int pageSize) {
		// TODO Auto-generated method stub
		return customerDao.getPageTotal(pageSize);
	}

	@Override
	public void update(VIPCustomer customer) {
		customerDao.update(customer);
	}

	@Override
	public Long getCountByKey(String keyword) {
		// TODO Auto-generated method stub
		return customerDao.getCountByKey(keyword);
	}

	@Override
	public List<VIPCustomer> getVipCustomersByKey(String keyword) {
		// TODO Auto-generated method stub
		return customerDao.getVipCustomersByKey(keyword);
	}

}
