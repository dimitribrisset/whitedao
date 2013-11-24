package com.db.whitedao.rest;

import com.db.whitedao.dao.generic.DAOFactory;
import com.db.whitedao.model.Amount;
import com.db.whitedao.model.MonthData;
import com.google.common.collect.Maps;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class TestServlet
		extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		MonthData monthData = new MonthData();
		monthData.setName("coucou");
		monthData.setDescription("description");
		monthData.setYear(1985L);
		monthData.setMonth(4L);
		Map<Long, Amount> amounts = Maps.newHashMap();
		Amount amount = new Amount();
		amount.setName("amount1");
		amount.setRecipient("me");
		amounts.put(1L, amount);
		monthData.setAmounts(amounts);

		DAOFactory.getMonthDataDAO().save(monthData);


		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		resp.getWriter().println(DAOFactory.getMonthDataDAO().get(monthData.getId()));
	}
}