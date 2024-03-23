/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import util.Validation;
import constant.iConstant;

/**
 *
 * @author acer
 */
public class Student implements Comparable<Student> {

    private String studentID;
    private String studentName;
    private String semester;
    private String course;

    public Student() {
    }

    public Student(String studentID, String studentName, String semester, String course) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.semester = semester;
        this.course = course;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    /**
    * Prompts the user to input a student attribute and validates the input based on the specified regular expression.
    *
    * @param ATTRIBUTE The attribute of the student to be entered (e.g., ID, Name, Semester, or Course).
    * @return The validated value of the specified student attribute.
    *         If the ATTRIBUTE value is not valid, the method returns null.
    */
    public String inputStudentAttribute(final String ATTRIBUTE) {
        switch (ATTRIBUTE) {
            case iConstant.ID:
                this.studentID = Validation.getString("Enter student's ID: ",
                        "ID is invalid (Correct form is AZxxxxxx).",
                        iConstant.REGEX_ID);
                return this.studentID;
            case iConstant.NAME:
                this.studentName = Validation.getString("Enter student's name: ",
                        "Name is invalid (Correct form is Abc Def ..."
                        + " and cannot contain number or special character).",
                        iConstant.REGEX_NAME);
                return this.studentName;
            case iConstant.SEMESTER:
                this.semester = Validation.getString("Enter student's semester: ",
                        "Semester is invalid "
                        + "(Correct form is season + year: \"Spring2023\").",
                        iConstant.REGEX_SEMESTER);
                return this.semester;
            case iConstant.COURSE:
                this.course = Validation.getString("Enter student's course: ",
                        "Course is invalid "
                        + "(Correct course is in (Java,C/C++,.Net)).",
                        iConstant.REGEX_COURSE);
                return this.course;
            default :
                System.out.println("This Attribute is not existed");
                return null;
        }
    }

    @Override
    public String toString() {
        return String.format("|\t%s\t|\t%s\t|\t%s\t|", studentName,semester,course);
    }

    @Override
    public int compareTo(Student student) {
        return student.studentName.compareTo(this.studentName);
    }
}
