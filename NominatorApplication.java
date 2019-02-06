import java.util.*;
public class NominatorApplication {
    public static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args){
        
        NominatorInformation info =  makeNominatorInformation();
        Nominee nominee = makeNominee();
        Nomination nom = new Nomination(info, nominee);
        // FileIO.saveObject(nom);


    }

    public static NominatorInformation makeNominatorInformation(){
        System.out.println("-Information-\n");

        System.out.println("[0/12] COMPLETED");String name = Util.getSingleLine("Name: ", stdin ,false);
        System.out.println("");
        System.out.println("[1/12] COMPLETED");String email = Util.getSingleLine("Email: ", stdin, Util.getEmailRegex());
        System.out.println("");
        System.out.println("[2/12] COMPLETED");String district = Util.getSingleLine("School District: ", stdin, true);
        System.out.println("");
        System.out.println("[3/12] COMPLETED");String position = Util.getSingleLine("Position: ", stdin, false);
        System.out.println("");
        System.out.println("[4/12] COMPLETED");String relationship = Util.getSingleLine("Relationship to Nominee: ", stdin, false);
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (district.equals("")){
            return new NominatorInformation(email, name, position, relationship);
        }
        return new NominatorInformation(email, name, district, position, relationship);
    }


    public static Nominee makeNominee(){
        System.out.println("\n-Nomminee-");
        System.out.println("[5/12] COMPLETED");String name = Util.getSingleLine("Name: ", stdin, false);
        System.out.println("");
        System.out.println("[6/12] COMPLETED");int age = Integer.parseInt(Util.getSingleLine("Age: ", stdin, false));
        System.out.println("");
        System.out.println("[7/12] COMPLETED");String date = Util.getSingleLine("Expected to Graduate: ", stdin, false);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return new Nominee(name, age, date, makeQualification());
    }

    public static Qualification makeQualification() {
        System.out.println("\n-Qualifications-");
        System.out.println("~When Done Type (END) on its own line~ \n");
        System.out.println("[8/12] COMPLETED");String aptitudeQualifier = Util.getMultiLines("Aptitude:\t", stdin);
        System.out.println("");
        System.out.println("[9/12] COMPLETED");String perseveranceQualifier = Util.getMultiLines("Perserverance:\t", stdin);
        System.out.println("");
        System.out.println("[10/12] COMPLETED");String dedicationQualifier = Util.getMultiLines("Dedication:\t", stdin);
        System.out.println("");
        System.out.println("[11/12] COMPLETED");String workEthicHeartQualifier = Util.getMultiLines("Work Ethic:\t", stdin);
        System.out.println("");
        String optionalQualifier = Util.getMultiLines("Anything else:\t", stdin);
        System.out.println("[12/12] COMPLETED");
        return new Qualification(aptitudeQualifier, 
                                perseveranceQualifier,         
                                dedicationQualifier, 
                                workEthicHeartQualifier, 
                                optionalQualifier);
        
    }
}

