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
            return String.format("--Information--\nEmail: %s\nName: %s\nPosition: %s\nRelationship: %s\n", 
                                email, 
                                name, 
                                position, 
                                relationship);
        }
        return String.format("--Information--\nEmail: %s\nName: %s\nPosition: %s\nDistrict: %s\nRelationship: %s", 
                            email, 
                            name, 
                            position, 
                            district, 
                            relationship);
    }
}
