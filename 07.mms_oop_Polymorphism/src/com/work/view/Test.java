package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

public class Test {
	
	//instanceof, typecasting, virtual method invocation 테스트
	public static void main(String[] args) {
		// 회원 초기화 데이터 참고로해서 회원 5명 객체 생성
		// 참조변수 타입은 부모타입 : 다형성
		// 부모타입의 참조변수에 일반회원(모든데이터 초기화 생성자) 객체 생성
		
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com","2020-12-15","G",50000);
		System.out.println(dto1); //자식이 재정의해놓은 자식의 toString() 호출 수행
		
		//실제 메모리에 생성된 자식 객체 타입으로 형변환 => 실제 자식객체의 멤버 접근 가능
		GeneralMember g1 = (GeneralMember)dto1;
		System.out.println(g1); //자식이 재정의해놓은 자식의 toString() 호출 수행
		
		//형변환하기 전에 해당 클래스의 객체(instanceof) 여부 체킹
		if(dto1 instanceof AdminMember){
		// 컴파일 ok : 문법체크
		AdminMember a1 = (AdminMember)dto1;
				a1.getPosition(); //java.lang.ClassCastException
		}
		else {
			System.out.println("[오류] 해당 클래스의 인스턴스가 아닙니다.");
		}
		
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com","2020-01-05","G",950000);
		
		

		
		// 부모타입의 참조변수에 우수회원(모든 데이터 초기화 생성자) 객체 생성
		
		
		
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com","2020-11-15","S","강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com","2020-01-05","S","김하린");
		
		// 부모타입의 참조변수에 관리자회원(모든 데이터 초기화 생성자) 객체 생성
		Member dto5 = new AdminMember("user05", "password05", "유관순", "01012345000", "administrator@work.com","2020-04-01","A","선임");
		
		dto1.getMemberId();
		//dto1.getMileage();
		//error : 부모타입의 참조변수는 자식의 멤버 접근 불가
		
		
		}
	
	
	// 재정의 테스트 - super().메소드 // => 복습할 때 자식 클래스들의 toString 재정의한거랑 부모클래스 Member 보러가면 됨.
	public static void main2(String[] args) {
		Member dto1 = new Member("user01", "password01", "홍길동", "01012341234", "user01@work.com");
		System.out.println(dto1);// 어떤 클래스의 toString() 결과 => 부모 재정의
		// toString() 재정의하지 않는 경우 : com.work.model.dto.Member@15db9742 =>> 해쉬코드 값이 출력되므로 사람이 읽기좋게 재정의하면 됨.
		
		//일반회원 객체 생성
		Member dto2 = new GeneralMember("user01", "password01", "강감찬", "01012340000", "user02@work.com");
		System.out.println(dto2); // 어떤 클래스의 toString() 결과 => 자식 재정의
	}
	
	// 부모타입의 다형성 : 모든 자식객체를 참조(저장)
	public static void main1(String[] args) {
		
		// ok : 같은 타입 자동 할당 : 다형성 변수타입
		Member dto1 = new Member();
		
		// ok : 부모 타입 (상속) : 큰 타입
		Member dto1 = new GeneralMember();
		
		//  ok : 부모 타입 (상속) : 큰 타입 => 부모타입은 모든 자식 타입을 레퍼런스 할 수 있다
		Member dto3 = new SpecialMember();
		
		// error : 다른 타입, 작은(자식)타입, 즉 부모객체를 자식객체에 저장(참조)불가
		//GeneralMember dto4 = new Member(); 
		// => 부모에게는 자식의 속성변수가 없음 , 자식이 부모보다 더많은 속성 변수를 가짐
	
		// error : 완전히 다른 타입, 상속구조도 아님. 형제끼리도 레퍼런스 할 수 없다.
		// GeneralMember dto4 = new AdminMember();
	}
}
