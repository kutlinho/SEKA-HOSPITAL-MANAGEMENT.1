
public class Doctor extends HealthCareStaff implements IViewPatients{

    public Doctor(String name, String id, String gender, String birthday, String registryNumber, double salary,
                  String startingDate, Policlinic policlinic) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic);
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
    public void calculateSalary() {
        super.calculateSalary();
    }

    @Override
    public void viewPatients() {
        // TODO Auto-generated method stub

    }


}
