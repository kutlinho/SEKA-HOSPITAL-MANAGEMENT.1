public class Admin extends Employee implements IViewPatients {


    public Admin(String name, String id, String gender, String birthday, String registryNumber, double salary, String startingDate) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate);
    }

    @Override
    public void calculateSalary() {
        int a = 6;
    }

    public void addEmployee() {
        System.out.println("Kutluhan made this.");
    }

    public void answerRequest() {

    }

    public void viewEmployee() {

    }

    @Override
    public void viewPatients() {

    }
}
