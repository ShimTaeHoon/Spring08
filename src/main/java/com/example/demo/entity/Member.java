package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "tbl_member")
// BaseEntity를 상속받아 등록일, 수정일 필드 추가
public class Member extends BaseEntity {

	// Not null + Unique
	@Id
	@Column(length = 50)
	String id;
	
	@Column(length = 200, nullable = false)
	String password;
	
	@Column(length = 100, nullable = false)
	String name;
	
}
