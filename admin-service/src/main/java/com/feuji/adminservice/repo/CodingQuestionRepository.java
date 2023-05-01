package com.feuji.adminservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.commonmodel.CodingQuestion;

public interface CodingQuestionRepository extends JpaRepository<CodingQuestion, Long> {

	public  List<CodingQuestion> findBySubjectId(Long subjectId);
}
