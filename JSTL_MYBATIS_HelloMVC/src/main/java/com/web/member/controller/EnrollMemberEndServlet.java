package com.web.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.common.AESEncrypt;
import com.web.member.model.service.MemberService;

/**
 * Servlet implementation class EnrollMemberEndServlet
 */
@WebServlet(name="enrollMemberEnd", urlPatterns="/member/enrollMemberEnd.do")
public class EnrollMemberEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		//전달된 email 암호화 처리하기
		try {
			email = AESEncrypt.encryptData(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Character gender = request.getParameter("gender").charAt(0);
		String[] hobby = request.getParameterValues("hobby");
		
		Map param = new HashMap();
		param.put("userId", userId);
		param.put("password", password);
		param.put("userName", userName);
		param.put("age", age);
		param.put("email", email);
		param.put("phone", phone);
		param.put("address", address);
		param.put("gender", gender);
		param.put("hobby", hobby);
		
		int result = MemberService.getMemberService().insertMember(param);
		String msg="",loc="";
		if(result > 0) {
			msg = "회원가입성공! 가입하신 아이디로 로그인해주세요.";
			loc = "/";	
		}
		else {
			msg = "회원가입 실패! 작성 내용을 다시 확인해주세요~";
			loc = "/";
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
