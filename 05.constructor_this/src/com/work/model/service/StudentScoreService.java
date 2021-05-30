package com.work.model.service;

import com.work.model.dto.StudentScore;

/**
 * <pre>
 * 학생 성적 관련서비스 제공 클래스
 * 1. 등록 기능 : + addStudentScore(학번, 이름, 성적) : void 
 * 2. 조회 기능 : 
 * 	 >> 전체학생조회 기능 : printStudentScore() : void 
 * 3. 총점 계산 기능 
 * 4. 평균 계산 기능
 * </pre>
 * 
 * @author Playdata
 * @version ver1.0	
 * @since jdk1.8
 * @see com.work.model.dto.StudentScore
 * @see com.work.model.dto.StudentScore#printInfo()
 */
public class StudentScoreService {
	/** 학생들의 성적정보 객체를 그룹으로 관리하기 위한 자료 저장구조 : 필요시에 확장하도록 처리*/
	//public StudentScore[] students = new StudentScore[3];
	
	/** 
	 * 학생들의 성적정보 객체를 그룹으로 관리하기 위한 자료 저장구조 멤버변수 선언 : 배열객체 생성은 생성자 위임처리 
	 * -- 접근권한: public => private 변경 ()
	 * */
	private StudentScore[] students;
	
	/** 등록된 학생의 숫자 정보 및 등록해야하는 배열요소의 인덱스번호 정보 
	 * 
	 * */
	private int count;
	
	/**
	 * 기본 생성자 : 배열의 크기를 기본 10개 초기화
	 */
	public StudentScoreService() {
		// students = new StudentScore[10];
		this(10);
	}
	
	/**
	 * 배열의 크기를 전달받아서 배열생성 할당 초기화 생성자
	 * @param length 배열의 크기
	 */
	public StudentScoreService(int length) {
		students = new StudentScore[length];
	}
	
	/**
	 * 실습 : 현재 등록한 학생성적의 숫자 조회 메서드
	 */
	public int getCount() {
		return count;
	}
	
	// 메서드 선언 실습
	//1. 등록 기능 : + addStudentScore(학번, 이름, 성적) : void 
	/**
	 * <pre>
	 * 학생 성적 등록 메서드
	 * -- 등록결과 메세지 출력
	 * -- 성공
	 * -- 실패
	 * 
	 * #처리 수행 절차
	 * 1. studentScore 객체 생성
	 * 2. 아규먼트 전달받은 정보로 생성 객체 정보 설정
	 * 3. 생성된 객체를 배열의 count 요소위치에 등록
	 * 4. count 등록인원을 1 증가
	 * 
	 * </pre>
	 * @param studentNo 학번
	 * @param name 이름
	 * @param score 성적
	 */
	public void addStudentScore(String studentNo, String name, int score) {
		
		StudentScore dto = new StudentScore(); 
		dto.studentNo = studentNo;
		dto.name = name;
		dto.score = score;
		
		addStudentScore(dto);
	
	}
	
	/** 등록 메서드 중복 정의 */
	public void addStudentScore(StudentScore dto) {
		
	
		if (students.length == count) {
			extendStudents(10);
			System.out.println("학생들의 자료저장구조를 추가 확장하였습니다.");
		}	
		
		students[count++] = dto;
	}
	
	public void extendStudents(int length) {
		
		StudentScore[] studentsTemp = new StudentScore[students.length + length];
		// 
		
		for (int index = 0; index < students.length; index++) {
			studentsTemp[index] = students[index]; 
		}
		
		students = studentsTemp;
		//studnts변수가 힙 영역에 좀 더 작은 방을 가리키고 있는데 
		//studentsTemp를 가리키도록 값을 바꿔준다. 		
	}
	
	/**
	 * 전체 학생 조회 메서드
	 */
	public void printStudentScore() {

		for (int index = 0; index < count; index++) {
			students[index].printinfo();
		}
	}
}
