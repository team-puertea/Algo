package com.puercha.algo.learning.vo;

import java.sql.Timestamp;

/**
 * @author Yongmin
 * 단원 VO
 * 
 */
public class UnitVO {
	
	//단원
	private long unitNum;
	
	//과목번호
	private long subjectNum;
	
	//내용
	private String content;
	
	//제목
	private String title;
	
	//과목 내 챕터 번호
	private String chapter_depth;
	
	//생성 일시
	private Timestamp created_at;
	
	//수정 일시
	private Timestamp updated_at;

}