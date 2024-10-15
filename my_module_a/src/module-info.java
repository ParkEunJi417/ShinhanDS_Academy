module my_module_a {
	// exports가 없으면 정보 은닉
	// 정보은닉 : 다른 프로젝트(모듈)에서 접근 불가
	exports pack1;
	exports pack2;
	
	requires transitive my_module_b;
}
// my_application_2_module → my_module_a → my_module_b
// my_application_2_module → my_module_b로 전이됨