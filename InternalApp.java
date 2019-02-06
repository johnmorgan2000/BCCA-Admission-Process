import java.util.ArrayList;

public class InternalApp {
    public static void main(String[] args){
        ArrayList<Nomination> noms =  FileIO.readNominations();
        for (Nomination nom : noms) {
            System.out.println(nom.getInfo());
            System.out.println(nom.getNominee());
        }
    }
}
