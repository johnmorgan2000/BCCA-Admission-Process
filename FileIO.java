import java.io.*;
import java.util.*;

public class FileIO{

    public static void saveNomination(Nomination nom){
        File dir = returnDirectory("./saves/nominators");
        String nomEmailName = nom.getInfo().email.split("@")[0];
        File file = new File(dir +"/"+ nomEmailName + ".ser");

        ArrayList<Nomination> noms = returnObjectArray(nom, file);
        noms.add(nom);
        saveArray(noms, file);

    }

    public static File returnDirectory(String path){
        File dir = new File(path);

        if (!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }

    public static ArrayList<Nomination> returnObjectArray(Nomination o, File file){
        ArrayList<Nomination> noms;
    
        if (file.exists()){
            noms = deserializeNominationArray(file);
        }
        else{
            noms = new ArrayList<>();
        }
        return noms;
    }

    public static ArrayList<Nomination> deserializeNominationArray(File file){
        try{
            FileInputStream fs = new FileInputStream(file);
            ObjectInputStream os = new ObjectInputStream(fs);
            ArrayList<Nomination> list =  (ArrayList<Nomination>) os.readObject();
            os.close();
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void saveArray(ArrayList<Nomination> list, File file){
        try{
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(list);
            os.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Nomination> readNominationFile(File file){
        try{
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Nomination> noms = (ArrayList<Nomination>) oi.readObject();
            oi.close();
            return noms;

        }catch(Exception e){
            System.out.println("Error reading file");
            return null;
        }
    }

    public static void saveStudentApplication(StudentApplication studentApp){
        File dir = returnDirectory("./saves/students");
        String email = studentApp.getStudent().email.split("@")[0];
        File file = new File(dir + "/" + email + ".ser");

        try{
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(studentApp);
            os.close();


        }catch(IOException e) {
            e.printStackTrace();
        }   
    }
    public static StudentApplication readStudentFile(File file) {
        
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            StudentApplication studentApp = (StudentApplication) oi.readObject();
            oi.close();
            return studentApp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }     
    
    public static ArrayList<Nomination> getAllNoms(){
        File nominationsFolder = new File("./saves/nominators");
        File[] nomFiles = nominationsFolder.listFiles();
        ArrayList<Nomination>  allNoms = new ArrayList<>();
        
        for (File nomFile : nomFiles){
            
            ArrayList<Nomination> noms = readNominationFile(nomFile);
            for(Nomination nom : noms){
                if(!nom.equals(null)){
                    allNoms.add(nom);
                }
                
            }
        }
        return allNoms;
    }

    public static ArrayList<StudentApplication> getAllStudentApplications(){
        File studentFolder = new File("./saves/students");
        File[] studentFiles = studentFolder.listFiles();
        ArrayList<StudentApplication> allStudents = new ArrayList<>();

        for (File file : studentFiles){
            StudentApplication student = readStudentFile(file);
            allStudents.add(student);
        }
        return allStudents;
    }

    public static ArrayList<EligibleStudent> getEligibleStudents(){
        ArrayList<Nomination> allNoms = getAllNoms();
        ArrayList<StudentApplication> allStudentApps = getAllStudentApplications();
        ArrayList<EligibleStudent> es = new ArrayList<>();

        for (StudentApplication studentApp : allStudentApps) {
            Student student = studentApp.getStudent();
            
            for (Nomination nom: allNoms) {
                Nominee nominee = nom.getNominee();
                if (student.name.equals(nominee.name)) {
                    es.add(new EligibleStudent(studentApp, nom));
                }
            }
        }
        return es;
    }
            
            

}

