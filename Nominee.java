import java.io.Serializable;

public class Nominee implements Serializable{
    public String name;
    public int age;
    public String date;
    public Qualification qualification;

    Nominee(String name, int age, String date, Qualification qualification){
        this.name = name;
        this.age = age;
        this.date = date;
        this.qualification = qualification;
    }

    public String toString(){
        return String.format("\n--Nominee--\nName: %s\nAge: %s\nDate: %s\n %s", name, age, date, qualification);
    }
}
