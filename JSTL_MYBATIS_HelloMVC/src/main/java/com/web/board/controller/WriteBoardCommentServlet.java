package com.web.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.model.service.BoardService;

/**
 * Servlet implementation class WriteBoardCommentServlet
 */
@WebServlet("/board/writeBoardComment.do")
public class WriteBoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteBoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardRef = Integer.parseInt(request.getParameter("boardref"));
		String boardCommentContent = request.getParameter("content");
		int boardCommentLevel = Integer.parseInt(request.getParameter("level"));
		String boardCommentWriter = request.getParameter("commentWriter");
		int boardCommentRef = Integer.parseInt(request.getParameter("commentref"));
		
		Map param = new HashMap();
		param.put("boardRef", boardRef);
		param.put("boardCommentContent", boardCommentContent);
		param.put("boardCommentLevel", boardCommentLevel);
		param.put("boardCommentWriter", boardCommentWriter);
		param.put("boardCommentRef", boardCommentRef);
		
		int result = BoardService.getBoardService().insertBoardComment(param);
		
		String msg="", loc="";
		if(result>0) {
			msg = "댓글등록 성공";
		}
		else {
			msg = "댓글등록 실패";
		}
		loc="/board/readBoard.do?boardNo="+boardRef;
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
