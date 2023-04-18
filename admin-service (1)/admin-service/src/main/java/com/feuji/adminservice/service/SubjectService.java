package com.feuji.adminservice.service;

import com.feuji.adminservice.repo.SubjectRepository;
import com.feuji.commonmodel.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	public void addSubject(Subject subject)
	{
		System.out.println(subject.getName()+"  "+subject.getDescription());

		subjectRepository.save(subject);
	}
	
	public List<Subject> getAll() {
		return subjectRepository.findAll();
	}
	
	public void updateSubject(Subject subject,Long id) {
		Subject subject1=subjectRepository.findById(id).get();
		subject1.setName(subject.getName());
    	subject1.setDescription(subject.getDescription());
		subjectRepository.saveAndFlush(subject1);
	}
	
	
	

}
