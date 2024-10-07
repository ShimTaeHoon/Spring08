package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository repository;
	
	@Test
	public void 회원일괄등록() {
		List<Member> list = new ArrayList<>();
		
		for(int i = 1; i <= 30; i++) {
			list.add(new Member("user" + i, "1234", "둘리"));
		}
		
		repository.saveAll(list);
	}
	
	@Test
	public void 회원등록() {
		
		Member member1 = new Member("user1", "1234", "둘리");
		repository.save(member1);
		
		Member member2 = new Member("user2", "1234", "또치");
		repository.save(member2);			
		
	}
	
	@Test
	public void 회원목록조회() {
		
		List<Member> list = repository.findAll();
		for(Member member : list) {
			System.out.println(member);
		}
		
	}
	
	@Test
	public void 회원목록단건조회() {
		
		Optional<Member> list = repository.findById("user1");
		if(list.isPresent()) {
			Member member = list.get();
			System.out.println(member);
		}
		
	}
	
	@Test
	public void 회원수정() {
		Optional<Member> list = repository.findById("user1");
		
		if(list.isPresent()) {
			Member member = list.get();
			// 일부내용변경
			member.setName("usermodify");
			// 데이터 업데이트
			repository.save(member);
		}
		
	}
	
	@Test
	public void 회원삭제() {
		repository.deleteById("user1");
	}
	
}
