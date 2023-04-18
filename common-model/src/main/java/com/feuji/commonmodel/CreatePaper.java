package com.feuji.commonmodel;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "create_paper")
public class CreatePaper
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int totalMarks;
    
    private int numberOfQuestions;
    
    @Transient
    private Long[] questionsListArray; 

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "exams_questions",
            joinColumns = @JoinColumn(name = "paper_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Question> questions;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "createPaper")
    private Exam exam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public Long[] getQuestionsListArray() {
		return questionsListArray;
	}

	public void setQuestionsListArray(Long[] questionsListArray) {
		this.questionsListArray = questionsListArray;
	}

    

}