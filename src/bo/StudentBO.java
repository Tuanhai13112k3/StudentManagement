/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import constant.iConstant;
import entity.Student;
import exception.DuplicateDataException;
import exception.InvalidNameException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mock.Data;

/**
 *
 * @author acer
 */
public class StudentBO {

    private List<Student> studentList;

    public StudentBO() {
        this.studentList = new ArrayList<>();
    }

    public StudentBO(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Returns the number of elements in the studentList collection.
     *
     * @return The number of elements in the studentList collection.
     */
    public int getSize() {
        return this.studentList.size();
    }

    /**
     * Adds data to the studentList by loading it from an external source using
     * the Data class. The existing studentList will be replaced with the new
     * data.
     */
    public void addData() {
        Data data = new Data(this.studentList);
        data.LoadData();
        this.studentList = data.getStudentList();
    }

    /**
     * Displays the information of each student in the provided studentList.
     *
     * @param studentList The list of Student objects to be displayed.
     */
    public void display(List<Student> studentList) {
        for (Student sl : studentList) {
            System.out.println(sl);
        }
    }

    /**
     * Creates a new Student object and adds it to the studentList, performing
     * checks for valid and duplicate data.
     *
     * @return true if the student is successfully created and added to the
     * list, false otherwise.
     * @throws InvalidNameException if the provided name is invalid for an
     * existing student with the same ID.
     * @throws DuplicateDataException if the student with the same ID already
     * exists in the studentList with different attribute values.
     */
    public boolean createStudent() throws InvalidNameException, DuplicateDataException {
        Student student = new Student();
        String newID = student.inputStudentAttribute(iConstant.ID);
        String newName = student.inputStudentAttribute(iConstant.NAME);
        if (isExisted(newID)) {
            String oldName = findByID(newID).get(0).getStudentName();
            if (!newName.equals(oldName)) {
                throw new InvalidNameException();
            }
        }
        String newSemester = student.inputStudentAttribute(iConstant.SEMESTER);
        String newCourse = student.inputStudentAttribute(iConstant.COURSE);
        student = new Student(newID, newName, newSemester, newCourse);
        if (checkDuplicateInput(student)) {
            throw new DuplicateDataException();
        }
        return studentList.add(student);
    }

    /**
     * Checks if a given Student object already exists in the studentList, based
     * on the student's ID, name, semester, and course.
     *
     * @param student The Student object to check for duplicates in the
     * studentList.
     * @return true if a duplicate student with the same ID, name, semester, and
     * course exists in the studentList, false otherwise.
     */
    public boolean checkDuplicateInput(Student student) {
        for (Student listStudent : studentList) {
            if (listStudent.getStudentID().equals(student.getStudentID())
                    && listStudent.getStudentName().equals(student.getStudentName())
                    && listStudent.getSemester().equals(student.getSemester())
                    && listStudent.getCourse().equals(student.getCourse())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given attribute value exists as a student ID or student name
     * in the studentList.
     *
     * @param checkedAttribute The attribute value to check for existence as a
     * student ID or student name.
     * @return true if the attribute value exists as a student ID or student
     * name in the studentList, false otherwise.
     */
    public boolean isExisted(String checkedAttribute) {
        for (Student student : studentList) {
            if (student.getStudentID().equals(checkedAttribute)
                    || student.getStudentName().equals(checkedAttribute)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds students with a given student ID in the studentList.
     *
     * @param studentID The student ID to search for.
     * @return A list of students with the given student ID. If no matching
     * student is found, returns null.
     */
    public List<Student> findByID(String studentID) {
        if (!isExisted(studentID)) {
            return null;
        }
        List<Student> foundStudent = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentID().equals(studentID)) {
                foundStudent.add(student);
            }
        }
        return foundStudent;
    }

    /**
     * Finds students with a given student name (partial or full) in the
     * studentList.
     *
     * @param studentName The student name to search for.
     * @return A list of students whose names contain the given studentName. If
     * no matching student is found, returns an empty list.
     */
    public List<Student> findByName(String studentName) {

        List<Student> foundStudent = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentName().contains(studentName)) {
                foundStudent.add(student);
            }
        }
        return foundStudent;
    }

    /**
     * Sorts the list of found students by their names in ascending order.
     *
     * @param foundStudents The list of found students to be sorted.
     */
    public void sortByName(List<Student> foundStudents) {
        Collections.sort(foundStudents);
    }
    
    /**
    * Updates the information of a student with a given student ID from the list of found students.
    *
    * @param foundStudents The list of found students containing the student to be updated.
    * @param student The updated student object containing the new information.
    * @param orderOfRecords The index of the student in the foundStudents list to be updated.
    * @param isAccepted A flag indicating whether the update should be accepted or not.
    * @return true if the update is successful, false otherwise.
    */
    public boolean updateByID(List<Student> foundStudents, Student student,
            int orderOfRecords, boolean isAccepted) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equals(foundStudents.get(orderOfRecords))) {
                String id = studentList.get(i).getStudentID();
                String newName = student.inputStudentAttribute(iConstant.NAME);
                String oldName = findByID(id).get(0).getStudentName();
                if (!newName.equals(oldName) && isAccepted) {
                    changeAllName(id, newName);
                }
                String newSemester = student.inputStudentAttribute(iConstant.SEMESTER);
                studentList.get(i).setSemester(newSemester);
                String newCourse = student.inputStudentAttribute(iConstant.COURSE);
                studentList.get(i).setCourse(newCourse);
                return true;
            }
        }
        return false;
    }
    
    /**
    * Changes the name of all students with the given student ID to the new name.
    *
    * @param newID The student ID for which the name needs to be changed.
    * @param newName The new name to be assigned to all students with the given ID.
    */
    public void changeAllName(String newID, String newName) {
        for (Student student : studentList) {
            if (newID.equals(student.getStudentID())) {
                student.setStudentName(newName);
            }
        }
    }
    /**
     * Deletes a student from the main student list based on the index of the student in the found students list.
     *
     * @param foundStudents The list of found students containing the student to be deleted.
     * @param orderOfRecords The index of the student in the foundStudents list to be deleted.
     * @return true if the deletion is successful, false otherwise.
     */
    public boolean deleteByID(List<Student> foundStudents, int orderOfRecords) {
        for (int i = studentList.size() - 1; i >= 0; i--) {
            if (studentList.get(i).equals(foundStudents.get(orderOfRecords))) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }
}
