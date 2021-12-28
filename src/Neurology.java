import java.util.ArrayList;

public class Neurology extends Policlinic{
    public Neurology( String policlinicName, ArrayList<Location> locations) {
        super(policlinicName,locations);
    }
    public Neurology(String policlinicName){
        super(policlinicName);
    }
}