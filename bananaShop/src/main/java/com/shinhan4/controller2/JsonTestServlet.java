package com.shinhan4.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.firstzone.dept.DeptDTO;
import com.firstzone.dept.DeptService;

@WebServlet("/json.do")
public class JsonTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("jsonInfo");
		System.out.println("문자 : "+json);
		int result = 0;
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject)parser.parse(json);
			System.out.println("-----parsing후 data추출-----");
			
			Integer deptid = Integer.parseInt((String) obj.get("deptid"));
			Integer mid = Integer.parseInt((String) obj.get("mid"));
			Integer locid = Integer.parseInt((String) obj.get("locid"));
			String deptname = (String) obj.get("deptname");
			
			DeptDTO dept = DeptDTO.builder()
								  .department_id(deptid)
								  .department_name(deptname)
								  .location_id(locid)
								  .manager_id(mid)
								  .build();
			
			DeptService dService = new DeptService();
			result = dService.insertService(dept);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().append(result+"건 입력");
		
	}

}
