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
public class Professor 
{
    private String professorName;       // Professor Name
    private Data professorBirthDate;    // Professor Birth Date
    private String professorBirthCity;  // Professor Birth City
    
    private ArrayList<Course> professorCourseList = new ArrayList<>();    // List of the Professor Courses
    
    public Professor(String myName, String myCity, int day, int month, int year)   // Class constructor         
    {
        professorName = myName;                             // setup Professor Name
        professorBirthCity = myCity;                        // setup Professor Birth City
        professorBirthDate = new Data(day, month, year);    // setup Professor Birth Date
        
        University.universityProfessorsList.add(this);
    }
    
    // Get & Set:
        public String getName(){ return professorName; }
        public void setName(String newName){ professorName = newName; }

        public Data getBirthDate(){ return professorBirthDate; }
        public void setBirthDate(Data newBirthDate){ professorBirthDate = newBirthDate; }
        
        public String getBirthCity(){ return professorBirthCity; }
        public void setBirthCity(String newBirthCity){ professorBirthCity = newBirthCity; }
    
    public void addCourse(Course myCourse)
    {
        professorCourseList.add(myCourse);
    }
    
    public void removeCourse(int myCourse)
    {
        professorCourseList.remove(myCourse);
    }
    
    public void printInfo() // Print the Prof info
    {        
        System.out.println("\nName : " + professorName +
                           "\nBirth : "+  professorBirthDate + ", " + professorBirthCity + "\n");  // Print all the Course info 
    }
    
    public void printCoursesList()
    {
        System.out.println("\n## Professor " + professorName + " courses list ##");
        for(int i = 0; i < professorCourseList.size(); i++)
        {
            System.out.print((i+1) + " | ");
            professorCourseList.get(i).printInfo();
        }
        
        if(professorCourseList.size() == 0)
            System.out.print("[!] The course list is currently empty\n");
    }
    
}
