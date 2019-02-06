public class StudentApplication{
    private Student student;
    private StudentEssay essay;
    StudentApplication(Student student, StudentEssay essay){
        this.student = student;
        this.essay = essay;
    }
    public Student getStudent() {
        return student;
    }
    public StudentEssay getStudentEssay() {
        return essay;
    }
}
