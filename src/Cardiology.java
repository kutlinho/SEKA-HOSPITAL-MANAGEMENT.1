import java.util.ArrayList;

public class Cardiology extends Policlinic{

    public Cardiology( String policlinicName, ArrayList<Location> locations) {
        super(policlinicName,locations);
    }
    public Cardiology(String policlinicName){
        super(policlinicName);
    }

}
