package com.work.view;

public class ArrayTest2 {

	/* 2차원 배열 테스트 */
	public static void main(String[] args) {
		
		//doA(); // doA 메서드 호출
		doB(); // doB 메서드 호출
	}
	
	/* 행과 열크기 다르게 지정 */
	public static void doB() {
		//1반 80, 90
		//2반 70, 60, 50, 88
		//3반 95, 87, 67
		
		int[][] scores = new int[3][];
		
		scores[0] = new int[2];
		scores[1] = new int[4];
		scores[2] = new int[3];
		
		//1반
		scores[0][0] = 80;
		scores[0][1] = 90;
		
		//2반
		scores[1][0] = 70;
		scores[1][1] = 60;
		scores[1][2] = 50;
		scores[1][3] = 88;
		
		//3반
		scores[2][0] = 95;
		scores[2][1] = 87;
	    scores[2][2] = 67;
	    
	    int[] total = new int[3];
		int[] avg = new int[3];
		
		// 3. 2차원 배열요소 출력
		for (int row = 0; row < scores.length; row++) {
			// 해당 행의 크기만큼 출력
			
			System.out.print((row + 1) + "반 ");
			
			for (int col = 0; col < scores[row].length; col++) {
			 // 해당 행의 열크기만큼 출력	
				System.out.print(scores[row][col]+" ");
			    total[row] += scores[row][col];
			}
			avg[row] += total[row] / scores[row].length;
			System.out.println("");
			System.out.println("[총점:" + total[row] + ", 평균:" + avg[row] + "]");
			System.out.println("");
			
		}
	    
	}
	
	/* 행과 열크기 동일하게 지정 */
	public static void doA() {
		// 1반 80, 90, 70, 80
		// 2반 70, 60, 50, 88
		// 3반 95, 87, 67, 92
		//=> 3행 4열 3x4
		
		//출력양식
		// 1반 : 80  90  70  80 [총점:000, 평균:000]
		// 2반 : 70  60  50  88 [총점:000, 평균:000]
		// 3반 : 95  87  67  92 [총점:000, 평균:000]
		
		//1. 선언 + 2. 생성
		int[][] scores = new int[3][4];
		
		
		// 2. 2차원 배열요소 값 할당
		
		//1반
		scores[0][0] = 80;
		scores[0][1] = 90;
		scores[0][2] = 70;
		scores[0][3] = 80;
		
		//2반
		scores[1][0] = 70;
		scores[1][1] = 60;
		scores[1][2] = 50;
		scores[1][3] = 88;
		
		//3반
		scores[2][0] = 95;
		scores[2][1] = 87;
		scores[2][2] = 67;
		scores[2][3] = 92;
		
		int[] total = new int[3];
		int[] avg = new int[3];
		
		// 3. 2차원 배열요소 출력
		for (int row = 0; row < scores.length; row++) {
			// 해당 행의 크기만큼 출력
			
			System.out.print((row + 1) + "반 ");
			
			for (int col = 0; col < scores[row].length; col++) {
			 // 해당 행의 열크기만큼 출력	
				System.out.print(scores[row][col]+" ");
			    total[row] += scores[row][col];
			}
			avg[row] += total[row] / scores[row].length;
			
			System.out.print("[총점:" + total[row] + ", 평균:" + avg[row] + "]");
			System.out.println("");
			
		}
		
		
	}
}
