package com.backy.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		RequestDispatcher dis = request.getRequestDispatcher("board/boardCheckPass.jsp");//두번 넘어옴 (forword로)
		dis.forward(request, response);
	}

}
