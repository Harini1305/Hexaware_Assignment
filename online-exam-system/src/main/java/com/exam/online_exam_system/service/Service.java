package com.exam.online_exam_system.service;

import java.util.*;
import com.exam.online_exam_system.dao.*;
import com.exam.online_exam_system.dto.*;
public class Service {

	    Scanner s = new Scanner(System.in);
	    ExamDAO dao = new ExamDaoImpl();
	    public void addQuestion() {
	        Admin q = new Admin();

	        System.out.print("Enter ID: ");
	        q.setQuestionId(s.nextInt());
	        s.nextLine();

	        System.out.print("Enter Question: ");
	        q.setQuestionText(s.nextLine());

	        System.out.print("A: "); q.setOptionA(s.nextLine());
	        System.out.print("B: "); q.setOptionB(s.nextLine());
	        System.out.print("C: "); q.setOptionC(s.nextLine());
	        System.out.print("D: "); q.setOptionD(s.nextLine());

	        System.out.print("Correct Answer (A/B/C/D): ");
	        q.setCorrectAnswer(s.nextLine());

	        dao.addQuestion(q);
	    }

	    public void register() {
	        Student m = new Student();

	        System.out.print("Enter ID: ");
	        m.setUserId(s.nextInt());
	        s.nextLine();
	        System.out.print("Enter Name: ");
	        m.setName(s.nextLine());
	        System.out.print("Enter Email: ");
	        m.setEmail(s.nextLine());
	        dao.registerMember(m);
	    }
	    public void giveExam() {
	        List<Admin> list = dao.getAllQuestions();
	        int score = 0;
	        s.nextLine(); 
	        for (Admin q : list) {
	            System.out.println("\n" + q.getQuestionText());
	            System.out.println("A. " + q.getOptionA());
	            System.out.println("B. " + q.getOptionB());
	            System.out.println("C. " + q.getOptionC());
	            System.out.println("D. " + q.getOptionD());
	            System.out.print("Your Answer: ");
	            String ans = s.nextLine();
	            if (ans.equalsIgnoreCase(q.getCorrectAnswer())) {
	                score++;
	            }
	        }
	        System.out.println("Your Score: " + score + "/" + list.size());
	    }
	    public void updateQuestion() {
	        Admin q = new Admin();
	        System.out.print("Enter Question ID to update: ");
	        q.setQuestionId(s.nextInt());
	        s.nextLine();
	        System.out.print("Enter new Question: ");
	        q.setQuestionText(s.nextLine());
	        System.out.print("A: "); q.setOptionA(s.nextLine());
	        System.out.print("B: "); q.setOptionB(s.nextLine());
	        System.out.print("C: "); q.setOptionC(s.nextLine());
	        System.out.print("D: "); q.setOptionD(s.nextLine());
	        System.out.print("Correct Answer: ");
	        q.setCorrectAnswer(s.nextLine());
	        dao.updateQuestion(q);
	    }
	    public void viewQuestions() {
	        List<Admin> list = dao.getAllQuestions();
	        if (list.isEmpty()) {
	            System.out.println("No questions found!");
	            return;
	        }
	        for (Admin q : list) {
	            System.out.println("\nID: " + q.getQuestionId());
	            System.out.println(q.getQuestionText());
	            System.out.println("A. " + q.getOptionA());
	            System.out.println("B. " + q.getOptionB());
	            System.out.println("C. " + q.getOptionC());
	            System.out.println("D. " + q.getOptionD());
	            System.out.println("Correct Answer: " + q.getCorrectAnswer());

	        }
	    }
	}