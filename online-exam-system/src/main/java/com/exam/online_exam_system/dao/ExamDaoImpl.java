package com.exam.online_exam_system.dao;
import java.sql.*;
import java.util.*;
import com.exam.online_exam_system.dto.*;
public class ExamDaoImpl implements ExamDAO {
	    Connection con;
	    public ExamDaoImpl() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); 

	            con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/examdb", "root", "examly@123heX");
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    public void addQuestion(Admin q) {
	        try {
	            PreparedStatement ps = con.prepareStatement(
	                "insert into question values(?,?,?,?,?,?,?)"
	            );
	            ps.setInt(1, q.getQuestionId());
	            ps.setString(2, q.getQuestionText());
	            ps.setString(3, q.getOptionA());
	            ps.setString(4, q.getOptionB());
	            ps.setString(5, q.getOptionC());
	            ps.setString(6, q.getOptionD());
	            ps.setString(7, q.getCorrectAnswer());

	            ps.executeUpdate();
	            System.out.println("Question Added!");

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    public void updateQuestion(Admin q) {
	        try {
	            PreparedStatement ps = con.prepareStatement(
	                "update question set questionText=?, optionA=?, optionB=?, optionC=?, optionD=?, correctAnswer=? where questionId=?"
	            );
	            ps.setString(1, q.getQuestionText());
	            ps.setString(2, q.getOptionA());
	            ps.setString(3, q.getOptionB());
	            ps.setString(4, q.getOptionC());
	            ps.setString(5, q.getOptionD());
	            ps.setString(6, q.getCorrectAnswer());
	            ps.setInt(7, q.getQuestionId());
	            ps.executeUpdate();
	            System.out.println("Question Updated!");
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    public List<Admin> getAllQuestions() {
	        List<Admin> list = new ArrayList<>();

	        try {
	            PreparedStatement ps = con.prepareStatement("select * from question");
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Admin q = new Admin();
	                q.setQuestionId(rs.getInt(1));
	                q.setQuestionText(rs.getString(2));
	                q.setOptionA(rs.getString(3));
	                q.setOptionB(rs.getString(4));
	                q.setOptionC(rs.getString(5));
	                q.setOptionD(rs.getString(6));
	                q.setCorrectAnswer(rs.getString(7));
	                list.add(q);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return list;
	    }
	    public void registerMember(Student m) {
	        try {
	            PreparedStatement ps = con.prepareStatement(
	                "insert into member values(?,?,?)"
	            );
	            ps.setInt(1, m.getUserId());
	            ps.setString(2, m.getName());
	            ps.setString(3, m.getEmail());
	            ps.executeUpdate();
	            System.out.println("User Registered!");
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}

