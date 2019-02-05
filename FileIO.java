import java.io.*;
import java.util.*;

public class FileIO {

    public static void saveObject(Nominator o){
        File dir = new File("./saves/nominators");

        if (!dir.exists()){
            dir.mkdirs();
        }

        try{
            String nomEmailName = o.getInfo().email.split("@")[0];
            File file = new File(dir +"/"+ nomEmailName + ".ser");
            file.createNewFile(); 

            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(o);
            os.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<Nominator> readNominators(){
        File dir = new File("./saves/nominators/");
        File[] nomfiles = dir.listFiles();
        ArrayList<Nominator> nominators = new ArrayList<>();
        
        
        for (File file : nomfiles){
            Nominator nominator = readFile(file);
            if (nominator != null){
                nominators.add(nominator);
            }
            
        }
        return nominators;  
    }

    public static Nominator readFile(File file) {
         try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Nominator nominator = (Nominator) ois.readObject();
            ois.close();
            return nominator;
             

        } catch (Exception e) {
            return null;
        }
        
    }

}
