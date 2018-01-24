package assignment.entity;

public class Student {

    private int id;
    private String rollNumber;
    private String name;
    private String phone;
    private String email;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Student(){
    }

    public Student(String name, String rollNumber, String phone, String email){
        this.name = name;
        this.rollNumber = rollNumber;
        this.phone = phone;
        this.email = email;
    }

    public  Student(int id, String name, String rollNumber, String phone, String email, int status ){
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

}
