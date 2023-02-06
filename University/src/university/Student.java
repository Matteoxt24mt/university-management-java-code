/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.util.ArrayList;

/**
 *
 * @author Matteo Trupia
 */
public class Student 
{
    public static int studentProgressiveSerialNumber = 1000;    // Progressive serial number
     private int studentSerialNumber;    // Student Serial Number
    private Data studentBirthDate;    // Student Birth Date
    private String studentBirthCity;    // Student Birth City
    private String studentBirthRegion;    // Student Birth Region
    
    private ArrayList<Exam> studentExamsList = new ArrayList<>();    // List of the student exam
    
    public Student(int birthDay, int birthMonth, int birthYear, String birthCity, String birthRegion)   // Constructor
    {
        studentSerialNumber = studentProgressiveSerialNumber++;
        studentBirthDate = new Data(birthDay, birthMonth, birthYear);
        studentBirthCity = birthCity;
        studentBirthRegion = birthRegion;
        
        University.universityStudentsList.add(this);
    }
    
    // GET :

        public int getStudentSerialNumber() {
            return studentSerialNumber;
        }

        public Data getStudentBirthDate() {
            return studentBirthDate;
        }

        public String getStudentBirthCity() {
            return studentBirthCity;
        }

        public String getStudentBirthRegion() {
            return studentBirthRegion;
        }
    
    // SET :

        public void setStudentSerialNumber(int studentSerialNumber) {
            this.studentSerialNumber = studentSerialNumber;
        }

        public void setStudentBirthDate(Data studentBirthDate) {
            this.studentBirthDate = studentBirthDate;
        }

        public void setStudentBirthCity(String studentBirthCity) {
            this.studentBirthCity = studentBirthCity;
        }

        public void setStudentBirthRegion(String studentBirthRegion) {
            this.studentBirthRegion = studentBirthRegion;
        }
    
    public void addExam(Exam myExam)    // Add exam => studentExamsList
    {
        studentExamsList.add(myExam);
    }
        
    public void printInfo() // Print the student info
    {        
        System.out.println("\nSerial number : " + studentSerialNumber +
                           "\nBirth : "+  studentBirthDate + ", " + studentBirthCity + ", " + studentBirthRegion + "\n");  // Print all the Course info 
    }
}
