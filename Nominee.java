import java.io.Serializable;

public class Nominee implements Serializable{
    public String name;
    public int age;
    public String date;

    Nominee(String name, int age, String date){
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public String toString(){
        return String.format("%s %s %s", name, age, date);
    }
}
