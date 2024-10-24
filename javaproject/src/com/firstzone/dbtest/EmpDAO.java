package com.firstzone.dbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

// DAO(Data Access Object)
// Service → DB에 감
// 		   ←
public class EmpDAO {

	public List<EmpDTO> selectAll() {
		// 모든 직원을 조회하기
		String sql = "select * from employees";
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return emplist;
	}
	
	public EmpDTO selectById(int empid) {
		String sql = "select * from employees where employee_id="+empid;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		EmpDTO emp = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if(rs.next()) {
				emp = makeEmp(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return emp;
	}
	
	// DB에 입력
	public int insert(EmpDTO emp) {
		int result=0;
		String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		// Statement는 ?(binding 변수 지원X) → PreparedStatement가 Statement를 상속받아 ?를 지원함
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone_number());
			st.setDate(6, emp.getHire_date());
			st.setString(7, emp.getJob_id());
			st.setDouble(8, emp.getSalary());
			st.setDouble(9, emp.getCommission_pct());
			st.setInt(10, emp.getManager_id());
			st.setInt(11, emp.getDepartment_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		// result가 1이면 성공
		return result;
	}
	
	// 수정
	public int update(EmpDTO emp) {
		int result=0;
		String sql = """
				update employees set  
					FIRST_NAME=?,    
					LAST_NAME=?,     
					EMAIL=?,         
					PHONE_NUMBER=?,  
					HIRE_DATE=?,     
					JOB_ID=?,        
					SALARY=?,        
					COMMISSION_PCT=?,
					MANAGER_ID=?,    
					DEPARTMENT_ID=?
				where EMPLOYEE_ID=?
				""";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		// Statement는 ?(binding 변수 지원X) → PreparedStatement가 Statement를 상속받아 ?를 지원함
		try {
			st = conn.prepareStatement(sql);
			st.setInt(11, emp.getEmployee_id());
			st.setString(1, emp.getFirst_name());
			st.setString(2, emp.getLast_name());
			st.setString(3, emp.getEmail());
			st.setString(4, emp.getPhone_number());
			st.setDate(5,emp.getHire_date());
			st.setString(6, emp.getJob_id());
			st.setDouble(7, emp.getSalary());
			st.setDouble(8, emp.getCommission_pct());
			st.setInt(9, emp.getManager_id());
			st.setInt(10, emp.getDepartment_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		// result가 1이면 성공
		return result;
	}
	
	// 삭제
	public int delete(int empid) {
		int result=0;
		String sql = """
				delete from employees
				where EMPLOYEE_ID=?
				""";
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		// Statement는 ?(binding 변수 지원X) → PreparedStatement가 Statement를 상속받아 ?를 지원함
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		// result가 1이면 성공
		return result;
	}

	private static EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();

		emp.setCommission_pct(rs.getDouble("commission_pct"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getDouble("salary"));

		return emp;
	}
}
