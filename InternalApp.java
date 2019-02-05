import java.util.ArrayList;

public class InternalApp {
    public static void main(String[] args){
        ArrayList<Nominator> noms =  FileIO.readNominators();
        for (Nominator nom : noms) {
            System.out.println(nom.getInfo());
            System.out.println(nom.getNominee());
            System.out.println(nom.getQualification());
        }
    }
}
