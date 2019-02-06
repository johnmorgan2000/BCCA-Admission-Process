import java.io.*;
import java.util.*;

public class FileIO {

    // public static void saveObject(Nomination o){
    //     File dir = new File("./saves/nominators");

    //     if (!dir.exists()){
    //         dir.mkdirs();
    //     }

    //     try{
    //         String nomEmailName = o.getInfo().email.split("@")[0];
    //         File file = new File(dir +"/"+ nomEmailName + ".ser");
    //         file.createNewFile(); 

    //         FileOutputStream fs = new FileOutputStream(file, true);
    //         ObjectOutputStream os = new ObjectOutputStream(fs);

    //         os.writeObject(o);
    //         os.close();

    //     }catch(Exception e){
    //         e.printStackTrace();
    //     }
    // }



    // public static ArrayList<Nomination> readFile(File file) {
    //     ArrayList<Nomination> nominations = new ArrayList<>();
    //      try {
    //         FileInputStream fis = new FileInputStream(file);
    //         ObjectInputStream ois = new ObjectInputStream(fis);
    //         while (true) {
    //             try{
    //                 Nomination nomination = (Nomination) ois.readObject();
    //                 nominations.add(nomination);
    //             }catch(IOException e){
    //                 e.printStackTrace();
    //                 ois.close();
    //                 break;
    //             }
    //         }

    //         ois.close();
    //         System.out.println(nominations);
    //         return nominations;
             

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }
        
    // }

        // public static ArrayList<Nomination> returnNominatorNominations(File file){
    //     try{
    //         FileInputStream fs = new FileInputStream(file);
    //         ObjectInputStream os = new ObjectInputStream(fs);
    //         ArrayList<Nomination> list =  (ArrayList<Nomination>) os.readObject();
    //         return list;
    //     }catch(Exception e){
    //         e.printStackTrace();
    //         return null;
    //     }
        
    // }


    // public static ArrayList<Nomination> readNominations(){
    //     File dir = new File("./saves/nominators/");
    //     File[] nomfiles = dir.listFiles();
    //     ArrayList<Nomination> nominators = new ArrayList<>();
        
        
        
    //     for (File file : nomfiles){
    //         ArrayList<Nomination> nominations = readFile(file);
    //         for (Nomination nomination: nominations){
    //             if (nomination != null){
    //                 nominators.add(nomination);
    //             }
    //         }
            
            
    //     }
    //     return nominators;  
    // }


}
