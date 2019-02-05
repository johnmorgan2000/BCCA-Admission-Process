import java.util.*;
import java.util.regex.Pattern;
public class Util {

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
            String line = stdin.nextLine();
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
}
