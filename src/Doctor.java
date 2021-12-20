
public class Doctor extends HealthCareStaff implements IViewPatients{

    public Doctor(String name, String id, String gender, String birthday, String registryNumber, double salary,
                  String startingDate, Policlinic policlinic,int watchCount,int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic,watchCount,dayOffCount);
    }

    public void addDiagnosis() {

    }

    public void addMedicine() {

    }

    public void viewInpatients() {

    }

    public void makeInpatient() {

    }

    @Override
    public double calculateSalary() {
        return 1;
    }

    @Override
    public void viewPatients() {
        // TODO Auto-generated method stub

    }


}
