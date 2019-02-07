import java.util.Scanner;
public class ExternalApp{
    
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        chooseApplication(stdin);
    }

    public static void chooseApplication(Scanner stdin){
        System.out.println("What would your like to do?\n[1] Nominatate a student\n[2] Apply as a student\n");
        while(true){
            String response = Util.getSingleLine("Answer >>> ", stdin, false);
            if (response.equals("1")){
                NominatorApplication nomApp = new NominatorApplication();
                nomApp.run(stdin);
            }else if (response.equals("2")){
                StudentAppProgram studentApp = new StudentAppProgram();
                studentApp.run(stdin);
            }
        stdin.close();
        }
        
    }

}
