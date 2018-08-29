package com.edu.ssh.action.waiter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class WaiterNoticeAction {

	public String dealnotice(){
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");   
        try {
        	ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		String message = (String) ActionContext.getContext().getApplication().get("message");
		if(message!=null){
			try {
				ServletActionContext.getResponse().getWriter().println(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
