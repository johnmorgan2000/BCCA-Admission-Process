import java.io.*;
import java.util.*;

public class FileIO {

    public static void saveObject(Nomination o){
        File dir = new File("./saves/nominators");

        if (!dir.exists()){
            dir.mkdirs();
        }

        try{
            String nomEmailName = o.getInfo().email.split("@")[0];
            File file = new File(dir +"/"+ nomEmailName + ".ser");
            file.createNewFile(); 

            FileOutputStream fs = new FileOutputStream(file, true);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(o);
            os.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // public static ArrayList<Nomination> returnNominatorNominations(File file){
    //     try{
    //         FileInputStream fs = new FileInputStream(file);
    //     OutputStream os = new FileOutputStream()
    //     }
        

    //     };
    // }


    public static ArrayList<Nomination> readNominations(){
        File dir = new File("./saves/nominators/");
        File[] nomfiles = dir.listFiles();
        ArrayList<Nomination> nominators = new ArrayList<>();
        
        
        
        for (File file : nomfiles){
            Nomination nominator = readFile(file);
            if (nominator != null){
                nominators.add(nominator);
            }
            
        }
        return nominators;  
    }

    public static Nomination readFile(File file) {
         try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
                Nomination nominator = (Nomination) ois.readObject();

            ois.close();
            return nominator;
             

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}
