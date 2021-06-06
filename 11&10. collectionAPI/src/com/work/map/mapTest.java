package com.work.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
 
public class mapTest {

	public static void main(String[] args) {
		
	
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com","2020-12-15","G",50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com","2020-01-05","G",950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com","2020-11-15","S","강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com","2020-01-05","S","김하린");
		Member dto5 = new AdminMember("Administrator", "password05", "유관순", "01012345000", "administrator@work.com","2020-04-01","A","선임");
		
		// 회원들을 저장 관리하기 위한 HashMap<K,V>
				// 회원식별속성 : String 아이디 => map key
				// HashMap 객체 선언
				HashMap<String, Member> map = new HashMap<String, Member>();
				
				print("등록");
				map.put(dto1.getMemberId(),dto1);
				map.put(dto2.getMemberId(),dto2);
				map.put(dto3.getMemberId(),dto3);
				map.put(dto4.getMemberId(),dto4);
				map.put(dto5.getMemberId(),dto5);
				
				print("등록 회원 수 조회" + map.size());
				
				print("조회 : user01");
				Member dto = map.get("user01");
				System.out.println(dto);
				
				
				print("변경 : user01");
				dto = new GeneralMember("user01", "password01", "crystal", "01012341000", "user01@work.com","2020-12-15","G",50000);
				map.put(dto.getMemberId(),dto);
				
				print("변경 후 조회 : user01");
				System.out.println(map.get("user01"));
	
				print("삭제 : user02");
				System.out.println("삭제 회원 정보 : " + map.remove("user02"));

				print("전체 조회");
				/*
				 * 참고 api
				 * -- map에 저장된 모든 객체들의 key : 중복 불가 set
				 * -- map 메서드 중에서 반환 타입이 Set 메서드 조회
				 * -- Set<K>	keySet() : key 목록을 set에 반횐, set 순서없음, 중복불가
				 * -- key 목록 Set에 있는 key들을 Iterator에 담아오기
				 * -- Iterator를 반복하면서 key를 하나씩 가져오기
				 * -- 가져온 key를 map에 있는 객체를 조회하기 위해서 map.get(key) 해당 key 객체 가져오기
				 */

				// 방법1
//				Set<String> keySet = map.keySet();
//				Iterator<String> iterator = keySet.iterator();
				
				//방법2
				Iterator<String> iterator = map.keySet().iterator();
				while(iterator.hasNext()) {
					String key = iterator.next(); 
					Member value = map.get(key);
					
					System.out.println("[key] : "+key+" [value] : "+value);
				}
				
				
				
	}

	private static void print(String string) {
		System.out.println("\n####"+ string);
	}

}
