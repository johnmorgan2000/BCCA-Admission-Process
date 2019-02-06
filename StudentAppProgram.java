import java.util.Scanner;

public class StudentAppProgram{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Student student = makeStudent(stdin);
        StudentEssay essay = makeStudentEssay(stdin);
    }

    public static Student makeStudent(Scanner stdin){
        String name = Util.getSingleLine("Name: ", stdin, false);
        String email = Util.getSingleLine("Email: ", stdin, false);
        String school = Util.getSingleLine("School you currently attend: ", stdin, false);
        String eligibility = Util.getEligibility("Do you meet our eligibility requirements?: ", stdin);
        
        if (eligibility.equals("n")){
            System.exit(0);
        }
        
        //next section
        String age = Util.getSingleLine("Age: ", stdin, false); //number regex
        String phone = Util.getSingleLine("Phone Number: ", stdin, false); //Phone num regex
        String date = Util.getSingleLine("Expected Graduation Date: ", stdin, false); //Date regex
        return new Student(name, email, school, age, phone, date);
    }
    public static StudentEssay makeStudentEssay(Scanner stdin){
        String plan = Util.getMultiLines("What is your current plan for next year:  ", stdin);
        String aptitude = Util.getMultiLines("Aptitude:\n~Please Share a Specific example of \nwhen you were a Strong problem solver~", stdin);     
        String dedication = Util.getMultiLines("Dedication/ Work Ethic/ Heart:\n~Please Share a Specific example of \nyour Dedication & Work Ethic~", stdin);
        String passion =  Util.getMultiLines("Passion/ Persistance:\n~Please tell us about something you are \npassionate about & worked hard to achieve~", stdin);

        return new StudentEssay(plan, aptitude, dedication, passion);
    }


}
