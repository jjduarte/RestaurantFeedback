package br.com.managersystems.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Popup<T> {
	T popup(HttpServletRequest req, HttpServletResponse resp);


}
