import java.io.Serializable;

public class StudentEssay implements Serializable{
    public String plan;
    public String aptitude;
    public String dedication;
    public String passion;

    StudentEssay(String plan, String aptitude, String dedication, String passion){
        this.plan = plan;
        this.aptitude = aptitude;
        this.dedication = dedication;
        this.passion = passion;
    }

    public String toString(){
        return String.format("Future Plans:\n%s\nAptitude:\n%s\nDedication:\n%s\nPassion:\n%s\n", plan, aptitude, dedication, passion); 
    }
    
}
