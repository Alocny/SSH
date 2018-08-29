package com.edu.ssh.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginFilter's doFilter");
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String path=request.getServletPath();
		System.out.println(path);
		
		
		if(path.equals("/login.jsp")||path.equals("/image.jsp")||
				path.equals("/login")||path.equals("/verifycode")
				||path.startsWith("/images")||path.startsWith("/css")
				||path.startsWith("/js")){
			chain.doFilter(request, response);
			return;
		}
		
		String name=(String) request.getSession().getAttribute("account");
		if(name==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
