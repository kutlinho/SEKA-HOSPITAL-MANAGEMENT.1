public class Admin extends Employee implements IViewPatients {


    public Admin(String name, String id, String gender, String birthday, String registryNumber, double salary, String startingDate) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate);
    }

    @Override
    public void calculateSalary() {
        int a = 6;
    }

    public void addEmployee() {

    }

    public void answerRequest() {
        System.out.println("My second change.");

        int km=5;
    }

    public void viewEmployee() {

    }

    @Override
    public void viewPatients() {

    }
}
