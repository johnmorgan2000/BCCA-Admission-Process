import java.util.Scanner;

public class StudentAppProgram{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Student student = makeStudent(stdin);
        StudentEssay essay = makeStudentEssay(stdin);
        StudentApplication application = new StudentApplication(student, essay);
        System.out.println(application);
   }



    public static Student makeStudent(Scanner stdin){
        System.out.println("[0/10] COMPLETED");String name = Util.getSingleLine("Name: ", stdin, false);
        System.out.println("");
        System.out.println("[1/10] COMPLETED");String email = Util.getSingleLine("Email: ", stdin, false);
        System.out.println("");
        System.out.println("[2/10] COMPLETED");String school = Util.getSingleLine("School you currently attend: ", stdin, false);
        System.out.println("");
        System.out.println("[3/10] COMPLETED");String eligibility = Util.getEligibility("Do you meet our eligibility requirements?: ", stdin);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (eligibility.equals("n")){
            System.exit(0);
        }
        
        //next section
        System.out.println("[4/10] COMPLETED");String age = Util.getSingleLine("Age: ", stdin, false); //number regex
        System.out.println("");
        System.out.println("[5/10] COMPLETED");String phone = Util.getSingleLine("Phone Number: ", stdin, false); //Phone num regex
        System.out.println("");
        System.out.println("[6/10] COMPLETED");String date = Util.getSingleLine("Expected Graduation Date: ", stdin, false); //Date regex
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return new Student(name, email, school, age, phone, date);
    }
    public static StudentEssay makeStudentEssay(Scanner stdin){
        System.out.println("~For the Following Questions~\n~Type (END) on its own line~\n");
        System.out.println("[7/10] COMPLETED");String plan = Util.getMultiLines("What is your current plan for next year:  ", stdin);
        System.out.println("");
        System.out.println("[8/10] COMPLETED");String aptitude = Util.getMultiLines("~Please Share a Specific example of~ \n~when you were a Strong problem solver~\n>>Aptitude: ", stdin);     
        System.out.println("");
        System.out.println("[9/10] COMPLETED");String dedication = Util.getMultiLines("~Please Share a Specific example of~ \n~your Dedication & Work Ethic~\n>>Dedication/ Work Ethic/ Heart: ", stdin);
        System.out.println("");
        String passion =  Util.getMultiLines("~Please tell us about something you are~ \n~passionate about & worked hard to achieve~\n>>Passion/ Persistance: ", stdin);
        System.out.println("[10/10] COMPLETED");
        return new StudentEssay(plan, aptitude, dedication, passion);
    }




}
