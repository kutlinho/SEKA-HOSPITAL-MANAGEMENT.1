import java.util.ArrayList;

public class Policlinic {
    private String policlinicName;
    private ArrayList<HealthCareStaff> healthCare = new ArrayList<HealthCareStaff>();
    private ArrayList<Location> locations = new ArrayList<Location>();

    public Policlinic(String policlinicName, ArrayList<HealthCareStaff> healthCare, ArrayList<Location> locations) {
        super();
        this.policlinicName = policlinicName;
        this.healthCare = healthCare;
        this.locations = locations;
    }
    public String getPoliclinicName() {
        return policlinicName;
    }
    public void setPoliclinicName(String policlinicName) {
        this.policlinicName = policlinicName;
    }
    public ArrayList<HealthCareStaff> getHealthCare() {
        return healthCare;
    }
    public void setHealthCare(ArrayList<HealthCareStaff> healthCare) {
        this.healthCare = healthCare;
    }
    public ArrayList<Location> getLocations() {
        return locations;
    }
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
}
