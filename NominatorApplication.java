import java.util.*;
public class NominatorApplication {
    public static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args){
        
        NominatorInformation info =  makeNominatorInformation();
        Nominee nominee = makeNominee();
        System.out.print(nominee);

    }
    public static String getInfo(String prompt) {
        System.out.print(prompt);
        String answer = stdin.nextLine();
        return answer;
    }

    public static NominatorInformation makeNominatorInformation(){
        String name = getInfo("Name: ");
        String email = getInfo("Email: ");
        String district = getInfo("School District: ");
        String position = getInfo("Position: ");
        String relationship = getInfo("Relationship to Nominee: ");

        if (district.equals("")){
            return new NominatorInformation(name, email, position, relationship);
        }
        return new NominatorInformation(name, email, district, position, relationship);
    }


    public static Nominee makeNominee(){
        String name = getInfo("Name: ");
        int age = Integer.parseInt(getInfo("Age: "));
        String date = getInfo("Expected to Graduate: ");

        return new Nominee(name, age, date);
    }

}
