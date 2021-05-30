/**
 * 
 */
package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * 회원을 관리하기 위한 서비스 (추상클래스 설계 변경)
 * -- 추상클래스 구성요소
 * >> 클래스 구성요소 + [추상메서드]
 * 
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
public abstract class MemberServiceAbstracct {
	
	/** 기본생성자 */
	public MemberServiceAbstracct() {
	
	}
	
	/**
	 * 회원등록
	 * --메서드명 addMember
	 * --매개변수 
	 * --반환타입
	 */
	public abstract void addMember(Member dto);
	//This method requires a body instead of a semicolon
	
	
	/**
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * @param memberId 아이디
	 * @return 존재시에 저장위치번호, 미존재시 -1
	 */
	public abstract int exist(String memberId);
	
	/**
	 * 상세조회
	 * -- 메서드명 : getMember()
	 * -- 매개변수 : memberId
	 * -- 반환타입 : Member ★ (반환타입다형성 : 부모타입)
	 */
	
	public abstract Member getMember(String memberId);
	
	
	/**
	 * 회원 전체 조회
	 * --메서드명 : getMember() => 중복정의 가능
	 * --매개변수 : 없음 no argument
	 * --반환타입 : 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성 반영하니 Member[] 타입의 배열
	 */
	
	public abstract Member[] getMember();
	
	/**
	 * 회원의 정보 전체변경
	 * --메서드명 : setMember()
	 * --매개변수 : Member
	 * --반환타입 : void / 오류발생시 메세지 처리 
	 * 회원정보 전체 변경 : 변경하고자 하는 객체를 새로 생성 
	 * => 예를들어 user03의 정보를 변경(user, bluesky, 이범진)할건데 아이디를 제외한 모든 정보를 사용자가 바꿀 수 있다.
	 * => 아까는 addMember()는 해당 객체가 존재하지 않으면 등록 했는데 setMember() 는 반대
	 * => ★ setMember()는 해당 객체가 존재해야 변경이 가능 => return i , i > 0일 때 변경 가능
	 * 
	 * 1. 변경하고자 하는 객체를 새로 생성
	 * 2. exist() 이용해서 저장되어있는지 아닌지 판별
	 * 3. member[변경할객체의 인덱스] 참조변수가 변경하고자 하는 객체(새로만든 객체)의 참조변수를 할당.  
	 */
	public abstract void setMember(Member dto);
	
	/**
	 * 회원 비밀번호 변경
	 * --메서드명 : setMemberPw()
	 * --매개변수 : memberId, memberPw, 변경비밀번호
	 * --반환타입 : boolean 암호변경성공 true, 실패하면 false
	 * 1. exist가지고 존재여부판별 => 존재하면 배열 인덱스 반환
	 * 2. 배열인덱스가 0보다 크면 넘겨받은 비밀번호와 저장된 비밀번호가 같은지 비교 : equals()
	 * 3. 비밀번호가 같으면 넘겨받은 비밀번호로 변경해준다. => setMemberPw 로 (setter()로)
	 * 4. 넘겨받은 비밀번호와 저장된 비밀번호가 같지 않다면 암호를 바꾸면 안된다 => 오류처리 
	 */
	
	public abstract boolean setMemberPw(String memberId,String memberPw,String desMemberPw);
	/**
	 * 회원탈퇴
	 * --메서드명 : removeMember()
	 * --매개변수 : 아이디, 비밀번호
	 * --반환타입 : void
	 * => 회원 비밀번호 변경과 같은 로직
	 * 1. 존재 여부 판별 => exist()
	 * 2. 저장된 아이디와 전달받은 아이디 비교 , 저장된 비밀번호와 전달받은 아이디 비교
	 * 3. 배열 참조 변수 members[index]에 null을 집어넣기 => 이게 삭제임
	 * => 문제발생 => 빈 공간이 많아져 메모리 낭비 
	 * => 1. 해결1 : 뒤에있는 요소를 앞으로 당겨온다(삭제한 위치부터 등록된 인원된만큼의 쉬프트 연산이 발생 => 수많은 io 발생)
	 *              => 단점 : 삭제된 위치부터 하나하나 올리는 게 비효율 
	 * => 2. 해결2 : -> 맨마지막에 있는 참조변수members[members.length] 안의 주소값을 삭제될 배열요소members[index]에 레퍼런스 
	 * 				=> 마지막 요소를 null로 바꾸면 쉬프트연산은 한번만 발생. 
	 * 4. count를 1 감소 시킨다.
	 */
	
	public abstract void removeMember(String memberId,String memberPw);
	
	/**
	 * 회원 전체 탈퇴 (배열요소 초기화)
	 * --메서드명 : removeMember() 
	 * --매개변수 : no argument
	 * --반환타입 : void
	 */
	public abstract void removeMember();
	
	
	/**
	 * 회원초기화등록
	 * --메서드명 : initMember() 
	 * --매개변수 : no argument
	 * --반환타입 : void
	 */
	public abstract void initMember();
	
}
