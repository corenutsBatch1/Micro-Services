package com.feuji.adminservice.controller;

import com.feuji.adminservice.service.ExamService;
import com.feuji.commonmodel.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class ExamController {
	@Autowired
	private ExamService examService;
	
	@PostMapping("/addexam/{pid}")
	public HttpStatus addexam(@RequestBody Exam exam,@PathVariable Long pid)
	{
		examService.addExam(exam,pid);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updateexam/{id}")
	public void update(@RequestBody Exam exam ,@PathVariable Long id)
	{
		examService.updateExam(exam,id);
	}
	
	@GetMapping("/getallexams")
	public List<Exam> getAllExams(){
		return examService.getAll();
		
	}
	
	@GetMapping("/getquestions/{id}")
	public  Exam get(@PathVariable Long id)
	{
		return  examService.getbyId(id);
	}
}
