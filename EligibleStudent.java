public class EligibleStudent{
    private StudentApplication studentApp;
    private Nomination nomination;

    EligibleStudent(StudentApplication sApp, Nomination nom){
        this.studentApp = sApp;
        this.nomination = nom;
    }

    public String toString(){
        return String.format("--Student Application\n\n%s\n--Nomination:\n%s", studentApp, nomination);
    }

    public StudentApplication getApplication() {
        return studentApp;
    }
    public Nomination getNomination() {
        return nomination;
    }
}
