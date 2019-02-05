import java.util.*;
public class NominatorApplication {
    public static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args){
        
        NominatorInformation info =  makeNominatorInformation();
        Nominee nominee = makeNominee();
        Qualification qualification = makeQualification();
        

    }

    public static NominatorInformation makeNominatorInformation(){
        String name = Util.getSingleLine("Name: ", stdin);
        String email = Util.getSingleLine("Email: ", stdin);
        String district = Util.getSingleLine("School District: ", stdin);
        String position = Util.getSingleLine("Position: ", stdin);
        String relationship = Util.getSingleLine("Relationship to Nominee: ", stdin);

        if (district.equals("")){
            return new NominatorInformation(name, email, position, relationship);
        }
        return new NominatorInformation(name, email, district, position, relationship);
    }


    public static Nominee makeNominee(){
        String name = Util.getSingleLine("Name: ", stdin);
        int age = Integer.parseInt(Util.getSingleLine("Age: ", stdin));
        String date = Util.getSingleLine("Expected to Graduate: ", stdin);

        return new Nominee(name, age, date);
    }

    public static Qualification makeQualification() {
        String aptitudeQualifier = Util.getMultiLines("Aptitude:", stdin);
        String perseveranceQualifier = Util.getMultiLines("Perserverance:", stdin);
        String dedicationQualifier = Util.getMultiLines("Dedication:", stdin);
        String workEthicHeartQualifier = Util.getMultiLines("Work Ethic:", stdin);
        String optionalQualifier = Util.getMultiLines("Anything else:", stdin);

        return new Qualification(aptitudeQualifier, 
                                perseveranceQualifier,         
                                dedicationQualifier, 
                                workEthicHeartQualifier, 
                                optionalQualifier);
        
    }
}

