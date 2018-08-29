package com.edu.ssh.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;
import com.edu.ssh.service.user.IUserService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User> {
	private IUserService userService;
	private Integer currentPage;
	private User user;
	private Integer myposition;
	private File img;
	private String imgFileName;

	private String keyword;

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public Integer getMyposition() {
		return myposition;
	}

	public void setMyposition(Integer myposition) {
		this.myposition = myposition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	private void showByPage(int pageSize) {
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(currentPage);
		if (currentPage == null) {
			currentPage = 1;
		}
		int pageTotal = userService.getPageTotal(pageSize);
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (currentPage > pageTotal) {
			currentPage = pageTotal;
		}
		ActionContext.getContext().getSession().put("currentPage", currentPage);
		ActionContext.getContext().getSession().put("pageTotal", pageTotal);
		List<User> users = userService.getUsersByPage(currentPage, pageSize);
		ActionContext.getContext().getSession().put("users", users);
	}

	public String list() {
		showByPage(3);
		List<UserPosition> positions = userService.getAllPosition();
		ActionContext.getContext().getSession().put("positions", positions);
		return "list";
	}

	public String delete() {
		userService.delete(user);
		return "success";
	}

	public String update() {

		String path = ServletActionContext.getServletContext().getRealPath(
				"/imgs");
		File file = new File(path, imgFileName);
		try {
			FileUtils.copyFile(img, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setFaceImg("../imgs/" + imgFileName);
		UserPosition position = new UserPosition();
		position.setId(myposition);
		position.setName(userService.getPositionById(myposition).getName());
		user.setPosition(position);
		System.out.println(user);
		userService.update(user);
		return "success";
	}

	public String add() {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/imgs");
		File file = new File(path, imgFileName);
		try {
			FileUtils.copyFile(img, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setFaceImg("../imgs/" + imgFileName);
		UserPosition position = new UserPosition();
		position.setId(myposition);
		position.setName(userService.getPositionById(myposition).getName());
		user.setPosition(position);
		System.out.println(user);
		userService.save(user);

		return "success";
	}
	
	public String search(){
		System.out.println("keyword:"+keyword);
		Long countbykey=userService.getCountByKey(keyword);
		List<User> users=userService.getUsersByKey(keyword);
		ActionContext.getContext().getSession().put("countbykey", countbykey);
		ActionContext.getContext().getSession().put("usersbykey", users);
		
		return "search";
	}
	@Override
	public User getModel() {
		if (user == null)
			user = new User();
		return user;
	}
}
