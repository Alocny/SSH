package com.edu.ssh.service.login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.ssh.dao.user.IUserDao;
import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao=(IUserDao) ac.getBean("myUserDao");
		UserPosition up1 = new UserPosition("经理");
		UserPosition up2=new UserPosition("服务员");
		UserPosition up3=new UserPosition("后厨");
		
		User user1=new User("admin", "123456", "/images/1.jpg", "丽丽", '女', "234234324","成都市", up1);
		User user2=new User("waiter", "123456", "/images/1.jpg", "飞飞", '男', "234234324","成都市", up1);
		User user3=new User("kitchen", "123456", "/images/1.jpg", "娜娜", '女', "234234324","成都市", up1);
		
		dao.save(user1);
		dao.save(user2);
		dao.save(user3);
	}

}
