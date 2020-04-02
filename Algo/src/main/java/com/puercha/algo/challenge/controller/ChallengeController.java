package com.puercha.algo.challenge.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puercha.algo.challenge.service.ChallengeService;
import com.puercha.algo.user.service.LoginService;
import com.puercha.algo.user.vo.UserVO;

@Controller
@RequestMapping(path = "/challenge")
public class ChallengeController {
	final static Logger logger = LoggerFactory.getLogger(ChallengeController.class);
	
//	@Inject
	ChallengeService challengeService;
	
	@Inject
	LoginService loginService;
	
//	/challenge/list
	@GetMapping(value="/list")
	String getChallnegeList(		
		@RequestParam(name = "page", required = false, defaultValue = "0") 
		long page,
		@RequestParam(name = "type", required = false) 
		String type,
		@RequestParam(name = "keyword", required = false)
		String keyword
			) {
		String logMsg = String.format("page: %d, type: %s, keyword: %s", page,type,keyword);
		logger.info(logMsg);
		
		return "challenge/challengeList";
	}
	
	
	
//	/challenge/{cNum}
	@GetMapping(value="/{cNum}")
	String getChallengeSolvingForm(
		@PathVariable(name = "cNum") long cNum
			) {
		
		String logMsg = String.format("cNum: %d",cNum);
		logger.info(logMsg);
		
		
		
		return "challenge/challengeSolving";
	}
	
//	/challenge/code/{cNum}
	@PostMapping(path="/code/{cNum}", produces = "application/json")
	@ResponseBody
	ResponseEntity<Map<String,Object>> testCode(
		@PathVariable(name = "cNum") long cNum,
		@RequestParam(value = "code", required = true) String code,
		HttpSession session
			) {
		ResponseEntity<Map<String,Object>> res = null;
		Map<String,Object> datas = new HashMap<String,Object>();
		String logMsg = String.format("cNum: %d code:%s",cNum, code);
		UserVO user = loginService.getLoggedInUser(session);
		// 테스트 실행
		challengeService.doTest(cNum, user.getUserNum(), code);
		logger.info(logMsg);
		res = new ResponseEntity<Map<String,Object>>(datas,HttpStatus.OK);
		return res;
	}
	
//	/challenge/result/realtime/{resultNum}
	@GetMapping(path="/result/realtime/{resultNum}", produces="text/event-stream;charset=UTF-8")
	ResponseEntity<String> getResult(
		@PathVariable(name="resultNum") long resultNum
			){
		ResponseEntity<String> res = null;
		res = new ResponseEntity<String> ("312412",HttpStatus.OK);
		return res;
	}
	
	

}
