package com.web.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web.board.model.service.BoardService;

/**
 * Servlet implementation class WriteBoardEndServlet
 */
@WebServlet("/board/writeBoardEnd.do")
public class WriteBoardEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteBoardEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect(request.getContextPath());
		} else {
			//저장할 위치 설정하기
			String path = request.getServletContext().getRealPath("/upload/notice");
			//저장파일 크기 설정
			//byte -> MB -> GB -> TB : 1024는 1byte
			int maxSize = 10*1024*1024; // 10MB;
			//인코딩설정
			String encoding = "UTF-8";
			//rename클래스
			DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
			
			//매개변수 있는 생성자 MultipartRequest클래스를 생성 ㄱㄱ
			MultipartRequest mr = new MultipartRequest(request, path, maxSize,encoding,dfr);
			
			String boardTitle = mr.getParameter("boardTitle");
			String boardWriter = mr.getParameter("boardWriter");
			String boardContent = mr.getParameter("boardContent");
			String fileName = mr.getFilesystemName("upFile");
			String oriName = mr.getOriginalFileName("upFile");
			
			Map param = new HashMap();
			param.put("boardTitle", boardTitle);
			param.put("boardWriter", boardWriter);
			param.put("boardContent", boardContent);
			param.put("fileName", fileName);
			param.put("oriName", oriName);
			
			int result = BoardService.getBoardService().insertBoard(param);
			String msg="",loc="";
			if(result > 0) {
				msg = "게시물이 등록되었습니다.";
				loc = "/board/boardList.do";
			}else {
				msg = "게시물 등록 실패 -.-";
				loc = "/board/writeBoard.do";
			}
			request.setAttribute("msg",msg);
			request.setAttribute("loc",loc);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
