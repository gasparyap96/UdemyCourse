package udemycourse;

import java.util.EventObject;

public class FormEvent extends EventObject{
    
    private String name, occupation;
    
    public FormEvent(Object source) {
        super(source);
    }
    
    public FormEvent(Object source, String name, String occupation) {
        super(source);
        
        this.name = name;
        this.occupation = occupation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
    
}