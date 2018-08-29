package com.edu.ssh.action.login;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

public class CodeVerifyAction {
	private String codeNum;

	public String getCodeNum() {
		return codeNum;
	}

	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
	}
	
	public String verify(){
		String flag="no";
		String codeValidate = (String) ServletActionContext.getRequest().getSession().getAttribute("codeValidate");
		if(codeValidate.equals(codeNum)){
			flag="yes";
		}
		try {
			ServletActionContext.getResponse().getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
