import java.util.Scanner;

public class StudentAppProgram{
    public void run(Scanner stdin){
        ProgressBar progressBar = new ProgressBar(10, 0);
        Student student = makeStudent(stdin, progressBar);
        StudentEssay essay = makeStudentEssay(stdin, progressBar);
        StudentApplication application = new StudentApplication(student, essay);
        FileIO.saveStudentApplication(application);
   }


    
    public Student makeStudent(Scanner stdin, ProgressBar progressBar){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.print(progressBar);
        System.out.println("");
        String name = Util.getSingleLine("Name: ", stdin, false);progressBar.increaseCurrent();
        Util.clearScreen();
        
        System.out.print(progressBar);System.out.println("");
        String email = Util.getSingleLine("Email: ", stdin, Util.getEmailRegex());progressBar.increaseCurrent();
        Util.clearScreen();
        
        System.out.print(progressBar);System.out.println("");
        String school = Util.getSingleLine("School you currently attend: ", stdin, false);progressBar.increaseCurrent();
        Util.clearScreen();
        
        System.out.print(progressBar);System.out.println("");
        System.out.println("~Are you a high school senior?~ \n~Have you been nominated?~ \n~Do you live in north Mississippi?~\n");
        String eligibility = Util.getConfirmation("Do you meet our eligibility requirements?  [y/n] ", stdin);progressBar.increaseCurrent();
        Util.clearScreen();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        if (eligibility.equals("n")){
            System.exit(0);
        }
        
        //next section
        System.out.print(progressBar);System.out.println("");
        String age = Util.getSingleLine("Age: ", stdin, Util.getAgeRegex());
        progressBar.increaseCurrent();
        Util.clearScreen();
        
        System.out.print(progressBar);System.out.println("");
        System.out.println("~In The Following Format 123-456-7890~");
        String phone = Util.getSingleLine("Phone Number: ", stdin, Util.getPhoneNumRegex());progressBar.increaseCurrent();
        Util.clearScreen();
        
        System.out.print(progressBar);System.out.println("");
        System.out.println("~In The Following Format MM-DD-YEAR~");
        String date = Util.getSingleLine("Expected Graduation Date: ", stdin, Util.getDateRegex());progressBar.increaseCurrent();
        Util.clearScreen();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        return new Student(name, email, school, age, phone, date);
    }
    public StudentEssay makeStudentEssay(Scanner stdin, ProgressBar progressBar){
        System.out.println("~For the Following Questions~\n~Type (END) on its own line~\n");
        
        System.out.print(progressBar);System.out.println("");
        String plan = Util.getMultiLines("What is your current plan for next year:  ", stdin);progressBar.increaseCurrent();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.print(progressBar);
        String aptitude = Util.getMultiLines("~Please Share a Specific example of~ \n~when you were a Strong problem solver~\n\nAptitude: ", stdin);progressBar.increaseCurrent();     
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.print(progressBar);
        String dedication = Util.getMultiLines("~Please Share a Specific example of~ \n~your Dedication & Work Ethic~\n\nDedication/ Work Ethic/ Heart: ", stdin);progressBar.increaseCurrent();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.print(progressBar);
        String passion =  Util.getMultiLines("~Please tell us about something you are~ \n~passionate about & worked hard to achieve~\n\nPassion/ Persistance: ", stdin);
        progressBar.increaseCurrent();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        return new StudentEssay(plan, aptitude, dedication, passion);
    }




}
