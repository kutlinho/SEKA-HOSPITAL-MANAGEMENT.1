import java.util.ArrayList;

public class InternalMedicine extends Policlinic{
    public InternalMedicine( String policlinicName, ArrayList<Location> locations) {
        super(policlinicName,locations);
    }
    public InternalMedicine(String policlinicName){
        super(policlinicName);
    }}