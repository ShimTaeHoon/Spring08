package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;

	@Test
	void 게시물등록_잘못된방법() {

		Member member = Member.builder().id("둘리").build();

		Board board = Board.builder()
									.title("안녕하세요")
									.content("안녕하세요")
									.writer(member)
									.build();

		repository.save(board); //에러남
	}
	
	@Test
	public void 게시물등록() {
		// 작성자 필드에 사용할 회원 엔티티 생성
		// Member를 등록할 목적이 아니기 때문에 PK만 입력하면됨
		// member에 name, password 필요없음
		Member member = Member.builder()
							  .id("user2")
							  .build();
		
		Board board = Board.builder() 
						   .title("안녕하세요")
						   .content("안녕하세요")
						   .writer(member)
						   .build();
		
		Board board2 = Board.builder()
							.title("반갑습니다")
							.content("반갑습니다")
							.writer(member)
							.build();
		
		repository.save(board);
		repository.save(board2);
						
	}
	
	@Test
	public void 게시물조회() {
		
		Optional<Board> optional = repository.findById(1);
		
		Board board = optional.get();
		
		System.out.println(board);
		
		// SQL 쿼리에서 board 테이블과 member 테이블이 join 처리됨
		
	}
	
}
