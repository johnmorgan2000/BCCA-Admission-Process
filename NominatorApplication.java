import java.util.*;
public class NominatorApplication {
    public NominatorInformation info;

    public void runEntireApp(Scanner stdin){
        ProgressBar progress = new ProgressBar(12, 0);
        NominatorInformation info =  makeNominatorInformation(stdin, progress);
        this.info = info;
        Nominee nominee = makeNominee(stdin, progress);
        Nomination nom = new Nomination(this.info, nominee);
        FileIO.saveNomination(nom);
    }

    public void runNomineeSection(Scanner stdin){
        ProgressBar progress = new ProgressBar(7, 0);
        Nominee nominee = makeNominee(stdin, progress);
        Nomination nom = new Nomination(info, nominee);
        FileIO.saveNomination(nom);

    }

    public NominatorInformation makeNominatorInformation(Scanner stdin, ProgressBar progress){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("-Information-\n");

        System.out.println(progress);
        String name = Util.getSingleLine("Name: ", stdin ,false);
        progress.increaseCurrent();
        Util.clearScreen();

        System.out.println(progress);
        String email = Util.getSingleLine("Email: ", stdin, Util.getEmailRegex());
        progress.increaseCurrent();
        Util.clearScreen();

        System.out.println(progress);
        String district = Util.getSingleLine("School District: ", stdin, true);
        progress.increaseCurrent();
        Util.clearScreen();

        System.out.println(progress);
        String position = Util.getSingleLine("Position: ", stdin, false);
        progress.increaseCurrent();
        Util.clearScreen();

        System.out.println(progress);
        String relationship = Util.getSingleLine("Relationship to Nominee: ", stdin, false);
        progress.increaseCurrent();
        
        Util.clearScreen();
        if (district.equals("")){
            return new NominatorInformation(email, name, position, relationship);
        }
        return new NominatorInformation(email, name, district, position, relationship);
    }


    public Nominee makeNominee(Scanner stdin, ProgressBar progress){
        System.out.println("\n-Nomminee-");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");

        System.out.println(progress);
        String name = Util.getSingleLine("Name: ", stdin, false);
        Util.clearScreen();
        progress.increaseCurrent();

        System.out.println(progress);
        int age = Integer.parseInt(Util.getSingleLine("Age: ", stdin, Util.getAgeRegex()));
        Util.clearScreen();
        progress.increaseCurrent();

        System.out.println(progress);
        System.out.println("~In The Following Format MM-DD-YEAR~");
        String date = Util.getSingleLine("Expected to Graduate: ", stdin, Util.getDateRegex());
        Util.clearScreen();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");;

        return new Nominee(name, age, date, makeQualification(stdin, progress));
    }

    public Qualification makeQualification(Scanner stdin, ProgressBar progress) {
        System.out.println("\n-Qualifications-");
        System.out.println("~When Done Type (END) on its own line~ \n");

        System.out.println(progress);
        String aptitudeQualifier = Util.getMultiLines("Aptitude:\t", stdin);
        progress.increaseCurrent();
        Util.clearScreen();

        System.out.println(progress); 
        String perseveranceQualifier = Util.getMultiLines("Perserverance:\t", stdin);
        progress.increaseCurrent();        
        Util.clearScreen();

        System.out.println(progress);  
        String dedicationQualifier = Util.getMultiLines("Dedication:\t", stdin);
        progress.increaseCurrent();
        Util.clearScreen();

        System.out.println(progress);
        String workEthicHeartQualifier = Util.getMultiLines("Work Ethic:\t", stdin);
        progress.increaseCurrent();
        Util.clearScreen();

        System.out.println(progress);
        String optionalQualifier = Util.getMultiLines("Anything else:\t", stdin);
        progress.increaseCurrent();
        System.out.println(progress);

        return new Qualification(aptitudeQualifier, 
                                perseveranceQualifier,         
                                dedicationQualifier, 
                                workEthicHeartQualifier, 
                                optionalQualifier);
        
    }
    public void setNominatorInformation (NominatorInformation nominfo){
        this.info = nominfo;
    }
}

