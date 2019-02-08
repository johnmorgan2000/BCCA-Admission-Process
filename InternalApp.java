import java.util.ArrayList;
import java.io.File;
import java.util.*;

public class InternalApp {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        while (true) {
            String response = chooseApplication(stdin);
            if (response.equals("1")) {
                ArrayList<Nomination> noms = getSearchNominators(stdin);
                showNominators(noms);
            } else if (response.equals("2")) {
                runInterview(stdin);
            } else if (response.equals("3")) {
                System.exit(0);
            }
        }

    }

    public static String chooseApplication(Scanner stdin) {
        System.out.println("[1] Search nominator by email\n[2] Search eligible students by name\n[3] Exit Application");
        while (true) {
            String response = Util.getSingleLine("Answer >>> ", stdin, false);
            if (response.equals("1") || response.equals("2") || response.equals("3")) {
                return response;
            }
        }

    }

    public static void runInterview(Scanner stdin) {
        StudentApplication studentapp = getSelectedStudent(stdin);
        System.out.println(studentapp);
        
        
        String response = Util.getConfirmation("Would you like to conduct the interview? [y/n]: ", stdin);
        if (response.equals("y")){
            ArrayList<Question> interviewQuestions = interviewProcess(stdin);
            FileIO.writeInterview(studentapp, interviewQuestions);
        
    }
}

    public static StudentApplication getSelectedStudent(Scanner stdin) {
        ArrayList<EligibleStudent> es = FileIO.getEligibleStudents();

        while (true) {
            getStudentNames();
            String student = Util.getSingleLine("Student Name: ", stdin, false);
            if (student.equals("exit")) {
                System.exit(0);
            }
            for (EligibleStudent e : es) {
                if (isValidStudent(e, student)) {
                    return e.getApplication();
                }
            }
        }
    }

    public static void getStudentNames() {
        ArrayList<EligibleStudent> es = FileIO.getEligibleStudents();
        for (EligibleStudent e : es) {
            System.out.println(e.getApplication().getStudent().name);
        }
    }

    public static boolean isValidStudent(EligibleStudent es, String input) {
        String studentName = es.getApplication().getStudent().name;
        return studentName.equals(input);
    }

    public static ArrayList<Question> interviewProcess(Scanner stdin) {
        ArrayList<Question> interviewQuestions = new ArrayList<>();
        while (true) {
            String question = Util.getSingleLine("Q: ", stdin, false);
            String answer = Util.getMultiLines("A (Type [END] to finish the answer): ", stdin);
            interviewQuestions.add(new Question(question, answer));
            String confirmation = Util.getConfirmation("Continue the interview? [y/n] ", stdin);
            if (confirmation.equals("n")) {
                break;
            }
        }
        return interviewQuestions;
    }

    public static ArrayList<Nomination>  getSearchNominators (Scanner stdin) {
        ArrayList<Nomination> allNominations = FileIO.getAllNoms();
        ArrayList<Nomination> collectedNominations = new ArrayList<>();
        boolean isValidEmail = false;
        
        while (!isValidEmail){
            String input = Util.getSingleLine("Type a Nominator Email or type [exit] to go back: ", stdin, false);
            if (input.trim().toLowerCase().equals("exit")) {
                Util.clearScreen();
                break;
            }
            input = input.split("@")[0];
            for (Nomination nom : allNominations) {
                String email = nom.getInfo().email.split("@")[0];
                if (email.equals(input)){
                    collectedNominations.add(nom);
                    isValidEmail = true;
                }
            }
        }
        return collectedNominations;
    }

    public static void showNominators(ArrayList<Nomination> noms) {
        if (!noms.isEmpty()) {
            System.out.println(noms.get(0).getInfo());
                for(Nomination nom : noms){
                    System.out.println(nom.getNominee());
                }
        }
    }
    }
