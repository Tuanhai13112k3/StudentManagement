/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mock;

import entity.Student;
import java.util.List;

/**
 *
 * @author acer
 */
public class Data {

    private List<Student> studentList;

    public Data(List studentList) {
        this.studentList = studentList;
    }
    
    /**
    * Load sample data and add Student objects to the studentList.
    * This method is used to initialize the studentList with sample data.
    */
    public void LoadData() {
        // Thêm các đối tượng Student vào danh sách
        studentList.add(new Student("HE172555", "Lai Tuan Hai", "Spring2023", "Java"));
        studentList.add(new Student("HE172555", "Lai Tuan Hai", "Fall2023", ".Net"));
        studentList.add(new Student("HE172580", "Nguyen Khac Long", "Fall2022", "Java"));
        studentList.add(new Student("HE172580", "Nguyen Khac Long", "Spring2023", "Java"));
        studentList.add(new Student("IS173218", "Nguyen Van A", "Spring2023", "C/C++"));
        studentList.add(new Student("IS173218", "Nguyen Van A", "Fall2023", "Java"));
        studentList.add(new Student("SE172555", "Lai Tuan", "Summer2023", "C/C++"));
        studentList.add(new Student("JS172555", "Tuan Hai", "Fall2022", "C/C++"));
        studentList.add(new Student("SE204415", "Lai Tuan Hai", "Summer2019", ".Net"));
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
