/**
 * 
 */
package com.work.model.dto;

/**
 *  <pre>
 * 일반 회원 도메인 클래스 
 * 
 * -- 회원(부모클래스)의 자식 (상속)
 * # 일반 회원 속성
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등급
 * 
 * 8. 직책 (String position)
 * 
 * </pre>
 * @author 김수정
 * @version ver.1.0
 * @since jdk1.8
 */
public class AdminMember extends Member {
	
	private String position;
	
	public AdminMember(){
		
	}
	
	/**
	 * 회원 입력 필수데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	// 자식 객체의 생성자에서 부모객체의 생성자를 미지정 => javac 자동으로 부모의 기본생성자 super() 자동 지정 호출 수행
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email) {
		
		// 자식객체의 생성자에서 부모객체의 생성자를 명시적으로 지정
		//super(memberId, memberPw, name, mobile,email);
		
		// 부모의 private 멤버는 접근권한으로 인해서 자식클래스일지라도 접근 불가
		//super.memberId = memberId;
		
		
		// 내가 부모로부터 상속 받은 setter() 메서드를 이용해서 데이터 초기화 수행
		setMemberId(memberId);
		setMemberPw(memberPw);
		setName(name);
		setMobile(mobile);
		setEmail(email);
		
		setGrade("A");
		setEntryDate("2021-05-26");
		
		System.out.println("자식 일반 입력필수데이터 초기화생성자");
		
	}

	/** 관리자 회원 모든 데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 * @param position 직책
	 */
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, String position) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		// TODO Auto-generated constructor stub
		
		this.position = position;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return super.toString() +", " + position ;
	}
}
