import java.util.Scanner;

public class StudentAppProgram{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        Student student = makeStudent(stdin);
        StudentEssay essay = makeStudentEssay(stdin);
        StudentApplication application = new StudentApplication(student, essay);
        FileIO.saveStudentApplication(application);
        System.out.println(application);
   }



    public static Student makeStudent(Scanner stdin){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("[0/10] COMPLETED");String name = Util.getSingleLine("Name: ", stdin, false);
        System.out.println("");
        System.out.println("[1/10] COMPLETED");String email = Util.getSingleLine("Email: ", stdin, Util.getEmailRegex());
        System.out.println("");
        System.out.println("[2/10] COMPLETED");String school = Util.getSingleLine("School you currently attend: ", stdin, false);
        System.out.println("");
        System.out.println("[3/10] COMPLETED");String eligibility = Util.getEligibility("Do you meet our eligibility requirements?  [y/n] ", stdin);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        if (eligibility.equals("n")){
            System.exit(0);
        }
        
        //next section
        System.out.println("[4/10] COMPLETED");String age = Util.getSingleLine("Age: ", stdin, Util.getAgeRegex());
        System.out.println("");
        System.out.println("[5/10] COMPLETED");System.out.println("~In The Following Format 123-456-7890~");String phone = Util.getSingleLine("Phone Number: ", stdin, Util.getPhoneNumRegex());
        System.out.println("");
        System.out.println("[6/10] COMPLETED");System.out.println("~In The Following Format MM-DD-YEAR~");String date = Util.getSingleLine("Expected Graduation Date: ", stdin, Util.getDateRegex());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        return new Student(name, email, school, age, phone, date);
    }
    public static StudentEssay makeStudentEssay(Scanner stdin){
        System.out.println("~For the Following Questions~\n~Type (END) on its own line~");
        System.out.println("");
        System.out.println("[7/10] COMPLETED");String plan = Util.getMultiLines("What is your current plan for next year:  ", stdin);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("[8/10] COMPLETED");String aptitude = Util.getMultiLines("~Please Share a Specific example of~ \n~when you were a Strong problem solver~\n\nAptitude: ", stdin);     
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("[9/10] COMPLETED");String dedication = Util.getMultiLines("~Please Share a Specific example of~ \n~your Dedication & Work Ethic~\n\nDedication/ Work Ethic/ Heart: ", stdin);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n");
        String passion =  Util.getMultiLines("~Please tell us about something you are~ \n~passionate about & worked hard to achieve~\n\nPassion/ Persistance: ", stdin);
        System.out.println("[10/10] COMPLETED");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        return new StudentEssay(plan, aptitude, dedication, passion);
    }




}
