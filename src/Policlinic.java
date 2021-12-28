import java.util.ArrayList;

public class Policlinic {
    private String policlinicName;
    private ArrayList<Location> locations = new ArrayList<Location>();

    public Policlinic(String policlinicName,  ArrayList<Location> locations) {

        this.policlinicName = policlinicName;
        this.locations = locations;
    }
    public Policlinic(String policlinicName){
        this.policlinicName = policlinicName;
    }
    public String getPoliclinicName() {
        return policlinicName;
    }
    public void setPoliclinicName(String policlinicName) {
        this.policlinicName = policlinicName;
    }
    public ArrayList<Location> getLocations() {
        return locations;
    }
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
}
