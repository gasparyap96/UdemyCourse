package udemycourse;

import java.util.EventObject;

public class FormEvent extends EventObject{
    
    private String name, occupation;
    private int ageId;
    
    public FormEvent(Object source) {
        super(source);
    }
    
    public FormEvent(Object source, String name, String occupation, int ageId) {
        super(source);
        
        this.name = name;
        this.occupation = occupation;
        this.ageId = ageId;
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
    
}
