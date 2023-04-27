
package com.feuji.commonmodel;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "scheduled_exam_table")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paper_id")
    private CreatePaper createPaper;


    @OneToOne(mappedBy = "exam", cascade = CascadeType.ALL)
    private Marks marks;
    
    private int examDuration;
    public Exam() {
    }

    public Exam(String name, String code, LocalDateTime startTime, LocalDateTime endTime, CreatePaper createPaper, Marks marks,int examDuration) {
        this.name = name;
        this.code = code;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createPaper = createPaper;
        this.marks = marks;
        this.examDuration=examDuration;
    }
    

    public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public CreatePaper getCreatePaper() {
        return createPaper;
    }

    public void setCreatePaper(CreatePaper createPaper) {
        this.createPaper = createPaper;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }
}

