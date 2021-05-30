package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;

public class Test {
	
	//instanceof, typecasting, virtual method invocation 테스트
	public static void main(String[] args) {
		// 회원 초기화 데이터 참고로해서 회원 5명 객체 생성
		// 참조변수 타입은 부모타입 : 다형성
		// 부모타입의 참조변수에 일반회원(모든데이터 초기화 생성자) 객체 생성
		
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com","2020-12-15","G",50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com","2020-01-05","G",950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com","2020-11-15","S","강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com","2020-01-05","S","김하린");
		Member dto5 = new AdminMember("user05", "password05", "유관순", "01012345000", "administrator@work.com","2020-04-01","A","선임");
		
//		MemberServiceAbstract service = new MemberServiceAbstract();
//		error cannot instantiate the type MemberServiceAbstract
		
		print("회원관리 서비스 이용위한 객체생성");
		// 회원관리 서비스를 이용하기위한 구현객체 생성
		MemberService service = new MemberService();
		
		print("회원등록");
		service.addMember(dto1);
		service.addMember(dto2); 
		service.addMember(dto2); //문제?? => 해결 => 등록되지 않음
		service.addMember(dto2); //문제?? => 해결 => 등록되지 않음
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);
		//This method requires a body instead of a semicolon
		
		print("등록인원수 : " + service.getCount());
		
		/**
		 * 상세조회
		 * --메서드명
		 * --매개변수
		 * --반환타입
		 */
		print("user01 상세조회");
		Member dto = service.getMember("user01");
		if(dto != null) {
		System.out.println(dto); // virtual method invocation : 실제 자식객체의 재정의한 toString() 수행결과 출력
		}
		
		print("user09 상세조회");
		dto = service.getMember("user09");
		if(dto != null) {
			System.out.println(dto); // virtual method invocation : 실제 자식객체의 재정의한 toString() 수행결과 출력
			}
		
		print("전체조회");
		Member[] dtos = service.getMember();
		
		printMembers(dtos);
		
		print("회원정보 전체변경");
		Member modifyDto = new GeneralMember("user02", "lime02", "강낭콩", "01011112000", "lime02@work.com","2021-11-05","G",950000);
		service.setMember(modifyDto);

		/* 등급이 다를 때 오류 */
//		Member modifyDto2 = new GeneralMember("user02", "lime02", "강낭콩", "01011112000", "lime02@work.com","2021-11-05","A",950000);
//		service.setMember(modifyDto2);		
		
		/* 매개변수가 하나 없는 오류 */
//		Member modifyDto2 = new GeneralMember("user02", "lime02", "강낭콩", "01011112000", "lime02@work.com","2021-11-05","G");
//		service.setMember(modifyDto2);
		
		print("암호 변경");
		service.setMemberPw("user01", "password01", "lime01");
		
		print("회원 탈퇴");
		
		/*아이디 비밀번호 올바르게 입력한 경우*/
		service.removeMember("user01", "lime01");
		service.removeMember("user02", "password02");
//		/*잘못된 아이디와 비밀번호 입력한 경우*/
		service.removeMember("user07", "password01");
		
//		/*잘못된 비밀번호 입력한 경우*/
		service.removeMember("user02", "password01");
		
		print("회원 전체 탈퇴 (배열요소 초기화)");
		service.removeMember();
		
		print("회원 초기화 등록");
		service.initMember();
	}
	
	/* 테스트시에 출력위한 메소드 */
	public static void print (String message) {
		System.out.println("\n###" + message);
	}
	
	/*테스트시에 객체 배열를 출력하기 위한 메소드*/
	public static void printMembers(Member[] dtos) {
		for(int idx = 0; idx < dtos.length; idx++) {
			if(dtos[idx]!=null) {
			System.out.println(dtos[idx]);
			}
		}
	}
	
	
}