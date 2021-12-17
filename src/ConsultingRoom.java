public class ConsultingRoom extends Location{
    private Practitioner doctor;

    public ConsultingRoom(String roomName, int floor, Policlinic policlinic, Practitioner doctor) {
        super(roomName, floor, policlinic);
        this.doctor = doctor;
    }
}
