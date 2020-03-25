package com.puercha.algo.challenge.vo;

import java.util.Date;

import lombok.Data;

/**
 * @author Yongmin 
 * 도전문제 VO
 */
@Data
public class ChallengeVO {

	// 도전과제번호
	private long cNum;

	// 출제자
	private long userNum;

	// 도전과제 내용
	private String content;

	// 제한메모리사용량
	private long limitMemory;

	// 제한시간
	private long limitTime;

	// 제목
	private String title;

	// 통과한 사람수
	private long passNum;

	// 생성 일시
	private Date createdAt;

	// 수정일시
	private Date updatedAt;

}