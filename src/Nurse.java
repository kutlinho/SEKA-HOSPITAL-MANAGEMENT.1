
public class Nurse extends HealthCareStaff implements IWatchRequest, IDayOffRequest, IMedicineRequest {

    public Nurse(String name, String id, String gender, String birthday, String registryNumber, double salary,
                 String startingDate, Policlinic policlinic,int watchCount, int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic, watchCount,  dayOffCount);
        // TODO Auto-generated constructor stub
    }

    public void dispense() {

    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    @Override
    public void addWatchRequest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addDayOffRequest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addMedicineRequest() {
        // TODO Auto-generated method stub

    }

}
