import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;
public class Util {

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
       }

    public static File emailToNominatorFile(String email){
        String fileName = email.split("@")[0];
        File file = new File("./saves/nominators/"+ fileName + ".ser");
        return file;
    }

    public static File emailToStudentAppFile(String email) {
        String fileName = email.split("@")[0];
        File file = new File("./saves/students/" + fileName + ".ser");
        return file;
    }

    public static String getSingleLine(String prompt, Scanner stdin, boolean isOptional) {
        if (isOptional){
            System.out.print(prompt);
            String answer = stdin.nextLine();
            return answer;
        }else{
           while(true){
            System.out.print(prompt);
            String answer = stdin.nextLine().trim();
            if (!answer.equals("")){
                return answer;
            }
        
        } 
        }
        
        
    }

    public static String getSingleLine(String prompt, Scanner stdin, String regex) {
        while(true){
            System.out.print(prompt);
            String answer = stdin.nextLine();
            if (Pattern.matches(regex, answer)){
                return answer;
            }
        }
    }
    

    public static String getMultiLines(String prompt, Scanner stdin){
        ArrayList<String> lines = new ArrayList<>();
        System.out.println(prompt);
        while (stdin.hasNextLine()) {
            String line = stdin.nextLine().trim();
            if (line.equals("END")){
                break;
            }
            lines.add(line);
        }
        return String.join("\n", lines);
    }

    public static String getEmailRegex(){
        return "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    }
    public static String getAgeRegex(){
        return "^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$";
    }
    public static String getDateRegex(){
        return "^\\d{2}-\\d{2}-\\d{4}$";
    }
    public static String getPhoneNumRegex(){
        return "^\\d{3}-\\d{3}-\\d{4}$";
    }
    
    public static String getConfirmation(String prompt, Scanner stdin) {

        while(true) {
            System.out.println(prompt);
            String answer = stdin.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                return answer;
            } 
            if (answer.equals("n")) {
                return answer;
            }
            System.out.println("Incorrect response. Please try again!");            
        }
        
    
    }
    
}
