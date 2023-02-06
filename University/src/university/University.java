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

import java.util.ArrayList;
import java.util.Scanner;

public class University 
{
    static Scanner scan = new Scanner(System.in);
    
    static public ArrayList<Student> universityStudentsList = new ArrayList<>();
    static public ArrayList<Professor> universityProfessorsList = new ArrayList<>();
    static public ArrayList<Course> universityCoursesList = new ArrayList<>();
    static public ArrayList<Exam> universityExamsList = new ArrayList<>();
    
    static public void printAllStudents()  // Print all the Students of the university
    {
        System.out.println("\n## Students ##");
        for(int i = 0; i < universityStudentsList.size(); i++)
        {
            System.out.print((i+1) + " | ");
            universityStudentsList.get(i).printInfo();
        }
    }
    
    static public void printAllProfessors()  // Print all the Professors of the university
    {
        System.out.println("\n## Professors ##");
        for(int i = 0; i < universityProfessorsList.size(); i++)
        {
            System.out.print((i+1) + " | ");
            universityProfessorsList.get(i).printInfo();
        }
    }
    
    static public void printAllCourses()  // Print all the Courses of the university
    {
        System.out.println("\n## Courses ##");
        for(int i = 0; i < universityCoursesList.size(); i++)
        {
            System.out.print((i+1) + " | ");
            universityCoursesList.get(i).printInfo();
        }
    }
    
    static public void printAllExams()  // Print all the Exams of the university
    {
        System.out.println("\n## Exams ##");
        for(int i = 0; i < universityExamsList.size(); i++)
        {
            System.out.print((i+1) + " | ");
            universityExamsList.get(i).printInfo();
        }
        
        if(universityExamsList.size() == 0)
            System.out.print("[!] The exam list is currently empty\n");
    }
    
    static public void addStudent()  // Add a student
    {
        System.out.println("\n## Add a student ##");
        System.out.print("Fill in the fields below :\n" +
                           "> Day of Birth : ");
        int dayOfBirth = scan.nextInt();
        System.out.print("> Month of Birth : ");
        int monthOfBirth = scan.nextInt();
        System.out.print("> Year of Birth : ");
        int yearOfBirth = scan.nextInt();
        System.out.print("> City of Birth : ");
        String cityOfBirth = scan.next();
        System.out.print("> Region of Birth : ");
        String regionOfBirth = scan.next();
        
        new Student(dayOfBirth, monthOfBirth, yearOfBirth, cityOfBirth, regionOfBirth);
        System.out.println("\n[!] The student has been successfully added to the program.");
        
        universityStudentsList.get(universityStudentsList.size()-1).printInfo();
    }
    
    static public void addProfessor()  // Add a professor
    {
        System.out.println("\n## Add a professor ##");
        System.out.print("Fill in the fields below :\n" +
                           "> Name : ");
        String professorName = scan.next();
        System.out.print("> City of Birth : ");
        String professorCityOfBirth = scan.next();
        System.out.print("> Day of Birth : ");
        int dayOfBirth = scan.nextInt();
        System.out.print("> Month of Birth : ");
        int monthOfBirth = scan.nextInt();
        System.out.print("> Year of Birth : ");
        int yearOfBirth = scan.nextInt();
        
        new Professor(professorName, professorCityOfBirth, dayOfBirth, monthOfBirth, yearOfBirth);
        System.out.println("\n[!] The professor has been successfully added to the program.");
        
        universityProfessorsList.get(universityProfessorsList.size()-1).printInfo();
    }
    
    static public void addCourse()  // Add a course
    {
        System.out.println("\n## Add a course ##");
        System.out.print("Fill in the field below :\n" +
                           "> Name of the course: ");
        String courseName = scan.next();
        
        new Course(courseName);
        System.out.println("\n[!] The course has been successfully added to the program.\n");
        universityCoursesList.get(universityCoursesList.size()-1).printInfo();
    }
    
    static public void addExam()  // Add an exam
    {
        System.out.println("\n## Add an exam ##");
        System.out.print("Fill in the fields below :\n" +
                           "> Index of the reference course : ");
        int examReferenceCourseIndex = scan.nextInt();
        System.out.print("> Student index : ");
        int examStudentIndex = scan.nextInt();
        System.out.print("> Assessment of the student for the exam : ");
        int examStudentMark = scan.nextInt();
        
        universityStudentsList.get(examStudentIndex - 1).addExam(new Exam(universityCoursesList.get(examReferenceCourseIndex - 1), universityStudentsList.get(examStudentIndex - 1), examStudentMark));
        System.out.println("\n[!] The Exam has been successfully added to the program.");
        
        universityExamsList.get(universityExamsList.size()-1).printInfo();
    }
    
    static public void addCourseToProfessor()  // Add a course to the professor’s list
    {
        System.out.println("\n## Add a course to the professor ##");
        System.out.print("Fill in the fields below :\n" +
                           "> Index of the professor : ");
        int professorIndex = scan.nextInt() - 1;
        System.out.print("> Index of the course to add to the prof. " + universityProfessorsList.get(professorIndex).getName() + " : ");
        int courseToAddIndex = scan.nextInt() - 1;
        
        universityProfessorsList.get(professorIndex).addCourse(universityCoursesList.get(courseToAddIndex));
        System.out.println("\n[!] The Course has been successfully added to the professor’s list.");
        
        universityProfessorsList.get(professorIndex).printInfo();
        universityProfessorsList.get(professorIndex).printCoursesList();
    }
    
    static public void removeCourseToProfessor()  // Remove a course from the professor’s list
    {
        System.out.println("\n## Remove a course to the professor ##");
        printAllProfessors();
        System.out.print("Fill in the fields below :\n" +
                           "> Index of the professor : ");
        int professorIndex = scan.nextInt() - 1;
        
        universityProfessorsList.get(universityProfessorsList.size() - 1).printCoursesList();
        System.out.print("\n> Index of the course to remove to the prof. " + universityProfessorsList.get(professorIndex).getName() + " : ");
        int courseToRemoveIndex = scan.nextInt() - 1;
        
        universityProfessorsList.get(professorIndex).removeCourse(courseToRemoveIndex);
        System.out.println("\n[!] The Course has been successfully removed from the professor’s list.");
        
        universityProfessorsList.get(professorIndex).printInfo();
        universityProfessorsList.get(professorIndex).printCoursesList();
    }
    
    static public void changeNameToCourse()  // Change the name to a course
    {
        System.out.println("\n## Change the name to a course ##");
        printAllCourses();
        System.out.print("\nFill in the fields below :\n" +
                           "> Index of the course : ");
        int changeNameCourseIndex = scan.nextInt() - 1;
        universityCoursesList.get(changeNameCourseIndex).printInfo();
        System.out.print("\n> New name for the course : ");
        String newCourseName = scan.next();
        
        universityCoursesList.get(changeNameCourseIndex).setName(newCourseName);
        System.out.println("\n[!] The course has successfully changed its name to " + universityCoursesList.get(changeNameCourseIndex).getName() + ".");
        
        universityCoursesList.get(changeNameCourseIndex).printInfo();      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {     
        // Instances of filling, example :
            new Student(5, 1, 2003, "Milano", "Lomabrdia");   
            new Student(15, 3, 2004, "Roma", "Lazio");   
            new Student(1, 11, 2002, "Villaseta", "Agrigento");   
            new Student(31, 8, 2002, "Cairate", "Lombardia");   
            new Professor("Marco", "Milano", 21, 12, 1974); 
            new Professor("Lucia", "Milano", 12, 1, 1968); 
            new Course("Math"); 
            new Course("Italian"); 
            new Course("PT"); 
            new Course("Science"); 
            
        int choose;        
        
        System.out.println("#### UNIVERSITY ####");
        System.out.println("    Matteo Trupia \n"
                         + "____________________\n");
        
        do
        {
            System.out.print("\n- Choose an operation :\n"
                    + "1  > Print all students. \n"
                    + "2  > Print all professors. \n"
                    + "3  > Print all courses. \n"
                    + "4  > Print all exams. \n"
                    + "5  > Add a student.\n"
                    + "6  > Add a professor.\n"
                    + "7  > Add a course.\n"
                    + "8  > Add an exam.\n"
                    + "9  > Add a course to a professor.\n"
                    + "10 > Remove a course to a professor.\n"
                    + "11 > Change the name of a course.\n"
                    + "12 > Exit.\n"
                    + "\n> ");
            choose = scan.nextInt();    
            
            switch(choose)
            {
                case 1:
                    printAllStudents();
                    break;
                case 2:
                    printAllProfessors();
                    break;
                case 3:
                    printAllCourses();
                    break;                    
                case 4:
                    printAllExams();
                    break;
                case 5:
                    addStudent();
                    break;
                case 6:
                    addProfessor();
                    break;
                case 7:
                    addCourse();
                    break;
                case 8:
                    addExam();
                    break;
                case 9:
                    addCourseToProfessor();                    
                    break;
                case 10:
                    removeCourseToProfessor();
                    break;
                case 11:
                    changeNameToCourse();
                    break;                
                case 12:
                    break;
                default:
                    System.out.println("[!] : Enter a valid option!");
                    break;
            }
            
        } while(choose != 12);
        
        System.out.println("\n\n[!] : Successful exit from the program!");        
        System.out.println("__________________________________");
        System.out.println("Matteo Trupia, University management java code\n\n");
    }    
}
