package com.web.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.model.service.BoardService;
import com.web.board.model.vo.Board;

/**
 * Servlet implementation class ReadBoardServlet
 */
@WebServlet("/board/readBoard.do")
public class ReadBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		//조회수 설정
		Cookie[] cookies = request.getCookies();
		String boardRead="";
		boolean readFlag = false;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name = c.getName();//key값
				String value = c.getValue();
				if(name.equals("boardRead")) {
					boardRead = value;
					if(value.contains("|"+ boardNo + "|")) {
						readFlag = true;
					}						
					break;
				}
			}
		}
		if(!readFlag) {
			//읽은적이 없다 -> 쿠키에 현재 게시글 번호 저장 && 조회수 증가
			Cookie c = new Cookie("boardRead", (boardRead+ "|" + boardNo + "|"));
			c.setMaxAge(60*60*24);
			response.addCookie(c);
		}
		
		int boardCommentCount = BoardService.getBoardService().searchBoardCommentCount(boardNo);
		//System.out.println(boardCommentCount);
		
		Map param = new HashMap();
		param.put("boardNo", boardNo);
		param.put("boardCommentCount", boardCommentCount);
		
		
		Board board = BoardService.getBoardService().searchBoardNo(param, readFlag);
		//System.out.println(board);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher("/views/board/readBoard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
