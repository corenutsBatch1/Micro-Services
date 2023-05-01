package com.feuji.adminservice.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.adminservice.service.QuestionService;
import com.feuji.commonmodel.Question;


@RestController
@CrossOrigin("*")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/addquestion/{sid}")
	public HttpStatus insertQuestion(@RequestBody Question question, @PathVariable Long sid) {
		questionService.addquestion(question,sid);
		return HttpStatus.OK;
	}
	
	@GetMapping("/getallquestions/{sid}")
	public Set<Question> getAllQuestions(@PathVariable Long sid)
	{
		
		return questionService.getAllQuestions(sid);
	}
	
	@PutMapping("/updatequestion")
	public Question updateQuestion(@RequestBody Question question){
		
		return questionService.updatequestions(question);
	}
	@GetMapping("/getquestionbyid/{id}")
	public Question getQuestionById(@PathVariable Long id) {
		return questionService.getQuestionById(id);
		
	}
	@DeleteMapping("/deleteQuestion/{id}")
	public HttpStatus deleteQuestion(@PathVariable Long id) {
		questionService.deleteQuestionById(id);
		return HttpStatus.OK;
	}
	
	

}
