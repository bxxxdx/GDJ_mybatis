package com.web.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.member.model.service.MemberService;
import com.web.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		Member m = Member.builder()
//				.userId(request.getParameter("userId"))
//				.userName(request.getParameter("userName"))
//				.gender(request.getParameter("gender").charAt(0))
//				.age(Integer.parseInt(request.getParameter("age")))
//				.email(request.getParameter("email"))
//				.phone(request.getParameter("phone"))
//				.address(request.getParameter("address"))
//				.hobby(request.getParameterValues("hobby"))
//				.build();
		Map param = new HashMap();
		param.put("userId", request.getParameter("userId"));
		param.put("userName", request.getParameter("userName"));
		param.put("gender", request.getParameter("gender"));
		param.put("age", Integer.parseInt(request.getParameter("age")));
		param.put("email", request.getParameter("email"));
		param.put("phone", request.getParameter("phone"));
		param.put("address", request.getParameter("address"));
		param.put("hobby", request.getParameterValues("hobby"));
		
		int result = MemberService.getMemberService().updateMember(param);
		
		String msg="",loc="";
		if(result > 0) {
			msg = "회원수정성공!";
			loc = "/";	
			//session에 대한 데이터를 변경해줘야 한다.
			Member m = MemberService.getMemberService().searchMemberId(request.getParameter("userId"));
			request.getSession().setAttribute("loginMember", m);
		}else {
			msg = "회원수정실패!";
			loc = "/member/memberView.do?id="+request.getParameter("userId");	
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
