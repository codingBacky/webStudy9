package com.backy.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backy.dao.BoardDAO;
import com.backy.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		BoardVO vo = new BoardVO();
		
		vo.setName(request.getParameter("name"));
		vo.setContent(request.getParameter("content"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setPass(request.getParameter("pwd"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.insertBoard(vo);
		
		if(result == 1)
			response.sendRedirect("BoardServlet?command=board_list");
		
	}
}
