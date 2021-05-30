package com.work.static_test;

public class StaticTest {
	
	// class 멤버변수(static)
	public static String classTitle = "빅데이터과정";
	
		// instance 멤버변수	
	public String instanceTitle = "자바프로그래밍";
	
	public static void main(String[] args) {
		System.out.println(classTitle); // STATIC 멤버는 그냥 사용 가능
	//	System.out.println(instanceTitle);
		//Cannot make a static reference to the non-static field instanceTitle
	StaticTest test= new StaticTest();
	System.out.println(test.instanceTitle);// 같은 ㅡㄹ래
	
	System.out.println(Math.random());
	System.out.println(Math.random()*10); //1~10까지
	System.out.println((int)(Math.random()*10));
	System.out.println(Math.PI);
	}
	
	public void instanceMethod() {
		System.out.println(instanceTitle); // ★ ok : 같은 클래스에 있는 인스턴스 멤버끼리는 그냥 호출 사용 (메모리 로딩시점이 동일, 함께 이루어짐.) 
		
	}
	
	//static 멤버변수, instance 멤버변수 테스트
	public static void main1(String[] args) {
		System.out.println(SimpleMember.classCount);
		
		System.out.println();
		SimpleMember.classCount = 100;
		System.out.println(SimpleMember.classCount);
		System.out.println(SimpleMember.classCount + ": 클래스가 생성되기 전에도 static변수는 생성이 가능하다." );
		
		System.out.println();
		SimpleMember dto1 = new SimpleMember();
		
		System.out.println();
		SimpleMember dto2 = new SimpleMember();
		
		dto1.classCount = 1000;
		dto1.instanceCount = 100;
		
		dto2.classCount = 2000;
		dto2.instanceCount = 200;
		
		SimpleMember.classCount = 5000;
		
		System.out.println();
		System.out.println(dto1.classCount);
		System.out.println(dto1.instanceCount);
		
		System.out.println();
		System.out.println(dto2.classCount);
		System.out.println(dto2.instanceCount);
		
		System.out.println();
		System.out.println(SimpleMember.classCount);
		
	}

}
