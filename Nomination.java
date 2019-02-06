import java.io.Serializable;

public class Nomination implements Serializable{

    private NominatorInformation info;
    private Nominee nominee;    
    

    Nomination(NominatorInformation info, Nominee nominee){
        this.info = info;
        this.nominee = nominee;
        
    }


    public NominatorInformation getInfo(){
        return info;
    }

    public Nominee getNominee(){
        return nominee;
    }


}
