import java.util.ArrayList;

public class Specialist extends Doctor{

    private DoctorRoom doctorRoom;

    public Specialist(String name, String id, String gender, String birthday, String registryNumber, double salary,
                      String startingDate, Policlinic policlinic,int watchCount,int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic, watchCount, dayOffCount);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    public DoctorRoom getDoctorRoom() {
        return doctorRoom;
    }

    public void setDoctorRoom(DoctorRoom doctorRoom) {
        this.doctorRoom = doctorRoom;
    }


}
