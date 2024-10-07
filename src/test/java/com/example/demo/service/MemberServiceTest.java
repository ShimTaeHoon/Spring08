package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	MemberService service;
	
	@Test
	public void 회원목록조회() {
		
	Page<MemberDTO> page = service.getList(1);
	
	List<MemberDTO> list = page.getContent();
	
	for(MemberDTO dto : list) {
		System.out.println(dto);
			
		}
	}
	
	@Test
	public void 등록() {
		
		MemberDTO dto = MemberDTO.builder()
									.id("admin")
									.password("1234")
									.name("김인수")
									.build();
		
		boolean isSuccess = service.register(dto);
		
		System.out.println("처리결과: " + dto);
	}
	
	@Test
	public void 단건조회() {
		
		MemberDTO dto = service.read("user1");
		
		System.out.println(dto);
		
	}
	
}
