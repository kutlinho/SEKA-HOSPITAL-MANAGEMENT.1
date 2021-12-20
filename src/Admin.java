import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin extends Employee implements IViewPatients {

    private ArrayList<HealthCareStaff> employees = new ArrayList<HealthCareStaff>();

    public Admin(String name, String id, String gender, String birthday, String registryNumber, double salary, String startingDate) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate);
    }

    @Override
    public void calculateSalary() {
        int a = 6;
    }

    public void addEmployee() {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
        //Policlinic policlinic  =new Policlinic("ortopedi",)
        // employees.add(new HealthCareStaff("kutlu meydan", "23654589", "Male",
        //        "24/07/2001", createId(), 10000, date));
    }
    public String createId(){
        String userId="NaN";
        String emploType="NaN"; // Şimdilik
        switch(emploType){
            case "Specialist":
                userId = "D1"+"589"; //589 textbox'tan alınacak.
                break;
            case "Practitioner":
                userId = "D2"+"589"; //589 textbox'tan alınacak.
                break;
            case "Nurse":
                userId = "N1"+"589"; //589 textbox'tan alınacak.
                break;
        }
        return userId;
    }

    public void answerRequest() {
        System.out.println("Kutluhan");
    }

    public void viewEmployee() {

    }

    @Override
    public void viewPatients() {

    }
}
