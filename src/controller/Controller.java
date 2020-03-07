package controller;

import gui.FormEvent;
import model.Person;
import model.Database;
import model.AgeCategory;
import model.EmploymentCategory;
import model.Gender;

public class Controller {
    
    Database db =new Database();
    
    public void addPerson(FormEvent e) {
        String name = e.getName();
        String occupation = e.getOccupation();
        int ageCatId = e.getAgeID();
        String empCat = e.getEmployment();
        boolean isUs = e.isCitizen();
        String taxId = e.getTaxId();
        String gender = e.getGender();
        
        //To handle age
        AgeCategory ageCategory = null;
        
        switch(ageCatId) {
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.elder;
                break;
        }
        
        //To handle employment
        EmploymentCategory employment = null;
        
        if(empCat == "employed") {
            employment = EmploymentCategory.employed;
        } else if(empCat == "self-employed") {
            employment = EmploymentCategory.self_employed;
        } else if(empCat == "unemployed") {
            employment = EmploymentCategory.unemployed;
        }
        
        //To handle gender
        Gender genderCat = null;
        
        if(gender == "male") {
            genderCat = Gender.male;
        } else if(gender == "female") {
            genderCat = Gender.female;
        }
        
        
        Person person = new Person(name, occupation, taxId , isUs,
                                    ageCategory, employment, genderCat);
        
        db.addPerson(person);
    }
}
