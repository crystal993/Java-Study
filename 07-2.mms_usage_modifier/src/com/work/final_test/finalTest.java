package com.work.final_test;

public class finalTest {

}

//class A extends String { // The type A cannot subclass the final class String
	
//}

class B {
	public void doA() {
		System.out.println("A");
	}
	public final void doB() {
		System.out.println("B");
	}
}

class C extends B{
	int count = 100;
	
	// 상수 선언
	public static final int MAX_COUNT = 30;
	
	@Override
	public void doA() {
		count = 200;
		//MAX_COUNT = 500; //The final field C.MAX_COUNT cannot be assigned => 변경할 수 없어.
		System.out.println("자식에서 재정의 변경합니다.");
	}
	
	//중복정의
	//Duplicate method doA() in type C
	public void doA(int no1, final int no2) {
		no1 = 100;
		//no2 = 100; => 값 변경 불가.(전달받은 값을 변경하기 어려울때)
	}
	
//	//Multiple markers at this line
//	- Cannot override the final method 
//	 from B => 부모가 이거 상속불가한 메서드로 만들었어서 재정의가 불가능해
//	@Override
//	public void doB() {
//		System.out.println("자식에서 재정의 변경합니다.");
//	}
}