package br.com.managersystems.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Popup<T> {
	T popup(HttpServletRequest req, HttpServletResponse resp);

	void list(List<T> list, HttpServletRequest req, HttpServletResponse resp);

}
