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

import java.util.UUID;

public class Course 
{
    private String courseName;                          // Course Name
    private UUID uuid = UUID.randomUUID();              // UUID
     private String courseCode = uuid.toString();;      //  > Course Code 
    
    public Course(String myName) // Class constructor
    {        
        courseName = myName;    // setup course name
        
        University.universityCoursesList.add(this);
    }  
    
    // Get & Set:
        public String getName(){ return courseName; }
        public void setName(String newName){ courseName = newName; }

        public String getCode(){ return courseCode; }
        public void setCode(String newCode){ courseCode = newCode; }
        
    public void printInfo() // Print the course info
    {        
        System.out.println("Course : " + courseName +
                           "\n Code : "+ courseCode + "\n");  // Print all the Course info 
    }
}
