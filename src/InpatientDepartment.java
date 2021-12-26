import java.util.ArrayList;

public class InpatientDepartment extends Location {

    private ArrayList<InpatientRoom> inpatientRooms = new ArrayList<InpatientRoom>();

    public InpatientDepartment(String roomName, int floor, Policlinic policlinic,ArrayList<InpatientRoom> inpatientRooms) {
        super(roomName, floor, policlinic);
        this.inpatientRooms = inpatientRooms;
    }

    public ArrayList<InpatientRoom> getInpatientRooms() {
        return inpatientRooms;
    }

    public void setInpatientRooms(ArrayList<InpatientRoom> inpatientRooms) {
        this.inpatientRooms = inpatientRooms;
    }
}
