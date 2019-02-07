import java.util.Scanner;
public class ExternalApp{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        while(true){
            String application = chooseApplication(stdin);

            if (application.equals("1")){
                NominatorApplication nomApp = new NominatorApplication();
                nomApp.runEntireApp(stdin);
                electAnotherNominee(stdin, nomApp);
            }else if (application.equals("2")){
                StudentAppProgram studentApp = new StudentAppProgram();
                studentApp.run(stdin);
            }else if (application.equals("3")){
                stdin.close();
                System.exit(0);
            }
        }
    }

    public static void electAnotherNominee(Scanner stdin, NominatorApplication nomApp){
        while(true){
            String response = Util.getConfirmation("Would you like to elect another student? [y/n]: ", stdin);
            if (response.equals("y")){
                nomApp.runNomineeSection(stdin);
            }else{
                break;
            }
        }
    }

    public static String chooseApplication(Scanner stdin){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("What would you like to do?\n[1] Nominatate a student\n[2] Apply as a student\n[3] Exit\n");
        while(true){
            String response = Util.getSingleLine("Answer >>> ", stdin, false);
            if (response.equals("1") || response.equals("2") || response.equals("3")){
                return response;
            }
        }
    }

}
