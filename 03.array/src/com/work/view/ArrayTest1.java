package com.work.view;

public class ArrayTest1 {

	/*
	 * 자바 어플리케이션 시작 메서드
	 * @param  
	 * */
	
	
	public static void main(String[] args) {
		//System.out.println("args.length = " + args.length);
		// 메인의 args는 볓개인지???
		
		//main1();
		// static 클래스에서 static클래스 호출 가능
	    
		//main2();
	    
		main3();
	
	}
	
	
	
	public static void main3() {
		
		/* 실습 : 
		 * 학생의 성적을 관리하는 프로그램
		 *  -- 5명 성적 : 92, 85, 77, 98, 65
		 *  -- 5명 이름 : 홍길동 강감찬 이순신 김유신 유관순
		 * 
		 * # 출력형식
		 * 1번 홍길동
		 * ...
		 * 
		 *  총점 : 000
		 *  평균 : 000
		 */
		
		
		String names[] = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		int scores[] = {92, 85, 77, 98, 65};
		int total = 0;
		int avg = 0;
		
		for(int  index = 0; index < names.length; index++)
		{
			System.out.println((index+1)+"번 "+names[index]+" "+scores[index]);
			total += scores[index];
		}
		
		avg = total / scores.length;
		
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
		System.out.println("평균 : "+total / 5.0); // int/ double = double
		
	}
	
	public static void main2() {
		// 5명의 학생의 이름을 관리하는 프로그램 개발
		// 5명 학생 이름 : 홍길동 강감찬 이순신 김유신 유관순
		
		String[] arrays = {};
		System.out.println(arrays.length);
		
		// 1차원 배열 : 선언 + 생성 + 명시적초기화 
		// 1.
		String names[] = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		System.out.println("names 배열의 크기 : "+names.length);
		//2. String names[] = new String[] {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		
		for(int index = 0; index < names.length ; index++) {
			System.out.println(names[index]);
		}
	}
	
	public static void main1() {
        // 5명의 학생의 성적관리하는 프로그램 개발
        // 5명 성적 : 92, 85, 77, 98, 65
	    // 배열을 자료 저장구조로 사용
		
		// 출력형식 요구사항 변경
		// 1번 : 92
		// ...
		// 총점 : 000
		// 평균 : 00 (소수 이하 버림)
		
		
		
		//1. 배열 선언
		int[] scores; //권장
		
		/* public int[] scores; 
		 * 오류가 남. => 전역변수는 기본값이 defult 
		 */
		
		//2. 배열 생성 => 현재 배열요소에 저장된 값? 0
		scores = new int[5];
		
		// 배열 선언과 생성 동시에 int [] score = new int[5];
		
		//3. 배열 요소 사용 : 값 할당 가져오기
		
		// 값을 할당하기 전 : 배열요소에 담긴 값을 전체 출력
		for (int index = 0; index < scores.length;index++)
		{// 배열명.length => 배열의 크기 
			
			System.out.println("scores["+index+"] : "+scores[index]);
		    // 배열요소마다 기본값 0으로 저장됨 => 전부 다 0이 출력되는 것을 볼 수 있음. 
		}
		
		// 값을 할당하는 방법 1
		scores[0] = 92;
		scores[1] = 85;
		scores[2] = 77;
		scores[3] = 98;
		scores[4] = 65;
		
		/* 값을 할당하는 방법 2 
		 * score = {92, 85, 77, 98, 65};
		 */
		
		
		System.out.println("\nscores 배열 요소에 점수 값을 할당");
		// 값을 할당한 후 : 배열요소에 담긴 값을 전체 출력
				for (int index = 0; index < scores.length;index++)
				{// 배열명.length => 배열의 크기 
					
					System.out.println("scores["+index+"] : "+scores[index]);
				    // 배열요소마다 할당된 점수값이 출력되는 것을 볼 수 있음. 
				}
				
				int sum = 0 ;
				int avg = 0;
				
				System.out.println("\n고객이 출력형식 요구사항 변경");
				for (int index = 0; index < scores.length;index++)
				{// 배열명.length => 배열의 크기 
					
					System.out.println((1 + index)+"번 : "+scores[index]);
				    // 배열요소마다 할당된 점수값이 출력되는 것을 볼 수 있음. 
					
					sum += scores[index];
					// 총점을 구하는 수식 
					// => scores 배열 요소의 값을 sum변수에 계속 저장
					
				}
				
				avg = sum/scores.length;
				// 평균 
				
				System.out.println("\n총점 : " + sum);
				System.out.println("평균 : " + avg);
				
	}

}
