package com.edu.ssh.action.login;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.edu.ssh.dao.user.IUserDao;
import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;
import com.edu.ssh.service.login.IloginService;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<User> {
	private User user;
	private IloginService loginService;

	public IloginService getLoginService() {
		return loginService;
	}

	public void setLoginService(IloginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public User getModel() {
		if (user == null)
			user = new User();
		return user;
	}

	public String validate() {
		int positionId=loginService.validate(user);
		System.out.println(positionId);
		if(positionId==1){
			ServletActionContext.getRequest().getSession().setAttribute("account", user.getAccount());
			ServletActionContext.getRequest().getSession().setAttribute("aacount", user.getAccount());
			ServletActionContext.getRequest().getSession().setAttribute("adminid", loginService.getIdByAccount(user.getAccount()));
			return "admin";
		}else if(positionId==2){
			ServletActionContext.getRequest().getSession().setAttribute("account", user.getAccount());
			ServletActionContext.getRequest().getSession().setAttribute("waccount", user.getAccount());
			ServletActionContext.getRequest().getSession().setAttribute("waiterid", loginService.getIdByAccount(user.getAccount()));
			System.out.println("waiterid:"+loginService.getIdByAccount(user.getAccount()));
			return "waiter";
		}else if(positionId==3){
			ServletActionContext.getRequest().getSession().setAttribute("account", user.getAccount());
			ServletActionContext.getRequest().getSession().setAttribute("kaccount", user.getAccount());
			ServletActionContext.getRequest().getSession().setAttribute("kitchenid", loginService.getIdByAccount(user.getAccount()));
			return "kitchen";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("error", "用户名不存在，请重新登录");
			return "fail";
		}
	}
}
