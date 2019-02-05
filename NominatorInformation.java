import java.io.Serializable;

public class NominatorInformation implements Serializable{
    String email;
    String name;
    String district;
    String position;
    String relationship;

    NominatorInformation(String email, String name, String district, String Position, String relationship){
        this.email = email;
        this.name = name;
        this.district = district;
        this.position = Position;
        this.relationship = relationship;
    }

    NominatorInformation(String email, String name,String Position, String relationship){
        this.email = email;
        this.name = name;
        this.position = Position;
        this.relationship = relationship;
    }
    
    public String toString() {
        if (district.equals("")) {
            return String.format("%s %s %s %s", email, name, position, relationship);
        }
        return String.format("%s %s %s %s %s", email, name, position, district, relationship);
    }
}
