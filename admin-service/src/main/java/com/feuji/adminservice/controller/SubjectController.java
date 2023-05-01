package com.feuji.adminservice.controller;

import java.util.List;

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

import com.feuji.adminservice.service.SubjectService;
import com.feuji.commonmodel.Subject;


@RestController
@CrossOrigin("*")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/addsubject")
	public HttpStatus addSubject(@RequestBody Subject subject)
	{
		subjectService.addSubject(subject);
		System.out.println(subject.getName()+"  "+subject.getDescription());
		return HttpStatus.OK;
	}

	@PutMapping("/updatesubject/{id}")
	public HttpStatus updateSubject( @PathVariable Long id, @RequestBody Subject subject)
	{
		subjectService.updateSubject(subject, id);
		System.out.println(subject.getName()+"  "+subject.getDescription());
		return HttpStatus.OK;
	}
	
	@GetMapping("/getAllSubjects")
	public List<Subject> getAll()
	{
		List<Subject> list=subjectService.getAll();
		
		list.stream().forEach((s)->System.out.println(s.getId()+"============"));
		return list;
	}
	@GetMapping("/getSubjectById/{id}")
	public Subject getSubjectById(@PathVariable Long id) {
		return subjectService.getSubjectById(id);
	}
	@DeleteMapping("/deleteSubject/{id}")
	public HttpStatus deleteSubject(@PathVariable Long id) {
		 subjectService.deleteSubject(id);;
		return HttpStatus.OK;
	}

	

}
