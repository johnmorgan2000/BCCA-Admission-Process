import java.io.Serializable;

public class Student implements Serializable{
    String name;
    String email;
    String school;
    String age;
    String phone;
    String graduationDate;
    
    Student(String name, String email, String school, String age, String phone, String graduationDate){
        this.name = name;
        this.email = email;
        this.school = school;
        this.age = age;
        this.phone = phone;
        this.graduationDate = graduationDate;
    }
        
    public String toString() {
        return String.format("Name: %s\nEmail: %s\nSchool: %s\nAge: %s\nPhone: %s\nGraduation Date: %s",
                name,
                email,
                school,
                age,
                phone,
                graduationDate);
    }
}
