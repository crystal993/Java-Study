package com.work.view;

import com.work.model.dto.Member;

public class Test {
	
	/*Encapsulation 테스트 */
	public static void main(String[] args) {
		Member dto = new Member("crystal","limemint","김수정","01031793167","ggg7152@gmail.com","","");
		System.out.println("변경전 : " + dto);
		// 아이디 변경 : 멤버 변수 접근 불가
		//dto.memberID = "aaa"; // 오류 : member 접근권한 private 선언, 외부에서 직접접근 불가
		
		System.out.println();
		// 아이디 변경 : setter()
		// 올바른 아이디 검증 규칙 준수
		dto.setMemberId("happyday2021");
		System.out.println("변경후 : " + dto);
		
		// 올바르지 않는 아이디 검증 규칙 준수
		dto.setMemberId("ac");
		System.out.println("변경후 : " + dto);
		
		System.out.println();
		// 비밀번호 변경 : setter()
		// 올바른 비밀번호 검증 규칙 준수
		dto.setMemberPw("timeqer");
		System.out.println("변경후 : " + dto);
			
		// 올바르지 않는 비밀번호 검증 규칙 준수
		dto.setMemberPw("ti");
		System.out.println("변경후 : " + dto);
		
		System.out.println();
		// 등급 변경 : setter()
		// 올바른 등급 검증 규칙 준수
		dto.setGrade("A");
		System.out.println("변경후 : " + dto);
					
		// 올바르지 않는 등급 검증 규칙 준수
		dto.setGrade("a");
		System.out.println("변경후 : " + dto);
		
	}
	
	/* toString() 메서드 재정의 및 사용 테스트 */
	public static void main1(String[] args) {
		
		// 회원의 가입시 입력데이터 초기화생성자 이용해서 객체 생성
		// 가입 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
		Member dto = new Member("crystal","limemint","김수정","01031793167","ggg7152@gmail.com");
		
		// 생성한 회원객체의 정보를 출력 - toString 메서드의 사용법
		// System.out.println(참조변수명); => 참조변수명.toString() 수행결과문자열을 콘솔창 출력
		// toString() 메서드 생략 가능
		System.out.println(dto.toString());
		System.out.println(dto);
		
	}

}
