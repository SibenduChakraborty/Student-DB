package com.project2;


import java.util.*;


interface studentdata{
    public void enroll();
    public LinkedList<String> showInfo();
}
interface transaction{
    public void viewBalance();
    public void payTuition();
}


public class Student implements studentdata,transaction,Comparable<Student>{
    private final String firstName;
    public final char firstChar;
    private final String lastName;
    private int gradeYear;
    private String studentID;
    private int compareId;
    ArrayList<String> courses = new ArrayList<>();
    private int tuitionBalance = 0;
    private static int id=1000;

    public Student(){
        Scanner sc= new Scanner(System.in);
        System.out.println("\nEnter student first name : ");
        this.firstName=sc.nextLine();
        firstChar=firstName.charAt(0);

        System.out.println("Enter student Last name : ");
        this.lastName=sc.nextLine();

        System.out.println("1 - First year\n2 - Second year\n3- Third Year\n4- Fourth year");
        this.gradeYear= sc.nextInt();
        setStudentID();//calling the method to call unique id
    }
    private void setStudentID(){
        id++;
        this.studentID= gradeYear + "" + id;
        this.compareId=(gradeYear*1000)+id;
    }
    public void enroll(){
        do {
            System.out.println("enter course to enroll (Quit to terminate): ");
            Scanner sc = new Scanner(System.in);
            String course = sc.nextLine();
            if (!Objects.equals(course, "Quit")) {
                courses.add(course);
                System.out.print("Enter Cost of Course:     ");
                int costOfCourse = sc.nextInt();
                tuitionBalance += costOfCourse;
            }
            else{break;}
        }while (true);
    }
    //transaction-->
    public void viewBalance(){
        System.out.println("Remaining amount : Rs. "+ tuitionBalance);
    }//called inside payTuition
    public void payTuition(){
        viewBalance();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter payment amount: Rs.");
        int payment= sc.nextInt();
        tuitionBalance= tuitionBalance-payment;
        System.out.println("Transaction Successful of amount : Rs."+payment);
        viewBalance();
    }

    //status info:
    public LinkedList<String> showInfo(){
        LinkedList<String> details= new LinkedList<>();
        details.add(firstName+" "+lastName);
        details.add(courses.toString());
        details.add(String.valueOf(gradeYear));
        details.add(String.valueOf(studentID));
        details.add(String.valueOf(tuitionBalance));

//        return firstName +" "+lastName+"    |    "+ courses+
//                "    |   "+gradeYear+"   |    "+studentID+
//                "    |   "+tuitionBalance;
        return details;
    }
    public int compareTo(Student st){
        //here the comparison is made with st and this
        //this>st = +
        //this<st = -
        //this==st=0
        if(this.compareId>st.compareId){
            return 1;
        }
        else{
            return -1;
        }
    }
}
