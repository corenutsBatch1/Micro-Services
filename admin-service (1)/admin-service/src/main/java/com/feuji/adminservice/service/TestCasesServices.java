package com.feuji.adminservice.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.adminservice.repo.CodingQuestionRepository;
import com.feuji.adminservice.repo.TestCasesRepository;
import com.feuji.commonmodel.CodingQuestion;
import com.feuji.commonmodel.TestCases;

@Service
public class TestCasesServices {
	
	@Autowired
	private TestCasesRepository testCasesRepository;
	
	@Autowired
	private CodingQuestionRepository codingQuestionRepository;
	

	public void addTestCases(TestCases testCases, Long qid) {
		
		CodingQuestion codingQuestion = codingQuestionRepository.findById(qid).get();
		testCases.setCodingQuestion(codingQuestion);
		testCasesRepository.save(testCases);
	}
	
	public List<TestCases> getAllTestCases(Long id) {
		List<TestCases> list = testCasesRepository.findByCodingQuestionId(id);
		return list;
	}

}
