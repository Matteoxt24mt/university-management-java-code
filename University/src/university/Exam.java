/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

/**
 *
 * @author Matteo Trupia
 */
public class Exam 
{
    private Course referenceCourse; // Reference course of the exam
    private Student examStudent; 
     private int studentMark;
     private int sda;
    
    public Exam(Course _referenceCourse, Student _examStudent, int _studentMark)
    {
        referenceCourse = _referenceCourse;
        examStudent = _examStudent;
        studentMark = _studentMark;
        
        University.universityExamsList.add(this);
    }
    
    // GET : 

        public Course getReferenceCourse() {
            return referenceCourse;
        }

        public Student getExamStudent() {
            return examStudent;
        }

        public int getStudentMark() {
            return studentMark;
        }
     
    // SET : 

        public void setReferenceCourse(Course referenceCourse) {
            this.referenceCourse = referenceCourse;
        }

        public void setExamStudent(Student examStudent) {
            this.examStudent = examStudent;
        }

        public void setStudentMark(int studentMark) {
            this.studentMark = studentMark;
        }  
        
    public void printInfo() // Print the Exam info
    {        
        System.out.println("\nReference course : " + referenceCourse.getName() +
                           "\nStudent : "+  examStudent.getStudentSerialNumber() + 
                           "\n Mark : " + studentMark + "\n");
    }
}
