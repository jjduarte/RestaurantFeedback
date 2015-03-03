package br.com.managersystems.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.managersystems.entity.Customer;

@WebFilter(urlPatterns="/*")
public class AuditFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
	ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String user = getUser(req);

		System.out.println("User " + user + "acessing URI " + uri);
		chain.doFilter(request, response);

	}

	private String getUser(HttpServletRequest req) {
		Customer user = (Customer)req.getSession().getAttribute("user");
		if(user == null) return "<user offline>";
		return user.getLogin();

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
