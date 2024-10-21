package com.shinhan.day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 실행시 DB연결해서
// SQL문 실행
// 결과받기
public class DBConnectTest {
	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe", 
			   userid="hr", userpw="hr";
		String sql="""
				select *
				from employees
				where hire_date between '2000-01-01' and '2009-12-31'
				and department_id in(30,50,80)
				and salary between 5000 and 17000
				and commission_pct is not null
				order by hire_date asc, salary desc
				""";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.Driver Load : Success");
			
			conn = DriverManager.getConnection(url,userid,userpw);
			System.out.println("2.DB Connection : Success");
			
			st = conn.createStatement();
			System.out.println("3.SQL문 전송통로 생성 : Success");
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("직원ID:"+rs.getInt("EMPLOYEE_ID"));
				System.out.println("firstName:"+rs.getString("first_Name"));
				System.out.println("lastName:"+rs.getString("last_Name"));
				System.out.println("salary:"+rs.getInt("salary"));
				System.out.println("commission_pct:"+rs.getDouble("COMMISSION_PCT"));
				System.out.println("hiredate:"+rs.getDate("hire_date"));
				System.out.println("--------------------------------------------------------------------");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void f1() throws ClassNotFoundException, SQLException {
		// 0.class path 지정
		// Build Path > Libraries > Classpath에 jar 설정
		
		// 1.Driver Load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Load 성공");
		
		// 2.DB연결
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="hr", pw="hr";
		Connection conn = DriverManager.getConnection(url, id, pw);
		System.out.println("연결성공");
		
		// 3.대화통로 생성
		Statement st = conn.createStatement();
		System.out.println("SQL문 전송통로 생성");
		
		// 4.SQL문 생성 (문장안에는 ; 사용하지 말것)
		String sql = "select * from employees";
		
		// select 실행 결과는 ResultSet으로 return
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.print("직원번호:"+rs.getInt(1)); // DB는 1부터 시작
			System.out.print("\t직원이름:"+rs.getString("first_name"));
			System.out.print("\t급여:"+rs.getDouble("salary"));
			System.out.print("\t입사일:"+rs.getDate("hire_date"));
			System.out.println();
		}
		
		rs.close();
		st.close();
		conn.close();
	}
}
