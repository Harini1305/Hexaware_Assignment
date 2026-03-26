package com.exam.online_exam_system;

import java.util.Scanner;
import com.exam.online_exam_system.service.Service;

public class App {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Service ser = new Service();

        while (true) {

            System.out.println("\n1.Admin\n2.User\n3.Exit");
            System.out.println("Enter Choice: ");

            int choice = s.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("1.Add 2.Update 3.View");
                    int a = s.nextInt();

                    if (a == 1) ser.addQuestion();
                    else if (a == 2) ser.updateQuestion();

                    else if (a == 3) ser.viewQuestions(); 

                    break;

                case 2:
                    System.out.println("1.Register 2.Give Exam");
                    int u = s.nextInt();

                    if (u == 1) ser.register();

                    else if (u == 2) ser.giveExam();

                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}