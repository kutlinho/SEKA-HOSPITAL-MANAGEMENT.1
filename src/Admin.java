import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin extends Employee implements IViewPatients {

    private ArrayList<HealthCareStaff> employees = new ArrayList<HealthCareStaff>();
    private ArrayList<Location> locations = new ArrayList<Location>(); // Şimdilik

    public Admin(String name, String id, String gender, String birthday, String registryNumber, double salary, String startingDate) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate);
    }

    @Override
    public double calculateSalary() {
        return 15000;
    }

    public void addEmployee() {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
        Policlinic policlinic = new Policlinic("ortopedi", locations);
        Employee a = new HealthCareStaff("kutlu meydan", "23654589", "Male",
                "24/07/2001", createRN(), 10000, date, policlinic, 2, 3);// Textbox'tan alınacak.
    }

    public String createRN() {
        String userId = "NaN";
        String emploType = "NaN"; // Şimdilik
        switch (emploType) {
            case "Specialist":
                userId = "D1" + "589"; //589 textbox'tan alınacak.
                break;
            case "Practitioner":
                userId = "D2" + "589"; //589 textbox'tan alınacak.
                break;
            case "Nurse":
                userId = "N1" + "589"; //589 textbox'tan alınacak.
                break;
        }
        return userId;
    }

    public void answerRequest() {
    // Çalışanların talepleri bu fonksiyon içerisinde cevaplanacak.
    }

    public void viewEmployee() {
        // Tüm çalışanlar burada görüntülenecek.
        // Veritabanından çalışanlar bilgileriyle burada görüntülenecek.
    }

    @Override
    public void viewPatients() {
      // Yatan veya yatmayan tüm hastalar veritabanından çekilerek burada görüntülenecek.
    }
}
