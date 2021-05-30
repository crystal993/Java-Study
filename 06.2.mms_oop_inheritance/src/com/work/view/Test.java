package com.work.view;

import com.work.model.dto.GeneralMember;

public class Test {

	public static void main(String[] args) {
		// 우리가 존재하는 이유 : 부모님이 대한민국이라는 땅을 할당받았기 때문에 그 위에 쓰고 있다.
		// => 즉 부모가 먼저 메모리가 올라가고 그 다음에 자식이 올라간다
		// 일반회원 자식객체 생성 절차 :  => 부모 메모리 할당 => 자식 메모리 할당		  

		GeneralMember g1 = new GeneralMember("User01","password01","홍길동","01012341000","user01@work.com");
		
		System.out.println(g1.getMemberId()); // Member 부모로부터 상속받은 메서드
		System.out.println(g1.getName());
	}

}
