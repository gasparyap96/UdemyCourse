package gui;

import java.util.EventObject;

public class FormEvent extends EventObject{
    
    private String name, occupation, empCat, taxId, gender;
    private int ageId;
    private boolean USCitizen;
    
    public FormEvent(Object source) {
        super(source);
    }
    
    public FormEvent(Object source, String name, String occupation, 
                     int ageId, String empCat, String taxId, boolean USCitizen, String gender) {
        super(source);
        
        this.name = name;
        this.occupation = occupation;
        this.ageId = ageId;
        this.empCat = empCat;
        this.taxId = taxId;
        this.USCitizen = USCitizen;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    public int getAgeID() {
        return ageId;
    }
    
    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
    
    public String getEmployment() {
        return empCat;
    }
    
    public String getTaxId() {
        return taxId;
    }
    
    public boolean isCitizen() {
        return USCitizen;
    }
    
    public String getGender() {
        return gender;
    }
}
