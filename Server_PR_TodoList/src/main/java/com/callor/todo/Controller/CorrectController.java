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

@WebServlet("/one/*")
public class CorrectController extends HttpServlet {
	private static final long serialVersionUID = -2435993822664438947L;

	ToDoService tdS;

	public CorrectController() {
		tdS = new ToDoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();

		if (subPath == null ) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			ListVO tdVO = tdS.selectBySeq(td_seq);
			
			req.setAttribute("TDVO", tdVO);
			req.getRequestDispatcher("/WEB-INF/views/correction.jsp").forward(req, resp);
			
		}  else if (subPath.equals("/delete")) {

			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);

			tdS.delete(td_seq);
			resp.sendRedirect("/todo/");
		}


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String subPath = req.getPathInfo();
		
		System.out.println(subPath);
		if (subPath.equals("/update")) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			
			ListVO tdVO = tdS.selectBySeq(td_seq);
			
			String td_date = req.getParameter("td_date");
			String td_time = req.getParameter("td_time");
			String td_todo = req.getParameter("td_todo");
			String td_place = req.getParameter("td_place");
			
			tdVO.setTd_seq(td_seq);
			tdVO.setTd_date(td_date);
			tdVO.setTd_time(td_time);
			tdVO.setTd_todo(td_todo);
			tdVO.setTd_place(td_place);
			Integer result = tdS.update(tdVO);
			if (result > 0)
				resp.sendRedirect("/todo/");

		}
	}

}
