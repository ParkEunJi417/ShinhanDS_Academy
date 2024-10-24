package com.firstzone.dept;

import java.util.List;

public class DeptService {
	DeptDAO deptDAO = new DeptDAO();

	public List<DeptDTO> selectAllService() {
		return deptDAO.selectAll();
	}

	public DeptDTO selectByIdService(int dept_id) {

		return deptDAO.selectById(dept_id);
	}

	// 입력서비스
	public int insertService(DeptDTO emp) {
		return deptDAO.insert(emp);
	}

	// 수정서비스
	public int updateService(DeptDTO emp) {
		return deptDAO.update(emp);
	}

	// 삭제서비스
	public int deleteService(int dept_id) {
		return deptDAO.delete(dept_id);
	}
}
