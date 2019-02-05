import java.io.Serializable;

public class Nominator implements Serializable{

    private NominatorInformation info;
    private Nominee nominee;
    private Qualification qualification;         

    Nominator(NominatorInformation info, Nominee nominee, Qualification qualification){
        this.info = info;
        this.nominee = nominee;
        this.qualification = qualification;
    }


    public NominatorInformation getInfo(){
        return info;
    }

    public Nominee getNominee(){
        return nominee;
    }

    public Qualification getQualification(){
        return qualification;
    }    
}
