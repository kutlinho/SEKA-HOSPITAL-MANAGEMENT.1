public class DoctorRoom extends Location{
    private Specialist doctor;

    public DoctorRoom(String roomName, int floor, Policlinic policlinic, Specialist doctor) {
        super(roomName, floor, policlinic);
        this.setDoctor(doctor);
    }

    public Specialist getDoctor() {
        return doctor;
    }

    public void setDoctor(Specialist doctor) {
        this.doctor = doctor;
    }
}
