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
        String client = "";
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

    public void answerRequest(Request request, boolean check) {
        HealthCareStaff hcs = request.getByWho(); // assignment made for reach the variable easier
        if (request instanceof DayOffRequest) { // Written for dayOffRequests
            ArrayList<ArrayList<String>> requestFromDb = dbHelper.selectData("request", "id,regNo,requestedDayOff,description", "regNo= " +
                    hcs.getRegistryNumber()); // taking the certain request from database to store its database id.
            if (check) {// If request is accepted from admin
                hcs.setDayOffCaount(hcs.getDayOffCount() + ((DayOffRequest) request).getDayOffCount()); // updating dayOffCount
                //hcs.setSalary(hcs.calculateSalary()); // Updating the salary due to change

                // Updating hcs' datas
                dbHelper.updateData("healthcarestaff", "salary", Double.toString(hcs.getSalary()), "regNo", hcs.getRegistryNumber());
                dbHelper.updateData("healthcarestaff", "dayOffCount", Integer.toString(hcs.getDayOffCount()), "regNo", hcs.getRegistryNumber());
            }
            // Deleting the request from db
            dbHelper.deleteData("request", "id", requestFromDb.get(0).get(0));

        } else if (request instanceof WatchRequest) { // Similar things for WatchRequest type requests
            ArrayList<ArrayList<String>> requestFromDb = dbHelper.selectData("request", "id,regNo,requestedWatchRequest,description", "regNo =" +
                    hcs.getRegistryNumber());

            if (check) {// If request is accepted from admin
                hcs.setWatchCount(hcs.getWatchCount() + ((WatchRequest) request).getWatchCount()); // updating watchCount
                //hcs.setSalary(hcs.calculateSalary()); // Updating the salary due to change

                // Updating hcs' datas
                dbHelper.updateData("healthcarestaff", "salary", Double.toString(hcs.getSalary()), "regNo", hcs.getRegistryNumber());
                dbHelper.updateData("healthcarestaff", "watchCount", Integer.toString(hcs.getWatchCount()), "regNo", hcs.getRegistryNumber());
            }
            // Deleting the request from db
            dbHelper.deleteData("request", "id", requestFromDb.get(0).get(0));

        } else { // Medicine request
            Medicine mdc = ((MedicineRequest) request).getMedicine();
            ArrayList<ArrayList<String>> requestedMed = dbHelper.selectData("medicine", "id,name,stock", "name=" + mdc.getMedName());
            String medId = requestedMed.get(0).get(0); // taking medicine id of certain medicine
            ArrayList<ArrayList<String>> requestFromDb = dbHelper.selectData("request", "id,regNo,requestedMedicineId,description",
                    "requestedMedicineId = " + medId); // taking certain request from db by its medicine id
            if (check) {// If request accepted, update the medicine stock
                dbHelper.updateData("medicine", "medStock", "10", "id", medId);
            }//Then delete the certain request from db
            dbHelper.deleteData("request", "requestedMedicineId", medId);
        }

    }

    public ArrayList<ArrayList> viewEmployee() {
        return dbHelper.selectData("healthcarestaff", "(personalId,regNo,name,gender,birthday," +
                "startingDate,salary,policlinic,dayOffCount,watchCount,doctorRoom)");
    }

    @Override
    public ArrayList<ArrayList> viewPatients() {
        return dbHelper.selectData("patient", "personalId,name,gender,birthday," +
                "height,weight,bloodGroup,medicinesId,diagnosisId,doctorsId,roomId");
    }

    //@Override
    //public void viewPatients() {
    // Yatan veya yatmayan tüm hastalar veritabanından çekilerek burada görüntülenecek.
    //}
}
