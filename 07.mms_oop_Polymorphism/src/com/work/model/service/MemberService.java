/**
 * 
 */
package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * 회원을 관리하기 위한 서비스
 * -- 회원들을 관리하기 위한 자료저장구조 : 배열 다형성 반영 (부모타입)
 * -- 메서드 아규먼트 다형성(부모타입), 반환타입?? 
 * -- 메서드명(매개변수) : 반환타입
 * -- C(등록)
 * 
 * -- R(조회)
 * 		=> 단일 조회(상세조회) => 아이디
 * 		=> 다중 조회(전체조회, 그룹조회) => 전체조회(아규먼트 x), 등급별회원전체조회(등급)
 * -- U(변경)
 * 		=> 전체 변경()
 * 		=> 부분 변경(비밀번호변경) 
 * -- D(삭제)
 * 		=> 전체삭제
 * 		=> 특정삭제 : 아이디
 * <pre>
 * </pre>
 * @author 김수정
 * @version ver.1.0
 * @since jdk.1.8
 */
public class MemberService {
	
	/** 기본생성자 */
	public MemberService() {
	
	}
	
	/** 
	 * 회원들을 관리하기 위한 자료 저장구조 : 배열 다형성 반영 (부모타입) : 확장, 고정 본인이 편한 로직으로
	 * 생성자 사용초기화, 확장, 고정 본인이 편한 로직으로 진행 */
	private Member[] members = new Member[5];

	/**
	 * 회원등록
	 * --메서드명 addMember
	 * --매개변수 
	 * --반환타입
	 */
	
	
	
	/**
	 * 상세조회
	 * --메서드명
	 * --매개변수
	 * --반환타입
	 */
	
	/**
	 * 회원정보 전체변경
	 * --메서드명
	 * --매개변수
	 * --반환타입
	 */
	
	/**
	 * 회원탈퇴
	 * --메서드명
	 * --매개변수
	 * --반환타입
	 */
	
	/**
	 * 회원전체탈퇴
	 * --메서드명
	 * --매개변수
	 * --반환타입
	 */
	
	/**
	 * 초기회원 등록 메서드
	 */
	public void initMember() {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com","2020-12-15","G",50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com","2020-01-05","G",950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com","2020-11-15","S","강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com","2020-01-05","S","김하린");
		Member dto5 = new AdminMember("user05", "password05", "유관순", "01012345000", "administrator@work.com","2020-04-01","A","선임");
		
	}
	
	
	
	
	
	/** 등록된 회원의 전체 수 및 등록해야하는 배열 요소의 인덱스번호 정보 
	 * -- 접근권한 : public => private 변경 (외부에서 함부로 변경할수없음 : 보안데이터)
	 * -- 변경 불가
	 * -- 등록 학생수 조회 제공 : getter()
	 * */
	private int size;
	

	
	/** 현재 등록한 회원의 수 조회 메서드 */
	public int getCount() {
		return size;
	}
	
	/**
	 * 회원 가입 메서드 
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 * @param position 직책
	 */ 
	public void addMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, int manager, String position) {
		
		Member dto = new Member();
		 
		dto.setMemberId(memberId);
		dto.setMemberPw(memberPw);
		dto.setName(name);
		dto.setMobile(mobile);
		dto.setEmail(email);
		dto.setEntryDate(entryDate);
		dto.setGrade(grade);
		
		GeneralMember g = new GeneralMember();
		g = (GeneralMember)dto;
		
	}
	
	public void addMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		
		switch(grade) {
		
		case "G" :
			GeneralMember dto = new GeneralMember();
			dto.setMemberId(memberId);
			dto.setMemberPw(memberPw);
			dto.setName(name);
			dto.setMobile(mobile);
			dto.setEmail(email);
			dto.setEntryDate(entryDate);
			dto.setGrade(grade);
			dto.setMileage(mileage);
		case "S" :
			SpecialMember dto1 = new SpecialMember();
			dto1.setMemberId(memberId);
			dto1.setMemberPw(memberPw);
			dto1.setName(name);
			dto1.setMobile(mobile);
			dto1.setEmail(email);
			dto1.setEntryDate(entryDate);
			dto1.setGrade(grade);
			dto1.setManager(manager);
		case "A" :
			AdminMember dto2 = new AdminMember();
			dto2.setMemberId(memberId);
			dto2.setMemberPw(memberPw);
			dto2.setName(name);
			dto2.setMobile(mobile);
			dto2.setEmail(email);
			dto2.setEntryDate(entryDate);
			dto2.setGrade(grade);
		}
	}

}
