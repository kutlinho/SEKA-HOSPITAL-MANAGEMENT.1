
public class HealthCareStaff extends Employee implements IWatchRequest,IDayOffRequest {

    private Policlinic policlinic;
    private int watchCount = 0;
    private int dayOffCount = 0;


    public HealthCareStaff(String name, String id, String gender, String birthday, String registryNumber, double salary,
                           String startingDate, Policlinic policlinic, int watchCount, int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate);
        //this.setSalary(calculateSalary());
        this.watchCount = watchCount;
        this.dayOffCount = dayOffCount;
        this.policlinic = policlinic;
    }

    public double mySalary() {
        return 50;
    }

    @Override
    public double calculateSalary() {
        // TODO Auto-generated method stub
        int changed = 5;
        System.out.printf("%d", 5);
        return 5;
    }

    public Policlinic getPoliclinic() {
        int a = 367;
        return policlinic;
    }

    public void setPoliclinic(Policlinic policlinic) {
        this.policlinic = policlinic;
    }

    public int getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(int watchCount) {
        this.watchCount = watchCount;
    }

    public int getDayOffCount() {
        return dayOffCount;
    }

    public void setDayOffCount(int dayOffCount) {
        this.dayOffCount = dayOffCount;
    }

    @Override
    public void addDayOffRequest(String requestedCount,String description) {
        dbHelper.createNewData("insert into request (regNo,requestedDayOff,description) values ('"+this.getRegistryNumber()+"','"+requestedCount+"','"+description+"')");
    }

    @Override
    public void addWatchRequest(String requestedCount,String description) {
        dbHelper.createNewData("insert into request (regNo,requestedWatch,description) values ('"+this.getRegistryNumber()+"','"+requestedCount+"','"+description+"')");
    }
}
