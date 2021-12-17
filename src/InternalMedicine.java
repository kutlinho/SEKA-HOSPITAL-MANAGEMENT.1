import java.util.ArrayList;

public class InternalMedicine extends Policlinic{
    public InternalMedicine(String policlinicName, ArrayList<HealthCareStaff> healthCare, ArrayList<Location> locations) {
        super(policlinicName, healthCare, locations);
    }
}