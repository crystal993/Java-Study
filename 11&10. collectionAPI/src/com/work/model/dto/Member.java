package com.work.model.dto;
 
/**
 * <pre>
 * 회원 도메인 클래스 
 * -- encapsulation 설계 반영 변경
 * ## 회원 검증조건
 *	1. 아이디 : 6자리 ~ 30자리 이내
 *	2. 비밀번호 : 6자리 ~ 20자리 이내
 *	3. 마일리지 : 0 ~ 100,000 
 *	4. 등급 : G, S, A
 *   문자열 비교 메서드
 *	 String
 *	 equals(Object anObject) : boolean
 * 
 * -- inheritance 설계 반영 변경
 *   모든 회원들의 공통(일반화) : 부모 클래스 설계 변경
 * 	1. 아이디
 * 	2. 비밀번호
 * 	3. 이름
 * 	4. 휴대폰
 * 	5. 이메일
 * 	6. 가입일
 * 	7. 등급
 * 
 * </pre>
 * @author 임경혜
 * @version ver.1.0
 * @since jdk1.8
 */
public class Member {
	/** 아이디, 식별키 */
	private String memberId;
	
	/** 비밀번호, 필수 */
	private String memberPw;
	
	/** 이름, 필수 */
	private String name;
	
	/** 휴대폰, 필수, 형식 01012341234 */
	private String mobile;
	
	/** 이메일, 필수 */
	private String email;
	
	/** 가입일, 필수, 형식 2021-05-26, 시스템 현재날짜 제공 */ 
	private String entryDate;
	
	/** 등급, 필수, 일반(G), 우수(S), 관리자(A), 시스템 제공 */
	private String grade;
	
	
	/** 기본생정자 */
	public Member() {
//		System.out.println("부모 기본생성자");
	}

	/**
	 * 사용자입력 필수데이터 초기화 생성자 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * @param memberId 아이디 
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
//		System.out.println("부모 사용자입력 필수데이터 초기화 생성자");
	}

	/**
	 * 회원 필수데이터 초기화 생성자 : 입력필수데이터 + 가입일, 등급
	 * @param memberId 아이디 
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		this(memberId, memberPw, name, mobile, email);
		this.entryDate = entryDate;
		this.grade = grade;
//		System.out.println("부모 회원 필수데이터 초기화 생성자");
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

// 재정의하지 않으면 java,lang.Object#toString() 상속 메서드를 그대로 사용 
// getClass().getName() + '@' + Integer.toHexString(hashCode())
 
	// 재정의하면 => 재정의한 결과를 반영
//	 @Override
//	public String toString() {
//		return memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email + ", " + entryDate + ", "
//				+ grade;
//		// 상속이 편리한점 : memberPw 는 보안 문제로 보여주면 안될것 같애 
//		// 부모 클래스인 Member의 toString()에서 재정의할 때 memberPw만 빼서 보여주면 됨.
//		// 상속을 안했다면? => 자식 클래스 일반, 우수, 관리자 회원 클래스에 존재하는 memberPw를 일일이 지워야함.
//		// => 효율성, 중복성제거, 일반화
//	}
	
	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append(memberId);
//		builder.append(", ");
//		builder.append(memberPw);
//		builder.append(", ");
//		builder.append(name);
//		builder.append(", ");
//		builder.append(mobile);
//		builder.append(", ");
//		builder.append(email);
//		builder.append(", ");
//		builder.append(entryDate);
//		builder.append(", ");
//		builder.append(grade);
//		
//		return builder.toString();
//		// stringBuilder의 부모가 누구인가? => Object
//			
//	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId).append(", ").append(memberPw).append(", ").append(name).append(", ").append(mobile)
				.append(", ").append(email).append(", ").append(entryDate).append(", ").append(grade);
		return builder.toString();
	}

	
	// 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
			return result;
//			return 1004;
		}
	
	
	// equals() 재정의할 떼 : 논리적인 동일성을 갖고 싶다고 할 때.
	// 원래는 객체의 참조값이 같을때 같은거라 볼수 있음.
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) // 현재 객체와 전달받은 객체 obj 참조값이 같다면 트루
			return true;
		//=> 즉 자기자신과 자기자신을 비교할 때 True가 나와야합니다.
		
		
		if (obj == null) //전달받은 객체 obj에 참조값이 없다. => Null : 어떠한 객체도 참조(reference)하고 있지 않다. 
			return false;
		// => null이 아닌 참조 x와 y가 있을 때, x.equals(y)는 y.equals(x)가 true 일 때만 true를 반환한다.
	    // - 순서가 뒤바뀌어도 결과는 같아야 합니다.
		
		
		if (getClass() != obj.getClass()) //현재의 클래스와 전달받은 객체의 클래스가 같지 않으면 다른 객체
			return false;
		
		Member other = (Member) obj;
		
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	
	


	
	
	 
}

