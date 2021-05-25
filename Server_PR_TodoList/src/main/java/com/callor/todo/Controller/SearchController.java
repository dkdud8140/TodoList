package com.callor.todo.Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.ListVO;
import com.callor.todo.service.ToDoService;
import com.callor.todo.service.impl.ToDoServiceImplV1;

@WebServlet("/search/*")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 4683233966230841913L;

	ToDoService tdS;

	public SearchController() {
		tdS = new ToDoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();

		SimpleDateFormat sd_date = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		List<ListVO> tdList = tdS.selectAll();
		req.setAttribute("DATE", sd_date.format(date));
		req.setAttribute("TDLIST", tdList);

		req.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		ListVO lVO = new ListVO();

		lVO.setTd_date(req.getParameter("td_date"));

		List<ListVO> tdList = tdS.selectByDate(lVO.getTd_date());
		req.setAttribute("TDLIST", tdList);
		req.getRequestDispatcher("/WEB-INF/views/show.jsp").forward(req, resp);

	}

}
