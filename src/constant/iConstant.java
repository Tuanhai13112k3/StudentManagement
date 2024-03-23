/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package constant;

/**
 *
 * @author acer
 */
public interface iConstant {
    String REGEX_ID = "^[A-Z]{2}\\d{6}$";
    String REGEX_NAME = "^(?:[A-Z][a-z]*\\s)*[A-Z][a-z]*$";
    String REGEX_SEMESTER = "^(Spring|Summer|Fall)\\d{4}$";
    String REGEX_COURSE = "Java|[C][/][C][+]{2}|.Net";
    String UPDATE = "Update";
    String CREATE = "Create";
    String REGEX_YN = "[Y|N]";
    String ID = "id";
    String NAME = "name";
    String SEMESTER = "semester";
    String COURSE = "course";
}
