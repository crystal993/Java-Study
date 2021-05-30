/**
 * 
 */
package com.work.model.service;

import java.util.Arrays;

import com.sun.xml.internal.ws.wsdl.writer.document.Service;
import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;


/**
 * @author 김수정
 * @version ver.1.0
 * @since jdk.1.8
 */
public class MemberService extends MemberServiceAbstracct {

	/** 
	 * 회원들을 관리하기 위한 자료 저장구조 : 배열 다형성 반영 (부모타입) : 확장, 고정 본인이 편한 로직으로
	 * 생성자 사용초기화, 확장, 고정 본인이 편한 로직으로 진행 */
	private Member[] members = new Member[10];
	
	/** 등록된 회원의 전체 수 및 등록해야하는 배열 요소의 인덱스번호 정보 
	-- 접근권한 : public => private 변경 (외부에서 함부로 변경할수없음 : 보안데이터)
	 * -- 변경 불가
	 * -- 등록 학생수 조회 제공 : getter()
	 * */
	private int count;
	
	/**
	 * 현재 등록인원수 조회
	 * @return 현재 등록인원수
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * 회원 등록
	 * --메서드명 addMember
	 * --매개변수 : 다형성 반영 모든 회원을 등록하기 위한 메서드
	 * --반환타입 : void
	 * 1. 현재 등록죈 회원수(count)와 현재 members 배열의 크기를 비교한다.
	 * 
	 * => 별도의 메서드로 분리 설계 : 구현 클래스에서 메서드 선언 
	 * 2. 같으면 새롭게 확장배열(기존배열의 크기 +)을 생성해서 
	 * 3. 새로이 확장한 배열요소에 기존의 배열요소에 저장된 객체들을 이동 저장 시킨후
	 * 4. 기존에 참조하고 있는 배열 대신에 새로이 확장한 배열요소 변경 참조설정
	 * ...
	 * 5. count의 배열요소에 아규먼트로 전달받은 회원객체 등록 :
	 * 6. count를 1 증가 시킴
	 */
	@Override
	public void addMember(Member dto) {
		
		if (count == members.length) {
//			System.out.println("학생들의 자료 저장 구조를 추가 확장하였습니다.\n");
			extendMembers();
		}
		
		
		if(exist(dto.getMemberId()) < 0)
		{
			members[count++] = dto ; 
		} else {
			System.out.println("[오류] "+dto.getMemberId()+" 아이디는 사용할 수 없습니다.");
		}
		
		// 무조건 등록 문제 : 중복 => 해결 : 등록하기 전에 등록된 회원의 아이디가 같은지(같은 객체 equals())
		// 동일 아이디를 갖는 회원객체 존재하는 경우에는 오류메세지 출력
		// 오류메세지 : [오류] 000 아이디는 사용할 수 없습니다. 
		
//		System.out.println("현재 members 배열 번호 "+count+" : "+dto);
//		System.out.println(dto.getMemberId() + " 님 회원가입 되었습니다!");
//		System.out.println();
	
		
	}
	
//	//The type MemberService must implement the inherited abstract 
//	 method MemberServiceAbstracct.exist(String)
	/**
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * 1. 현재 등록된 회원수만큼 반복하면서
	 * 2. 배열에 저장된 객체의 아이디와 dto.getMemberId() 아규먼트로 전달받은 아이디가 같은지 비교해서(String#equals(문자열))
	 * 3. 아이디가 같으면 현재 저장된 배열요소의 인덱스번호를 반환
	 * 4. 반복을 다했는데도 return 되지 않았다면 아이디 정보를 갖는 해원객체가 존재하지 않으므로 -1
	 * @param memberId 아이디
	 * @return 존재시에 저장위치번호, 미존재시 -1
	 */
	@Override
	public int exist(String memberId) {
		
		// 1.
		for(int i = 0 ; i < count ; i++ ) {
			
			//2.
			if(memberId.equals(members[i].getMemberId())) {
				//3.
				return i;
		} }
		
		// 4.
		return -1;	// 파이썬은 -1이 배열의 제일 마지막요소
	}
	
	
	
	// 기존 배열요소를 기본 배열크기 + 배열크기를 확장 처리 메서드
	// System.arraycopy() 메서드 활용
	// public static void arraycopy(members, 0, membersTemp, 0, members.length);
	/**
	 * 배열구조 확장 메서드
	 * 1. 기존의 members 객체 배열크기 members.length보다 members.length만큼 더 큰 배열객체 membersTemp 생성 
	 * 		=> 왜 만들었나 ? 객체 배열 구조를 확장하기 위해 기존의 members 보다 length가 더 큰 객체배열이 필요. 
	 * 2. 기존의 배열 members에 있는 레퍼런스값을 새로만든 membersTemp에 할당 => System.arraycopy(옮길배열명,시작인덱스,도착배열명,시작인덱스,배열크기) 이용
	 * 3. members 참조값에 membersTemp 참조값 할당 => members가 더 큰 배열인 membersTemp 을 가리킬 것임
	 * @see.java.lang.System#arraycopy(Object, int, Object, int, int)
	 */
	public void extendMembers() {
		Member[] membersTemp = new Member[members.length + members.length];
		System.arraycopy(members, 0, membersTemp, 0, members.length);
		members = membersTemp;
		
	}

	/*
	 * 회원 상세조회 구현 절차
	 * 
	 * 1. exist(String memberId) : 저장위치 반환 
	 * 2. 저장위치가 0보다 크거나 같으면 : 존재함 
	 * 3. 0보다 크거나 같으면 존재하니까 해당 배열요소의 객체를 return 반환
	 * 4. 0보다 크거나 같지않으면(0보다 작으면) 존재하지 않음 : 존재하지 않으므로 객체타입의 기본값 return null
	 */
	@Override
	public Member getMember(String memberId) {
		
		int index = exist(memberId);//1.
		if(index >= 0) {			//2.
			return members[index];  //3.
		}
		System.out.println("[오류]"+memberId +"는 존재하지 않는 아이디입니다.");
		return null;
	}
	
	
	//전체 조회 이해하면 뒤에것도 다 같은 맥락임.
	/**
	 * 회원 전체 조회
	 * --메서드명 : getMember() => 중복정의 가능
	 * --매개변수 : 없음 no argument
	 * --반환타입 : 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성 반영하니 Member[] 타입의 배열
	 * => 배열의 크기만큼이 아니라 등록한 인원을 들고와서 사용자가 배열에 담겨있는 회원의 수만큼 사용자가 로직을 처리해야함.
	 * => 저장된 게 null이 아니면 사용자가 또 가공해야하는 불편함이 존재
	 * 1. 현재 등록된 인원수만큼의 배열을 새로 만들기 
	 * 2. 현재 새롭게 만들어놓은 배열에 저장되어있는 레퍼런스만 담기 
	 * 3. 이 새로 만든 배열을 반환해주면 더 좋지 않을까? => System.arrayCopy() 사용 
	 * 
	 */

	@Override
	public Member[] getMember() {
		Member[] currentMembers = new Member[count];
		System.arraycopy(members, 0, currentMembers, 0, count);
		
		return currentMembers;
	}
	

	/**
	 * 회원의 정보 전체변경
	 * --메서드명 : setMember()
	 * --매개변수 : Member
	 * --반환타입 : void / 오류발생시 메세지 처리 
	 * 회원정보 전체 변경 : 변경하고자 하는 객체를 새로 생성 
	 * => 예를들어 user03의 정보를 변경(user03, bluesky, 이범진)할건데 아이디를 제외한 모든 정보를 사용자가 바꿀 수 있다.
	 * => 아까는 addMember()는 해당 객체가 존재하지 않으면 등록 했는데 setMember() 는 반대
	 * => ★ setMember()는 해당 객체가 존재해야 변경이 가능 
	 * => 객체 존재 범위 0 ~ members.length 
	 * => index > 0 이거나 index < members.length 일 때 변경 가능
	 * 
	 * 0. 변경하고자 하는 객체를 새로 생성 => Test 클래스에서
	 * 1. exist() 로 객체배열에 
	 * 	- 형식이 틀리면 오류출력
	 *  - 아이디 없으면 오류출력
	 * 3. member[변경할객체의 인덱스] 참조변수가 변경하고자 하는 객체(새로만든 객체)의 참조변수를 할당.  
	 */
	
	@Override
	public void setMember(Member dto) {
		int index = exist(dto.getMemberId());
		
		if(index >= 0 && index <= members.length) {
			members[index] = dto;
			System.out.println(dto.getMemberId()+"가 변경되었습니다.");
			System.out.println(dto);
			return;
		} else {
			 System.out.println("[오류]"+dto.getMemberId()+"는 존재하지 않는 아이디입니다.");
		}
		

//		if(dto instanceof GeneralMember) {
//			GeneralMember g = (GeneralMember) dto;
//			if(g.getGrade() != "G") {
//				System.out.println("[오류] 잘못된 형식입니다. ");
//			}
//		} else if(dto instanceof SpecialMember) {
//			if(dto.getGrade() != "S") {
//				System.out.println("[오류] 잘못된 형식입니다. ");
//			}
//		} else {
//			if(dto.getGrade() != "A") {
//				System.out.println("[오류] 잘못된 형식입니다. ");
//			}
//		} => 음.. final로 각각 서브클래스에 선언해서 final상수를 바꾸는것에 대한 예외처리? 
		// 등급이 다르면 다르다고 예외처리를 해주고 싶었음... 
		// 매개변수가 하나 모자란 예외처리도 해보고 싶음.
	}

	/**
	 * 회원 비밀번호 변경
	 * --메서드명 : setMemberPw()
	 * --매개변수 : memberId, memberPw, 변경비밀번호
	 * --반환타입 : boolean 암호변경성공 true, 실패하면 false
	 * 1. exist()로 아이디 존재 여부 판별 =>반환값 int idx에 저장 
	 * => 아이디 존재하면 배열 인덱스 반환,존재하지 않으면 -1 반환
	 * 
	 * 2. 배열인덱스가 0보다 같거나 크면(아이디가 members[]에 존재하면)  
	 * 2-1. 넘겨받은 비밀번호(memberPw)와 저장된 비밀번호(members[idx].getMemberPw())가 같은지 비교 => equals()
	 * 2-2. 비밀번호가 같으면 바꾸고자하는 비밀번호(desMemberPw)로 변경해준다. => setMemberPw() (setter())
	 * 2-3. 넘겨받은 비밀번호와 저장된 비밀번호가 같지 않다면 암호를 바꾸면 안된다 => 오류처리 
	 * 
	 * 3. 배열인덱스가 0보다 작을 때(아이디가 members[]에 없을 때)
	 * 3-1. 오류출력 : [오류] memberId는 존재하지 않는 아이디입니다.
	 */
	
	@Override
	public boolean setMemberPw(String memberId,String memberPw,String desMemberPw) {
		//1.
		int index = exist(memberId);
		
		//2.
		if(index >= 0)
		{	//2-1.
			if(members[index].getMemberPw().equals(memberPw)) {
				//2-2.
				members[index].setMemberPw(desMemberPw);
				System.out.println("[완료]"+memberId+"님의 비밀번호가"+desMemberPw+"로 변경되었습니다!");
				System.out.println(members[index]);
				return true;
			} else { //2-3.
				System.out.println("[오류]"+memberPw+"는 잘못된 비밀번호입니다.");
				return false;
			}
		}	// 3.
			 System.out.println("[오류]"+memberId+"는 존재하지 않는 아이디입니다.");
			 return false;
	}
	
	

	/**
	 * 회원탈퇴
	 * --메서드명 : removeMember()
	 * --매개변수 : 아이디, 비밀번호
	 * --반환타입 : void
	 * => 회원 비밀번호 변경과 같은 로직
	 * 1. exist()로 아이디 존재 여부 판별 
	 * => 반환값 int idx에 저장 
	 * => 아이디 존재하면 배열 인덱스 반환,존재하지 않으면 -1 반환
	 * 
	 * 2. 아이디가 없으면 오류출력 (index == -1)
	 * 3. 아이디가 존재하면(index >=0 ) 저장된 아이디와 전달받은 아이디 비교 , 저장된 비밀번호와 전달받은 아이디 비교
	 * 4. 배열 참조 변수 members[index]에 null을 집어넣기 => 아무것도 참조를 안 한다. =>이게 삭제임
	 * => 문제발생 => 빈 공간이 많아져 메모리 낭비 
	 *    해결1 : 뒤에있는 요소를 앞으로 당겨온다(삭제한 위치부터 등록된 인원된만큼의 쉬프트 연산이 발생 => 수많은 io 발생)
	 *              => 단점 : 삭제된 위치부터 하나하나 올리는 게 비효율 
	 * 5. 해결2 : 맨마지막에 있는 참조변수 members[count-1] 안의 주소값을 삭제될 배열요소members[index]에 레퍼런스 
	 * 6. 해결2 : 마지막 요소를 null로 바꾼다. => 쉬프트연산은 한번만 발생. 
	 * 7. count를 1 감소 시킨다.
	 * 8. 비밀번호가 잘못되면 오류출력
	 */
	
	@Override
	public void removeMember(String memberId, String memberPw) {
		//1.
		int index = exist(memberId);
		
		//2.
		if(index == -1) {
			System.out.println("[오류] "+memberId+" : 존재하지 않는 아이디입니다.");
			return;
		} 
		//3.
		if(members[index].getMemberPw().equals(memberPw)) {
			//4.
			members[index] = null;
			members[index] = members[count-1]; //5. 해결2
			members[count-1] = null;//6.
			
			// 5,6번 NullPointerException 발생 => 지금해결
			// members[] 객체배열의 크기(members.length = 10)와 등록된 인원(count = 5)이 같다고 착각함
			// members[index]를 삭제하고 (null값 할당) 
			// members[]배열 중간에 null이 있으면 안되니 members[count-1] 값을 members[index]에 넣어줘야함.
			// 오류 : members[index] = members[length-1]; 즉 members[10] 값 : null을 할당해버림. 
			// 올바른 코드 : members[index] = members[count-1]; members[5] 값 : {"user05", "password05"...} 을 넣어줘야함.
			
			count--;//7.
			System.out.println("[탈퇴 완료] "+memberId+"님의 회원정보가 삭제되었습니다.");
			return;
		}
			
			System.out.println("[오류] "+memberPw+"는 잘못된 비밀번호입니다.");
	}
	
	/**
	 * 회원전체탈퇴
	 * --메서드명 : removeMember() 
	 * --매개변수 : no argument
	 * --반환타입 : void
	 * 1. 새로운 Member[] 배열 객체  remove 생성
	 * 2. 기존의 members 객체배열 참조변수에 새로 생성한 객체 배열 remove 참조변수값 할당 
	 * 3. members[] 배열 객체에 등록되었던 회원수만큼 반복문을 통해 members[i] 값 출력 => members[] 배열의 각 요소들이 null로 초기화됨을 확인 가능
	 */
	@Override
	public void removeMember() {
		//1.
		Member[] remove = new Member[members.length];
		members = remove; //2.
	    
		//3.
		for(int i = 0; i < count ; i++) {
		System.out.println("회원 객체 배열의 "+i+" 번째 저장된 값 :"+members[i]);
		}
		// 모든 요소가 출력됨을 알리는 출력문.
		System.out.println("모든 정보가 삭제되었습니다.");
		return;
	}

	
	/**
	 * 회원 초기화 등록
	 * --메서드명 : initMember() 
	 * --매개변수 : no argument
	 * --반환타입 : void
	 */
	@Override
	public void initMember() {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com","2020-12-15","G",50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com","2020-01-05","G",950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com","2020-11-15","S","강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com","2020-01-05","S","김하린");
		Member dto5 = new AdminMember("user05", "password05", "유관순", "01012345000", "administrator@work.com","2020-04-01","A","선임");
		System.out.println("회원들 dto1~dto5 까지 값 초기화");

	}
	
	
}
