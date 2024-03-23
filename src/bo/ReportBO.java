/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import Entity.Report;
import entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class ReportBO {

    private List<Report> reportList;

    public ReportBO() {
        this.reportList = new ArrayList<>();
    }

    public ReportBO(List<Report> reportList) {
        this.reportList = reportList;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    /**
     * Get the number of elements in the reportList.
     *
     * @return The number of reports in the list.
     */
    public int getSize() {
        return this.reportList.size();
    }

    /**
     * Generate and add a report for each student in the provided studentList.
     * The report contains information such as student ID, name, course, and
     * total students in the same course. If a report with the same student
     * name, course name, and total students exists in the list, it will not be
     * added again.
     *
     * @param studentList The list of Student objects to generate the reports
     * from.
     */
    public void addReport(List<Student> studentList) {
        for (Student student1 : studentList) {
            String id = student1.getStudentID();
            String name = student1.getStudentName();
            String course = student1.getCourse();
            Report report = new Report();
            report.setTotalCourse(studentList, id, course, 0);
            report = new Report(name, course, report.getTotalCourse());
            if (checkDuplicate(report)) {
                continue;
            }
            reportList.add(report);
        }
    }

    /**
     * Display the reports in the reportList. Each report will be printed on a
     * separate line.
     */
    public void displayReport() {
        for (Report report : reportList) {
            System.out.println(report);
        }
    }

    /**
     * Check if a report with the same student name, course name, and total
     * students exists in the reportList.
     *
     * @param report The Report object to check for duplicates.
     * @return true if a duplicate report exists, false otherwise.
     */
    public boolean checkDuplicate(Report report) {
        for (Report report1 : reportList) {
            if (report.getStudentName().equals(report1.getStudentName())
                    && report.getCourseName().equals(report1.getCourseName())
                    && report.getTotalCourse() == report1.getTotalCourse()) {
                return true;
            }
        }
        return false;
    }
}
