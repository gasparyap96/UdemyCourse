package model;

public class Person {
    
    //To count how many person register (Consturctor will have a count++
    //so everytime, the database will create a new table with different id
    private static int count = 0;
    private int id;
    
    private String name, occupation, taxId;
    private boolean USCitizen;
    private AgeCategory age;
    private EmploymentCategory employment;
    private Gender gender;
    
    //Constructor
    public Person(String name, String occupation, String taxId,
                   boolean USCitizen, AgeCategory age, EmploymentCategory employment,
                   Gender gender) {
        
        this.name = name;
        this.occupation = occupation;
        this.taxId = taxId;
        this.USCitizen = USCitizen;
        this.age = age;
        this.employment = employment;
        this.gender = gender;
        
        this.id = count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUSCitizen() {
        return USCitizen;
    }

    public void setUSCitizen(boolean USCitizen) {
        this.USCitizen = USCitizen;
    }

    public AgeCategory getAge() {
        return age;
    }

    public void setAge(AgeCategory age) {
        this.age = age;
    }

    public EmploymentCategory getEmployment() {
        return employment;
    }

    public void setEmployment(EmploymentCategory employment) {
        this.employment = employment;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    
}
