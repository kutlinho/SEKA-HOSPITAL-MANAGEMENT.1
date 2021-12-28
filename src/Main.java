import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Admin admin = new Admin("km","asd","asdfasd","asdfsadf","asdfdsaf",65498,"asdf");
        //admin.addEmployee();
        // ArrayList<String> asd=new ArrayList<String>(Arrays.asList("Samet","Kutluhan","Murat"));
        // for(String i: asd){
        //    System.out.println(i);
        // }

        DbHelper dbHelper = new DbHelper();
        Orthopedics orthopedics = new Orthopedics("Orthopedics");
      //  dbHelper.createNewData("insert into city (Name,CountryCode,District,Population) values ('Samet City','TUR','Smt','13690')");
      DoctorRoom doctorRoom = new DoctorRoom("11 nolu Doktor Odası",1,orthopedics,null);
      Specialist specialist = new Specialist("Doktor civanım","12345678952","Male","14.12.1982",
              "231654",15400,"321654",orthopedics,5,6);
       specialist.setDoctorRoom(doctorRoom);
      Admin admin = new Admin("Admin Kutlu","32165498712","Male","24.07.2001",
              "321654",12355,"28.12.2021");
     admin.addEmployee(specialist);
     // dbHelper.deleteData("healthcarestaff","ID","2");


    }
}
