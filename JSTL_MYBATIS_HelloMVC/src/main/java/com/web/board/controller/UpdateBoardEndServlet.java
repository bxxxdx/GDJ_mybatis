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
import com.web.board.model.vo.Board;

/**
 * Servlet implementation class UpdateBoardEndServlet
 */
@WebServlet("/board/updateBoardEnd.do")
public class UpdateBoardEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardWriter = request.getParameter("boardWriter");
		String boardContent = request.getParameter("boardContent");
		
		Map param = new HashMap();
		param.put("boardNo", boardNo);
		param.put("boardTitle", boardTitle);
		param.put("boardWriter", boardWriter);
		param.put("boardContent", boardContent);
		
		int result = BoardService.getBoardService().updateBoard(param);
		
		String msg="",loc="";
		if(result>0) {
			msg = "게시물 수정이 완료되었습니다.^^";
			loc = "/board/boardList.do";
		} else {
			msg = "공지사항 수정 실패";
			loc = "/board/updateBoard.do?boardNo="+boardNo;
		}
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
