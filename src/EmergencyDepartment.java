public class EmergencyDepartment extends Location{
    private Practitioner doctor;

    public EmergencyDepartment(String roomName, int floor, Policlinic policlinic) {
        super(roomName, floor, policlinic);
    }
}
