package com.firstzone.dept_teacher;

import java.util.List;

public class DeptController {

	public static void main(String[] args) {
		
		DeptService deptService = new DeptService();
		System.out.println("==========모두조회test==============");
		List<DeptDTO> deptlist = deptService.selectAllService();
		DeptView.display(deptlist);
		
		System.out.println("==========특정부서 조회test==============");
		DeptDTO dept = deptService.selectByIdService(60);
		DeptView.display(dept);
		
		System.out.println("==========부서 입력test==============");
		DeptDTO deptInsert = new DeptDTO(5, "test", 100, 1700);
		int result = deptService.insertService(deptInsert);
		DeptView.display(result>0?"insert success":"insert fail");
		
		
		System.out.println("==========부서 수정test==============");
		DeptDTO deptUpdate = new DeptDTO(5, "test수정", 200, 1500);
		result = deptService.updateService(deptUpdate);
		DeptView.display(result>0?"update success":"update fail");
		DeptView.display(deptService.selectByIdService(5));
		
		
		System.out.println("==========부서 삭제test==============");
		result = deptService.deleteService(5);
		DeptView.display(result>0?"delete success":"delete fail");
		DeptView.display(deptService.selectByIdService(5));
		
	}
}
