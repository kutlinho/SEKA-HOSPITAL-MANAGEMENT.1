
public class Nurse extends HealthCareStaff implements IWatchRequest,IDayOffRequest,IMedicineRequest {

    public Nurse(String name, String id, String gender, String birthday, String registryNumber, double salary,
                 String startingDate, Policlinic policlinic) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic);
        // TODO Auto-generated constructor stub
    }

    public void dispense() {

    }

    @Override
    public void calculateSalary() {

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
