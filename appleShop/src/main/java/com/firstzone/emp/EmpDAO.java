package com.firstzone.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shinhan.util.DBUtil;

// DAO(Data Access Object)
// Service → DB에 감
// 		   ←
public class EmpDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	// 1.특정부서의 직원조회  → where department_id = ?
	// 2.특정 job_id인 직원조회 → where job_id = ?
	// 3.급여가 ? 이상인 직원조회 → where salary >= ?
	// 4.부서, 직책, 급여, 입사일 조건으로 조회
	// → where department_id = ? and job_id = ? and salary >= ? and hire_date >= ?

	public List<JobDTO> selectAllJob() {
		// 모든 Job을 조회하기
		String sql = "select * from jobs";
		conn = DBUtil.getConnection();
		List<JobDTO> joblist = new ArrayList<JobDTO>();

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				JobDTO job = new JobDTO();
				
				job.setJob_id(rs.getString("job_id"));
				job.setJob_title(rs.getString("job_title"));
				job.setMin_salary(rs.getInt("min_salary"));
				job.setMax_salary(rs.getInt("max_salary"));
				
				joblist.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return joblist;
	}
	
	public List<EmpDTO> selectAll() {
		// 모든 직원을 조회하기
		String sql = "select * from employees order by employee_id";
		conn = DBUtil.getConnection();
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

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
		String sql = "select * from employees where employee_id=?";
		conn = DBUtil.getConnection();
		EmpDTO emp = null;

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			rs = st.executeQuery();

			if (rs.next()) {
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
	
	public List<EmpDTO> selectByDeptId(int deptid) {
		String sql = "select * from employees where department_id=?";
		conn = DBUtil.getConnection();

		List<EmpDTO> emplist = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptid);
			rs = st.executeQuery();

			while (rs.next()) {
				EmpDTO emp = makeEmp2(rs);
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
	
	public List<EmpDTO> selectByJobId(String jobid) {
		String sql = "select * from employees where job_id=?";
		conn = DBUtil.getConnection();

		List<EmpDTO> emplist = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, jobid);
			rs = st.executeQuery();

			while (rs.next()) {
				EmpDTO emp = makeEmp2(rs);
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
	
	public List<EmpDTO> selectBySalary(double salary) {
		String sql = "select * from employees where salary >=?";
		conn = DBUtil.getConnection();

		List<EmpDTO> emplist = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql);
			st.setDouble(1, salary);
			rs = st.executeQuery();

			while (rs.next()) {
				EmpDTO emp = makeEmp2(rs);
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
	
	public List<EmpDTO> selectByCondition(Map<String,Object> map) {
		String sql = """
				select * from employees 
				where 	department_id = ? and 
						job_id = ? and 
						salary >= ? and hire_date >= ?
				""";
		conn = DBUtil.getConnection();

		List<EmpDTO> emplist = new ArrayList<EmpDTO>();

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, (Integer)map.get("department_id"));
			st.setString(2, (String)map.get("job_id"));
			st.setDouble(3, (Double)map.get("salary"));
			st.setDate(4, (Date)map.get("hire_date"));
			rs = st.executeQuery();

			while (rs.next()) {
				EmpDTO emp = makeEmp2(rs);
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

	private static EmpDTO makeEmp2(ResultSet rs) throws SQLException {
		EmpDTO emp = EmpDTO.builder()
				.commission_pct(rs.getDouble("commission_pct"))
				.department_id(rs.getInt("department_id"))
				.email(rs.getString("email"))
				.employee_id(rs.getInt("employee_id"))
				.first_name(rs.getString("first_name"))
				.hire_date(rs.getDate("hire_date"))
				.job_id(rs.getString("job_id"))
				.last_name(rs.getString("last_name"))
				.manager_id(rs.getInt("manager_id"))
				.phone_number(rs.getString("phone_number"))
				.salary(rs.getDouble("salary"))
				.build();
		return emp;
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
