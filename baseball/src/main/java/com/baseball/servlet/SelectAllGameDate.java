package com.baseball.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.baseball.service.BaseballService;

// 모든 경기 일정
@WebServlet("/allGameDate.select")
public class SelectAllGameDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseballService bService = new BaseballService();
		List<String> datelist = bService.selectAllGameDate();
		
        // JSON 객체 생성
        JSONObject jsonResponse = new JSONObject();
        JSONArray jsonDates = new JSONArray();

        for (String date : datelist) {
            jsonDates.add(date);  // "2023-05-25"와 같은 형식으로 추가
        }
        jsonResponse.put("dates", jsonDates);

        // 응답 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // JSON 응답 쓰기
        response.getWriter().write(jsonResponse.toJSONString());
        
//      request.setAttribute("datelist", datelist);
//		RequestDispatcher rd = request.getRequestDispatcher("jsp/selectAllGameDate.jsp");
//		rd.forward(request, response);
	}
}
