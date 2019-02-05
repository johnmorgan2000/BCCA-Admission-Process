import java.util.*;

public class Util {

    public static String getSingleLine(String prompt, Scanner stdin) {
        System.out.print(prompt);
        String answer = stdin.nextLine();
        return answer;
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
}
