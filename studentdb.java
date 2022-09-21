package com.project2;

import java.util.*;

public class studentdb {
    public static void main(String[] args) {
        //create students
        System.out.println("Enter the number of students you want to enroll: ");
        Scanner sc= new Scanner(System.in);
        int numOfStudents= sc.nextInt();
        List<Student> students= new ArrayList<>();
        //Student[] students= new Student[numOfStudents];//array of students
        for (int i=0;i<numOfStudents;i++){
            Student tempstudent= new Student();
            tempstudent.enroll();
            tempstudent.payTuition();
            students.add(tempstudent);
        }

        //Sort the database:

        Comparator<Student> com= new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Character.compare(o1.firstChar, o2.firstChar);
            }
        };
        System.out.println("Select on which basis do you want to sort the database: ");
        System.out.println("Press 1 for student ID, Press 2 for First Name");
        int option=sc.nextInt();
        if(option==1){
            Collections.sort(students);
            System.out.print("Sorting database based on ID :");
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    System.out.print("* ");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println();
        }
        else{
            System.out.print("Sorting database based on NAME ");
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    System.out.print("* ");    // Fake animation
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println();
            students.sort(com);
        }
        System.out.println("TOTAL STUDENT STRENGTH : " + students.size());
        System.out.println("\n"+"DATABASE:");
        System.out.println("Name                |   Course(s)                |  Batch      |    Student ID      |   Balance Due");
        for(Student i:students){
            System.out.println("---------------------------------------------------------------------------------------"+"\n"+i.showInfo());
        }
    }
}

