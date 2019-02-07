import java.io.Serializable;
public class StudentApplication implements Serializable{
    private Student student;
    private StudentEssay essay;
    StudentApplication(Student student, StudentEssay essay){
        this.student = student;
        this.essay = essay;
    }

    public String toString(){
        return String.format("%s\n\n%s", student, essay);
    }
    public Student getStudent() {
        return student;
    }
    public StudentEssay getStudentEssay() {
        return essay;
    }
}
