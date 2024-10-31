package com.firstzone.dbtest;

import java.sql.Date;
import java.util.List;
import java.util.Map;

// 사용자가 요청 → Controller → Service → DAO → DB
//				←			  ←			←	  ←
// DB 관련없는 업무 로직은 Service에서 수행
public class EmpService {

	EmpDAO empDAO = new EmpDAO();
	
	public List<EmpDTO> selectAllService() {
		return empDAO.selectAll();
	}
	
	public EmpDTO selectByIdService(int empid) {
		
		return empDAO.selectById(empid);
	}
	
	public List<EmpDTO> selectByDeptIdService(int deptid) {
		
		return empDAO.selectByDeptId(deptid);
	}
	
	public List<EmpDTO> selectByJobIdService(String jobid) {
		
		return empDAO.selectByJobId(jobid);
	}
	
	public List<EmpDTO> selectBySalaryService(double salary) {
		
		return empDAO.selectBySalary(salary);
	}
	
	public List<EmpDTO> selectByConditionService(Map<String,Object> map) {
		
		return empDAO.selectByCondition(map);
	}
	
	// 입력서비스
	public int insertService(EmpDTO emp) {
		return empDAO.insert(emp);
	}
	
	// 수정서비스
	public int updateService(EmpDTO emp) {
		return empDAO.update(emp);
	}
	
	// 삭제서비스
	public int deleteService(int empid) {
		return empDAO.delete(empid);
	}
}
