package com.yechao.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import sun.util.logging.resources.logging;

/**
 * Servlet Filter implementation class Passwdfilter
 */
@WebFilter("/Passwdfilter")
public class Passwdfilter implements Filter {

    /**
     * Default constructor. 
     */
	
	private FilterConfig filterConfig;
		
		
    public Passwdfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		String inituserString=filterConfig.getInitParameter("passwd");
		String usernameString=request.getParameter("username");
		if(!inituserString.equals(usernameString)){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
