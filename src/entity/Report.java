/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import entity.Student;
import java.util.List;

/**
 *
 */
public class Report {

    private String studentName;
    private String courseName;
    private int totalCourse;

    public Report() {
    }

    public Report(String studentName, String courseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }
    
    /**
    * Calculate and set the total number of students in the same course with the given student ID and course name.
    *
    * @param studentList The list of Student objects to search for the students with the given ID and course name.
    * @param id          The ID of the student to find.
    * @param course      The course name to find.
    * @param totalCourse The initial total course count (usually set to 0 before the method call).
    */
    public void setTotalCourse(List<Student> studentList, String id, 
            String course, int totalCourse) {
        for (Student student2 : studentList) {
            if (student2.getStudentID().equals(id)
                    && student2.getCourse().equals(course)) {
                totalCourse++;
            }
        }
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return String.format("%s\t|%s\t|%s", studentName,courseName,totalCourse);
    }
}