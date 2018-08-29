package com.edu.ssh.action.admin;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ManagerNoticeAction {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String sendnotice(){
       ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");   
       try {
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		//将公告内容放在session中
		ActionContext.getContext().getApplication().put("message", message);
		System.out.println(ActionContext.getContext().getApplication().get("message"));
		return null;
	}
}
