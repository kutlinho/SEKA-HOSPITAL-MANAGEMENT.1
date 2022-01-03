import java.util.ArrayList;

public class Practitioner extends Doctor{

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

}
