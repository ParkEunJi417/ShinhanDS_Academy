package com.shinhan4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;
import com.firstzone.member.MemberDTO;

@WebServlet("/dept/select.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeptListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 Member만 직원정보를 볼 수 있음
		// 세션은 Browser당 1개
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember2");
		if(member == null) {
			String path = getServletContext().getContextPath();
			response.sendRedirect(path + "/auth/login.do");
			return;
		}
				
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAllService();
		
		System.out.println("접속IP:"+request.getRemoteAddr()+","+deptlist.size()+"건 조회됨");
		
		// 요청(Browser) → Servlet 받음 → JSP에게 위임 → Browser
		request.setAttribute("deptDatas", deptlist);
		request.getRequestDispatcher("deptList.jsp").forward(request, response);
	}
}
