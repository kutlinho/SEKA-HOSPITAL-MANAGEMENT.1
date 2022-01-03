import java.util.ArrayList;

public class Nurse extends HealthCareStaff implements  IMedicineRequest {

    public Nurse(String name, String id, String gender, String birthday, String registryNumber, double salary,
                 String startingDate, Policlinic policlinic, int watchCount, int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic, watchCount, dayOffCount);
        // TODO Auto-generated constructor stub
    }

    public void dispense(Medicine medicine) {
    medicine.setMedStock(medicine.getMedStock()-1);
    dbHelper.updateData("medicine","stock",Integer.toString(medicine.getMedStock()),"name", medicine.getMedName());
    }

    @Override
    public double calculateSalary() {
        return 0;
    }



    @Override
    public void addMedicineRequest(MedicineRequest medReq) {
        ArrayList<ArrayList> medFromDb = dbHelper.selectData("medicine","id,name","name ="+medReq.getMedicine().getMedName());
        dbHelper.createNewData("insert into request (regNo,requestedDayOff,requestedWatch,requestedMedicineId,description) " +
                "values "+"'"+this.getRegistryNumber()+"',"+"'0',"+"'0',"+"'"+(String) medFromDb.get(0).get(0)+"',"+"'"+medReq.getExplanation()+"'");
    }

}
