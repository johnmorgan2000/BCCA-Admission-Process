public class Qualification{
    public String aptitudeQualifier;
    public String perseveranceQualifier;
    public String dedicationQualifier;
    public String workEthicHeartQualifier;
    public String optionalQualifier;

    Qualification(String aptitudeQualifier, String perseveranceQualifier, String dedicationQualifier, String workEthicHeartQualifier, String optionalQualifier){
        this.aptitudeQualifier = aptitudeQualifier;
        this.perseveranceQualifier = perseveranceQualifier;
        this.dedicationQualifier = dedicationQualifier;
        this.workEthicHeartQualifier = workEthicHeartQualifier;
        this.optionalQualifier = optionalQualifier;
    }

    Qualification(String aptitudeQualifier, String perseveranceQualifier, String dedicationQualifier, String workEthicHeartQualifier){
        this.aptitudeQualifier = aptitudeQualifier;
        this.perseveranceQualifier = perseveranceQualifier;
        this.dedicationQualifier = dedicationQualifier;
        this.workEthicHeartQualifier = workEthicHeartQualifier;
    }

    public String toString(){
        String format;

        if (optionalQualifier.equals("")){
            format = "Aptitude\n%s\nPerserverance\n%s\nDedication\n%s\nWork Ethic\n%s\nAnything Else\n%s\n";
            return String.format(format, 
            aptitudeQualifier, 
            perseveranceQualifier, 
            dedicationQualifier,
            workEthicHeartQualifier, 
            optionalQualifier);
        }
        format = "Aptitude\n%s\nPerserverance\n%s\nDedication\n%s\nWork Ethic\n%s\n";
            return String.format(format, 
            aptitudeQualifier, 
            perseveranceQualifier, 
            dedicationQualifier,
            workEthicHeartQualifier
            );
    }

}
