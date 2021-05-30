/**
 * 
 */
package com.work.model.service;

import com.work.model.dto.Member;

/**
 * <pre>
 * 
 * 1. 전체회원조회 : 관리자(actor)
 * >> (보안) 비밀번호 변경처리 : 앞2자리만 보여주고 나머지는 *문자대체 (이름,휴대폰, 비밀번호 공통사용기능 분리설계 - 유틸리티기능)
 2. 우수회원등업 : 일반회원의 마일리지가 100,000 이상
	>> 등업정책 결정
	>> 자동등업 : 	
	-- 마일리지가 변경되었을때?? 
	-- 매일 일정시각에 체크??
	-- 로그인성공시에 체크??
	>> 사용자 요청 등업
	>> 관리자 등업
마일리지 추가(변경)
	>> 마일리지 정책? : 글쓰기, 댓글, 
	>> 출석(로그인) : 매번 로그인마다 부여, 로그인 당일에 처음로그인시(1일 1번) ???
가입
로그인
내정보조회
비밀번호변경
내정보전체변경
초기화회원 등록기능(관리자 등)
아이디찾기
비밀번호찾기
 * </pre>
 * @author 김수정
 * @version ver.1.0
 * @since jdk.1.8
 */
public class MemberService {
	
	/** 
	 * 회원들의 객체를 그룹으로 관리하기 위한 자료 저장구조 멤버변수 선언 : 배열객체 생성은 생성자 위임처리 
	 * -- 접근권한 : public => private 변경 (외부에서 함부로 변경할수없음 : 보안데이터)
	 * */
	private Member[] members = new Member[5];
	
	/** 등록된 회원의 전체 수 및 등록해야하는 배열 요소의 인덱스번호 정보 
	 * -- 접근권한 : public => private 변경 (외부에서 함부로 변경할수없음 : 보안데이터)
	 * -- 변경 불가
	 * -- 등록 학생수 조회 제공 : getter()
	 * */
	private int size;
	
	/** 기본생성자 : 배열의 크기를 기본 5개 초기화 */
	public MemberService() {
	
	}
	
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
	 */ 
	public void addMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, int manager) {
		
		Member dto = new Member();
		dto.setMemberId(memberId);
		dto.setMemberPw(memberPw);
		dto.setName(name);
		dto.setMobile(mobile);
		dto.setEmail(email);
		dto.setEntryDate(entryDate);
		dto.setGrade(grade);
	
		
	}
	
	
}
