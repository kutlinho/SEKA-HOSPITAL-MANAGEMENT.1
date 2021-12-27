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
         dbHelper.createNewData("insert into city (Name,CountryCode,District,Population) values ('Samet City','TUR','Smt','13690')");
        //dbHelper.deleteData("city", "ID", "1");
        //dbHelper.updateData("city","Name","Yallah","ID","2");

//        ArrayList<ArrayList> cities = dbHelper.selectData("city","Name,CountryCode,Population");
//        for(ArrayList<String> a:cities){
//            for(String i:a){
//                System.out.print(i);
//                System.out.print("  ");
//            }
//            System.out.println();
//        }


    }
}
