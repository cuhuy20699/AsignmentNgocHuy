package assignment.main;

import assignment.model.StudentModel;
import assignment.controllerAdm.controller;
import java.util.Scanner;
import java.sql.SQLException;

public class menu {
    public static void main(String[] args) throws SQLException {
        menu menuStudent = new menu ();

        while (true){
            System.out.println ("======Student Management======");
            System.out.println ("1. List Student");
            System.out.println ("2. Add New Student");
            System.out.println ("3. Update Student");
            System.out.println ("4. Delete Student");
            System.out.println ("5. Exit");
            System.out.println ("------------------");
            System.out.println ("Please enter your choise");

            Scanner scanner = new Scanner (System.in);
            int choise = scanner.nextInt ();
            StudentModel model = new StudentModel ();
            controller test= new controller ();
            switch (choise){
                case 1:
                    test.printStudentList();
                    System.out.println ("Bảng danh sách chi tiết sinh viên" );
                    System.out.println ("                      " );
                    break;
                case 2:
                    try {
                        model.addListStudent ();
                    } catch (SQLException e) {
                        System.out.println ("Có lỗi sảy ra vui lòng kiểm tra lại");
                    }
                    System.out.println ("Tạo mới sinh viên thành công :)" );
                    System.out.println ("                       ");
                    break;
                case 3:
                    try {
                        test.uploadStudent ();
                    } catch (SQLException e) {
                        e.printStackTrace ( );
                    }
                    System.out.println ("Update sinh viên thành công");
                    break;
                case 4:
                    test.deleteStudent ();
                    System.out.println ("Xóa sinh viên thành công" );
                    break;
                case 5:
                    System.out.println ("Finished" );
                    System.exit (0);

                    break;
                default:
                    System.out.println ("Please enter to 1 do 5" );
                    break;
            }


        }



    }

}
