package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest2 {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BoardRepository boardRepository;

	// 게시물을 작성한 회원 삭제
	@Test
	public void 첫번째회원삭제() {
	
		// 게시물을 작성한 회원은 바로 삭제할 수 없음
		// 회원을 삭제하려면 먼저 회원이 작성한 게시물을 작성해야함
		// 외래키 걸려있어서 마음대로 삭제 X
		memberRepository.deleteById("user1");
		
		// 외래키..가 설정 되어 있을때는 데이터 추가, 삭제시 순서가 있음
		// 데이터 추가순서: 부모 > 자식
		// 데이터 삭제순서: 자식 > 부모
		
	}
	
	// 게시물을 작성하지 않은 회원 삭제
	@Test
	public void 두번째회원삭제() {
		
		memberRepository.deleteById("user2");
		
	}

	@Test
	public void 회원삭제() {
		
		// 회원 엔티티로 데이터를 추가할 때: 모든 데이터 작성
		// 회원 엔티티를 이용할 때: PK만 작성
		Member member = Member.builder()
							  .id("user2")
							  .build();
		
		// 해당 회원이 작성한 모든 글을 삭제
		boardRepository.deleteWriter(member);
		
		// 그 후에 회원을 삭제
		memberRepository.deleteById("user2");
		
	}
	
}
