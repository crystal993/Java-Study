package com.work.view;

import com.work.model.dto.StudentScore;
import com.work.model.service.StudentScoreService;

/**
 * <pre>
 * 학생 성적 관리 프로그램 시작 클래스
 * </pre>
 * 
 * @author Playdata
 * @version ver1.0	
 * @since jdk1.8
 * @see com.work.model.dto.StudentScore
 * @see com.work.model.service.StudentScoreService
 */
public class Test {
	
	/* this() 테스트 */
	public static void main(String[] args) {
		StudentScore dto3 = new StudentScore("3번","이순신",85);
		dto3.printinfo();
	}
	
	/* 생성자 테스트 */
	public static void main2(String[] args) {
		// 기본 생성자 이용한 객체 생성
		StudentScore dto1 = new StudentScore();
		dto1.studentNo = "1번";
		dto1.setName("홍길동");
		dto1.setScore(92);
		
		//필수초기화생성자 이용한 객체 생성
		StudentScore dto2 = new StudentScore("2번","강감찬");
		
		//전체초기화생성자 이용한 객체 생성
		StudentScore dto3 = new StudentScore("3번","이순신",85);
		
		dto1.printinfo();
		dto2.printinfo();
		dto3.printinfo();
	}
	
	/**
	 * 학생 성적 관리 프로그램 시작 메서드
	 * @param args 시작시 전달받은 문자열타입 배열정보
	 */
	public static void main1(String[] args) {
		StudentScoreService service = new StudentScoreService(100);
		
		//
		//service.students = null;
		
		System.out.println("\n### 등록");
		service.addStudentScore("1번", "홍길동", 92);  // null => 배열객체 접근 불가 => Null
		service.addStudentScore("2번", "강감찬", 85);
		service.addStudentScore("3번", "이순신", 77);
		service.addStudentScore("4번", "김유신", 98);
		service.addStudentScore("5번", "유관순", 68);
		
		//
		// service.students = null;
		//
		
		System.out.println("\n 성적 등록 학생 수 : "+ service.getCount());
		//service.count = 500;
		service.addStudentScore("1번","홍길동",92);
		
		
		System.out.println("\n### 전체 학생 성적 조회");
		service.printStudentScore();
		
	}

}
