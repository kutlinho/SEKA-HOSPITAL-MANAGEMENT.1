
public class Specialist extends Doctor implements IWatchRequest,IDayOffRequest{

    private DoctorRoom doctorRoom;

    public Specialist(String name, String id, String gender, String birthday, String registryNumber, double salary,
                      String startingDate, Policlinic policlinic) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void calculateSalary() {
        // TODO Auto-generated method stub
        super.calculateSalary();
    }

    public DoctorRoom getDoctorRoom() {
        return doctorRoom;
    }

    public void setDoctorRoom(DoctorRoom doctorRoom) {
        this.doctorRoom = doctorRoom;
    }

    @Override
    public void addWatchRequest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addDayOffRequest() {
        // TODO Auto-generated method stub

    }

}
