import java.util.ArrayList;
import java.io.File;
import java.util.*;

public class InternalApp {
    
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        
        StudentApplication studentapp = getSelectedStudent(stdin);
        ArrayList<Question> interviewQuestions = interviewProcess(stdin);
        FileIO.writeInterview(studentapp, interviewQuestions);
    }

    public static StudentApplication getSelectedStudent(Scanner stdin){
        ArrayList<EligibleStudent> es =  FileIO.getEligibleStudents();


        while(true){
            getStudentNames();
            String student = Util.getSingleLine("Student Name: ", stdin, false);
            if(student.equals("exit")){
                System.exit(0);
            }
            for (EligibleStudent e : es){
                if (isValidStudent(e, student)){
                    return e.getApplication();
                }
            }
        }
    }
    public static void getStudentNames(){
        ArrayList<EligibleStudent> es =  FileIO.getEligibleStudents();
        for (EligibleStudent e : es){
            System.out.println(e.getApplication().getStudent().name);
        }
    }

    public static boolean isValidStudent(EligibleStudent es, String input) {
        String studentName = es.getApplication().getStudent().name;
        return studentName.equals(input);
    } 

    public static ArrayList<Question> interviewProcess(Scanner stdin) {
        ArrayList<Question> interviewQuestions = new ArrayList<>();
        while(true) {
            String question = Util.getSingleLine("Q: ",stdin, false);
            String answer = Util.getMultiLines("A (Type [END] to finish the answer): ", stdin);
            interviewQuestions.add(new Question(question, answer));
            String confirmation = Util.getConfirmation("Continue the interview? [y/n] ", stdin);
            if (confirmation.equals("n")){break;}
        }
        return interviewQuestions;
    }
}
