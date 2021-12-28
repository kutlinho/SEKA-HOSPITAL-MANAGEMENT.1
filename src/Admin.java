import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Admin extends Employee implements IViewPatients {

    private ArrayList<HealthCareStaff> employees = new ArrayList<HealthCareStaff>();
    private ArrayList<Location> locations = new ArrayList<Location>(); // Şimdilik
    private ArrayList<Request> waitingRequest = new ArrayList<Request>();


    public Admin(String name, String id, String gender, String birthday, String registryNumber, double salary, String startingDate) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate);
    }

    @Override
    public double calculateSalary() {
        return 15000;
    }

    public void addEmployee(HealthCareStaff hcs) { // Person, poliklinik adı , maaşı , izin ve nöbet günü parametre olarak alsın.
        // poliklinik adını veritabanını sorgulayıp poliklinik bilgilerini çektikten sonra o polikliniği new'leyelim.
        // new healthcarestaff'a parametre olarak gönderelim.

        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
        String s = Double.toString(hcs.getSalary());
        String client ="";
        String doc = Integer.toString(hcs.getDayOffCount());
        String wc = Integer.toString(hcs.getWatchCount());
        if (hcs instanceof Specialist) {
             client = "insert into healthcarestaff (personalId,regNo,name,gender,birthday," +
                    "startingDate,salary,policlinic,dayOffCount,watchCount,doctorRoom) values (" + " ' " +
                    hcs.getId() + " ', " + " ' " + createRN(hcs) + " ', " + " ' " + hcs.getName() + " ', " + " ' " + hcs.getGender() + " ', " +
                    " ' " + hcs.getBirthday() + " ', " + " ' " + hcs.getStartingDate() + " ', " + " ' " + s + "', "
                    + " ' " + hcs.getPoliclinic().getPoliclinicName() + " ', " + " ' " + doc + " ', " + " ' " +
                    wc + " ', " + " ' " + ((Specialist) hcs).getDoctorRoom().getRoomName() + " ' " + ")";

        } else {
             client = "insert into healthcarestaff (personalId,regNo,name,gender,birthday," +
                    "startingDate,salary,policlinic,dayOffCount,watchCount,doctorRoom) values (" + " ' " +
                    hcs.getId() + " ', " + " ' " + createRN(hcs) + " ', " + " ' " + hcs.getName() + " ', " + " ' " + hcs.getGender() + " ', " +
                    " ' " + hcs.getBirthday() + " ', " + " ' " + hcs.getStartingDate() + " ', " + " ' " + s + " ', "
                    + " ' " + hcs.getPoliclinic().getPoliclinicName() + " ', " + " ' " + doc + " ', " +
                    wc + ",null)";

        }
        dbHelper.createNewData(client);
    }

    public String createRN(Employee employee) { // id ve çalışan tipini parametre olarak alsın.
        String userId = "NaN";
        String emploType = "NaN";
        if (employee instanceof Specialist) {
            emploType = "D1";
        } else if (employee instanceof Practitioner) {
            emploType = "D2";
        } else {
            emploType = "N1";
        }
        userId = emploType + employee.getId().substring(employee.getId().length() - 3);
        return userId;
    }

    public void answerRequest() {
    }

    public void viewEmployee() {

    }

    @Override
    public ArrayList<ArrayList> viewPatients() {
       return dbHelper.selectData("patient","personalId,name,gender,birthday," +
                "height,weight,bloodGroup,medicinesId,diagnosisId,doctorsId,roomId");
    }

    //@Override
    //public void viewPatients() {
        // Yatan veya yatmayan tüm hastalar veritabanından çekilerek burada görüntülenecek.
    //}
}
