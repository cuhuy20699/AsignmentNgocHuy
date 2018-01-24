package assignment.model;

// class thao tác với bàng students trong database
// các thao tác thêm mới, sửa xóa, update thông tin sinh viên

import assignment.entity.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Statement;


public class StudentModel {
    public static void main(String[] args) throws SQLException {
        StudentModel test = new StudentModel ( );
        test.uploadStudent ( );
    }

    private String rollNumber;

    public ArrayList<Student> getListStudent() {
        //Khởi tạo một Arraylist rỗng để chứa dữ liệu trả về
        ArrayList<Student> listStudent = new ArrayList<> ( );
        // tạo kết nối với database
        Connection connection = connectionUrl.connectionHelp ( );

        try {

            // tạo đôi tượng statement để kết nối sql
            Statement statement = connection.createStatement ( );
            // thực thi cau lệnh sql đưa về trả vào resultset
            ResultSet rs = statement.executeQuery ("select * from students");
            // Với từng dòng trả về trong resultset, lấy ra các cột tương ứng và tạo đối tượng student.

            while (rs.next ( )) {
                int id = rs.getInt ("id");
                String rollNumber = rs.getString ("rollNumber");
                String name = rs.getString ("name");
                String phone = rs.getString ("phone");
                String email = rs.getString ("email");
                int status = rs.getInt ("status");
                // Tạo ra đối tượng student tương ứng với các trường vừa lấy ra.
                Student student = new Student (id, rollNumber, name, phone, email, status);
                // thêm đối tượng vào Arraylist rỗng đã tạo
                listStudent.add (student);
            }

        } catch (SQLException ex) {
            System.err.println ("Can not connect to database.");
        } finally {
            try {
                connection.close ( );
            } catch (SQLException ex) {
                System.err.println ("Can not close connection.");
            }
        }
        // trả về kết quả defaul;
        return listStudent;
    }

    public ArrayList<Student> addListStudent() throws SQLException {

        Scanner scanner = new Scanner (System.in);
        Student student = new Student ( );

        while (true) {
            System.out.println ("Enter Name:");
            String name = scanner.nextLine ( );
            if (name != null && name.length ( ) > 4) {
                student.setName (name);
                break;
            }
            System.out.println ("Please enter name:");
        }

        while (true) {
            System.out.println ("Enter RollNumber:");
            String rollNumber = scanner.nextLine ( );
            if (rollNumber != null && rollNumber.length ( ) > 4) {
                student.setRollNumber (rollNumber);
                break;
            }
            System.out.println ("Please enter rollNumber:");
        }

        while (true) {
            System.out.println ("Enter Phone:");
            String phone = scanner.nextLine ( );
            if (phone != null && phone.length ( ) > 4) {
                student.setPhone (phone);
                break;
            }
            System.out.println ("Please enter phone:");
        }

        while (true) {
            System.out.println ("Enter Email: ");
            String email = scanner.nextLine ( );
            if (email != null && email.length ( ) > 4) {
                student.setEmail (email);
                break;
            }
            System.out.println ("Please enter email:");
        }

        Connection connection = connectionUrl.connectionHelp ( );
        Statement statement = connection.createStatement ( );
        statement.execute (" INSERT INTO Students(name, rollNumber, phone, email) VALUES ('" + student.getName ( ) + "','" + student.getRollNumber ( ) + "', '" + student.getPhone ( ) + "' , '" + student.getEmail ( ) + "')");
        System.out.println ("========================");
        return null;
    }

    public ArrayList<Student> deleteStudent() throws SQLException {
        // tạo kết nối tới database
        Scanner scanner = new Scanner (System.in);
        Student student = new Student ( );

        while (true) {
            System.out.println ("Please enter rollNumber");
            String rollNumber = scanner.nextLine ( );
            if (rollNumber != null && rollNumber.length ( ) > 3) {
                student.setRollNumber (rollNumber);
                break;
            }
            System.out.println ("Sai mã sinh viên( mã rollNumber)");
        }
        Connection connection = connectionUrl.connectionHelp ( );
        Statement statement = connection.createStatement ( );
        statement.executeUpdate (" UPDATE Students SET status = '-1' WHERE rollNumber = '" + student.getRollNumber ( ) + "' ");


        System.out.println ("Update Thành Công");

        return null;

    }

    public ArrayList<Student> uploadStudent() throws SQLException {
        Scanner scanner = new Scanner (System.in);
        Student student = new Student ( );

        while (true) {
            System.out.println ("Please enter rollNumber ");
            String rollNumber = scanner.nextLine ( );
            if (rollNumber != null && rollNumber.length ( ) > 3) {
                student.setRollNumber (rollNumber);
                break;
            }
        }
        System.out.println ("1. Upload Name:");
        System.out.println ("2. Upload Phone:");
        System.out.println ("3. Upload Email");
        System.out.println ("4.Upload Name, Phone, Email:");
        int choise = scanner.nextInt ( );
        switch (choise) {
            case 1:
                while (true) {
                    System.out.println ("Enter Name");
                    String name = scanner.nextLine ( );
                    if (name != null && name.length ( ) > 4) {
                        student.setName (name);
                        break;
                    }
                }
                Connection connection = connectionUrl.connectionHelp ( );
                Statement statement = connection.createStatement ( );
                statement.executeUpdate (" UPDATE Students SET name = '" + student.getName ( ) + "'  WHERE rollNumber = '" + student.getRollNumber ( ) + "' ");
                System.out.println ("Upload Name Success");
                break;
            case 2:
                while (true) {
                    System.out.println ("Enter Phone");
                    String phone = scanner.nextLine ( );
                    if (phone != null && phone.length ( ) > 4) {
                        student.setPhone (phone);
                        break;
                    }
                }
                connection = connectionUrl.connectionHelp ( );
                statement = connection.createStatement ( );
                statement.executeUpdate (" UPDATE Students SET  phone = '" + student.getPhone ( ) + "' WHERE rollNumber = '" + student.getRollNumber ( ) + "' ");
                System.out.println ("Upload Phone Success");

                break;
            case 3:
                while (true) {
                    System.out.println ("Enter Email");
                    String email = scanner.nextLine ( );
                    if (email != null && email.length ( ) > 4) {
                        student.setEmail (email);
                        break;
                    }
                }
                connection = connectionUrl.connectionHelp ( );
                statement = connection.createStatement ( );
                statement.executeUpdate (" UPDATE Students SET  email = '" + student.getEmail ( ) + "'  WHERE rollNumber = '" + student.getRollNumber ( ) + "' ");
                System.out.println ("Upload Email Success");

                break;
            case 4:

                while (true) {
                    System.out.println ("Enter Name");
                    String name = scanner.nextLine ( );
                    if (name != null && name.length ( ) > 4) {
                        student.setName (name);
                        break;
                    }
                }


                while (true) {
                    System.out.println ("Enter Phone");
                    String phone = scanner.nextLine ( );
                    if (phone != null && phone.length ( ) > 4) {
                        student.setPhone (phone);
                        break;
                    }
                }

                while (true) {
                    System.out.println ("Enter Email");
                    String email = scanner.nextLine ( );
                    if (email != null && email.length ( ) > 4) {
                        student.setEmail (email);
                        break;
                    }
                }
                connection = connectionUrl.connectionHelp ( );
                statement = connection.createStatement ( );
                statement.executeUpdate (" UPDATE Students SET name = '" + student.getName ( ) + "', phone = '" + student.getPhone ( ) + "', email = '" + student.getEmail ( ) + "'  WHERE rollNumber = '" + student.getRollNumber ( ) + "' ");
                System.out.println ("Upload Success");
                break;

            default:
                System.out.println ("ERROR");
                break;

        }

        return null;
    }


}