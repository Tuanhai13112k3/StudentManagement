/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import bo.ReportBO;
import bo.StudentBO;
import constant.iConstant;
import java.util.ArrayList;
import util.Validation;
import java.util.List;
import entity.Student;
import exception.DuplicateDataException;
import exception.InvalidNameException;

/**
 *
 * @author acer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentBO studentBO = new StudentBO(new ArrayList<>());
        studentBO.addData();
        ReportBO reportBO = new ReportBO(new ArrayList<>());
        do {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("\t1. Create");
            System.out.println("\t2. Find and Sort");
            System.out.println("\t3. Update/Delete");
            System.out.println("\t4. Report");
            System.out.println("\t5. Exit");
            int selection = Validation.getInt("Your choice: ",
                    "Please choose 1 to Create, "
                    + "2 to Find and Sort, 3 to Update/Delete, "
                    + "4 to Report and 5 to Exit program",
                    "Invalid Value", 1, 5);
            switch (selection) {
                case 1:
                    boolean choice = true;
                    do {
                        try {
                            if (studentBO.createStudent()) {
                                System.out.println("Create successfully!");
                            }
                        } catch (InvalidNameException e) {
                            System.out.println("This ID is belong to another one."
                                    + " Create unsucessfully");
                        } catch (DuplicateDataException e) {
                            System.out.println("This data is existed."
                                    + " Create unsucessfully");
                        }
                        if (studentBO.getSize() >= 10) {
                            choice = Validation.getYN("Do you want to continue (Y/N)? ",
                                    "Choose Y to continue, N to return main screen.",
                                    iConstant.REGEX_YN);
                        }
                    } while (choice);
                    break;
                case 2:
                    String nameToSearch = Validation.getString("Enter student's name to search: ",
                            "Name is invalid (Correct form is Abc Def ..."
                            + " and cannot contain number or special character).",
                            iConstant.REGEX_NAME);
                    List<Student> foundStudent;
                    foundStudent = studentBO.findByName(nameToSearch);
                    if (foundStudent != null) {
                        studentBO.sortByName(foundStudent);
                        studentBO.display(foundStudent);
                    } else {
                        System.out.println("This name or part of name is not "
                                + "existed!");
                    }
                    break;
                case 3:
                    String idToSearch = Validation.getString("Enter student's ID to search: ",
                            "ID is invalid (Correct form is AZxxxxxx).",
                            iConstant.REGEX_ID);
                    foundStudent = studentBO.findByID(idToSearch);
                    String getUpOrDel = Validation.getString(
                            "Do you want to update (U) or delete (D) student.",
                            "If user chooses U, "
                            + "the program allows user updating. "
                            + "Choose D for deleting student.",
                            "[U|D]");
                    if (foundStudent != null) {
                        studentBO.display(foundStudent);
                        Student student = new Student();
                        int whichRecord = 0;
                        if (foundStudent.size() > 1) {
                            whichRecord = Validation.getInt("Choose the record to "+getUpOrDel+": ",
                                    "0 is first record, 1 is second record, ...",
                                    "Invalid number",
                                    0, foundStudent.size()-1);
                        }
                        switch (getUpOrDel) {
                            case "U":
                                boolean isAccepted = Validation.getYN(
                                "Because 1 ID only has 1 owner so when you update name"
                                + ", all records with the same ID will be updated."
                                + "\nDo you agree (Y/N)? ",
                                "Choose Y to change all, "
                                + "N to keep the name.",
                                iConstant.REGEX_YN);
                                studentBO.updateByID(foundStudent, student,
                                        whichRecord, isAccepted);
                                break;
                            case "D":
                                studentBO.deleteByID(foundStudent, whichRecord);
                                break;
                        }
                        studentBO.display(studentBO.getStudentList());
                    } else {
                        System.out.println("This ID is not existed!");
                    }
                    break;
                case 4:
                    reportBO.addReport(studentBO.getStudentList());
                    reportBO.displayReport();
                    break;
                case 5:
                    System.exit(0);
            }
            System.out.println("");
        } while (true);
    }
}
