import java.util.ArrayList;

public class Emergency extends Policlinic{

    public Emergency(String policlinicName, ArrayList<Location> locations) {
        super(policlinicName, locations);
    }
    public Emergency(String policlinicName) {
        super(policlinicName);
    }
}
