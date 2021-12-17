import java.util.ArrayList;

public class InpatientDepartment extends Location {
    private Nurse nurse;
    private ArrayList<Patient> inpatients = new ArrayList<Patient>();
    private ArrayList<Bed> beds = new ArrayList<Bed>();

    public InpatientDepartment(String roomName, int floor, Policlinic policlinic,
                               Nurse nurse, ArrayList<Patient> inpatients,ArrayList<Bed> beds) {
        super(roomName, floor, policlinic);
        this.setNurse(nurse);
        this.setInpatients(inpatients);
        this.setBeds(beds);
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public ArrayList<Patient> getInpatients() {
        return inpatients;
    }

    public void setInpatients(ArrayList<Patient> inpatients) {
        this.inpatients = inpatients;
    }

    public ArrayList<Bed> getBeds() {
        return beds;
    }

    public void setBeds(ArrayList<Bed> beds) {
        this.beds = beds;
    }
}
