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

@WebServlet("/")
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 2774596374931535272L;

	ToDoService tdS;
	public HomeController() {
		tdS = new ToDoServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 홈페이지 첫 화면
		
		SimpleDateFormat sd_date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sd_time = new SimpleDateFormat("HH:mm:ss");
		
		Date date = new Date(System.currentTimeMillis());
		
		List<ListVO> tdList = tdS.selectAll();
		
		req.setAttribute("DATE", sd_date.format(date));
		req.setAttribute("TIME", sd_time.format(date));
		req.setAttribute("TDLIST", tdList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		ListVO lVO = new ListVO();
		
		lVO.setTd_date(req.getParameter("td_date"));
		lVO.setTd_time(req.getParameter("td_time"));
		lVO.setTd_todo(req.getParameter("td_todo"));
		lVO.setTd_place(req.getParameter("td_place"));
	
		tdS.insert(lVO);
		resp.sendRedirect("/todo");
		
	}
	
	
	
	
	
}
