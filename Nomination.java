import java.io.Serializable;

public class Nomination implements Serializable{
    private static final long serialVersionUID = -2779920603713771649L;
    private NominatorInformation info;
    private Nominee nominee;    
    

    Nomination(NominatorInformation info, Nominee nominee){
        this.info = info;
        this.nominee = nominee;
        
    }

    public String toString(){
        return String.format( "Nominator Info:\n%s\n\n%sNominee:\n", info, nominee);
    }


    public NominatorInformation getInfo(){
        return info;
    }

    public Nominee getNominee(){
        return nominee;
    }

    
}
