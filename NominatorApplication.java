import java.util.*;
public class NominatorApplication {
    public static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args){
        
        NominatorInformation info =  makeNominatorInformation();
        Nominee nominee = makeNominee();
        Nomination nom = new Nomination(info, nominee);
        FileIO.saveObject(nom);


    }

    public static NominatorInformation makeNominatorInformation(){
        System.out.println("-Information-\n");

        String name = Util.getSingleLine("Name: ", stdin, false);
        String email = Util.getSingleLine("Email: ", stdin, Util.getEmailRegex());
        String district = Util.getSingleLine("School District: ", stdin, true);
        String position = Util.getSingleLine("Position: ", stdin, false);
        String relationship = Util.getSingleLine("Relationship to Nominee: ", stdin, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (district.equals("")){
            return new NominatorInformation(email, name, position, relationship);
        }
        return new NominatorInformation(email, name, district, position, relationship);
    }


    public static Nominee makeNominee(){
        System.out.println("\n-Nomminee-");
        String name = Util.getSingleLine("Name: ", stdin, false);
        int age = Integer.parseInt(Util.getSingleLine("Age: ", stdin, false));
        String date = Util.getSingleLine("Expected to Graduate: ", stdin, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return new Nominee(name, age, date, makeQualification());
    }

    public static Qualification makeQualification() {
        System.out.println("\n-Qualifications-");
        System.out.println("~When Done Type (END) on its own line~ \n");
        String aptitudeQualifier = Util.getMultiLines("Aptitude:\t", stdin);
        System.out.println("");
        String perseveranceQualifier = Util.getMultiLines("Perserverance:\t", stdin);
        System.out.println("");
        String dedicationQualifier = Util.getMultiLines("Dedication:\t", stdin);
        System.out.println("");
        String workEthicHeartQualifier = Util.getMultiLines("Work Ethic:\t", stdin);
        System.out.println("");
        String optionalQualifier = Util.getMultiLines("Anything else:\t", stdin);

        return new Qualification(aptitudeQualifier, 
                                perseveranceQualifier,         
                                dedicationQualifier, 
                                workEthicHeartQualifier, 
                                optionalQualifier);
        
    }
}

