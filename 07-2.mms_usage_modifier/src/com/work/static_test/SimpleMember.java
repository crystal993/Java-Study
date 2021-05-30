package com.work.static_test;

/**
 * 회원 도메인 클래스
 *  회원아이디 memberId
 *  회원이름 name
 *  회원휴대폰 mobile
 *  
 *  # 설계규칙
 *  1.encapsulation
 *  2.생성자 중복정의 : 기본, 전체
 *  3. toString() 재정의
 *  4. equals(), hashCode() 재정의 : 아이디 같으면 같은 객체
 * @author Playdata
 *
 */
public class SimpleMember {
	
	// CLASS 변수 : 객체 생성없이 사용가능, 모든 객체가 공유변수
	public static int classCount;
	
	// instance 변수 : 객체 생성 후 참조변수명을 통해서 해당객체에서 사용하는 변수
	public int instanceCount; // 원래 대문자로 쓰면안됨.
	
	// static block 초기화 ★ 필요한 때가있으니 알아두기
	static {
		classCount = 1234567;
		System.out.println(classCount + " : 클래스가 로드될 때(프로그램 시작) 딱 한번만 수행합니다.");
	}
	
	// instance block 초기화 => 생성자 중복정의 활용 =>오늘만 보고 앞으로 쓸 일 없음
	// 생성자랑 같은 기능이라 생성자를 보통 많이 씀
	{
		System.out.println("객체 생성할 때마다 수행합니다.");
	}
	
	private String memberId;
	private String name;
	private String mobile;
	
	/**
	 * 기본 생성자
	 */
	public SimpleMember() {
		System.out.println("생성자 : 객체생성시 호출수행됩니다.\n");
	}
	
	/**전체 생성자
	 * @param memberId 아이디 
	 * @param name 이름
	 * @param mobile 휴대폰
	 */
	public SimpleMember(String memberId, String name, String mobile) {
		this.memberId = memberId;
		this.name = name;
		this.mobile = mobile;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleMember other = (SimpleMember) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	
}
