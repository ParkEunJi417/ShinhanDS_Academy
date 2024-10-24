package com.firstzone.dbtest;

import java.util.List;

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
