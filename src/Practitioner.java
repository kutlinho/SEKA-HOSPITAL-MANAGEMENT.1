
public class Practitioner extends Doctor implements IWatchRequest,IDayOffRequest{

    public Practitioner(String name, String id, String gender, String birthday, String registryNumber, double salary,
                        String startingDate, Policlinic policlinic,int watchCount,int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic, watchCount, dayOffCount);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double calculateSalary() {
        // TODO Auto-generated method stub
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



}
