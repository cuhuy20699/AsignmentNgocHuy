package assignment.controllerAdm;

import assignment.model.StudentModel;

import java.sql.SQLException;
import java.util.ArrayList;
import assignment.entity.Student;

public class controller {
    StudentModel model = new StudentModel ();
    public void printStudentList() {
        StudentModel model = new StudentModel ();

        ArrayList<Student> list = model.getListStudent();
        System.out.println("=======Student list======");
        System.out.println("Id \t rollNumber \t name \t phone \t email \t status");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId() + "\t" + student.getRollNumber()+ "\t \t"+ student.getName()+ "\t \t" + student.getPhone() + "\t \t"+ student.getEmail()+ "\t \t"+ student.getStatus() );
            System.out.println ("-----------------------------------------------------------");
        }
        System.out.println("==========================");
    }

    public void addStudent() throws SQLException {
         ArrayList<Student> listStudent = model.addListStudent ( );
    }

    public void uploadStudent() throws  SQLException{
        ArrayList<Student> listStudent = model.uploadStudent ( );
    }

    public void deleteStudent() throws SQLException{
        ArrayList<Student> listStudent = model.deleteStudent ();

    }
}
