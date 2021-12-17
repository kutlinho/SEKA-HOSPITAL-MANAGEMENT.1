public abstract class Employee extends Person{
    private String registryNumber;
    private double salary;
    private String startingDate;

    public Employee(String name, String id, String gender, String birthday,String registryNumber,double salary,String startingDate) {
        super(name, id, gender, birthday);
        this.setRegistryNumber(registryNumber);
        this.setSalary(salary);
        this.setStartingDate(startingDate);
    }

    public abstract void calculateSalary();
    // Encapsulation fields
    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }
}
