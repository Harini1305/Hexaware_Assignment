package com.exam.online_exam_system.dao;
import com.exam.online_exam_system.dto.*;
import java.util.List;
public interface ExamDAO {

	    void addQuestion(Admin q);
	    void updateQuestion(Admin q);
	    List<Admin> getAllQuestions();

	    void registerMember(Student m);
	}
