import java.sql.*;
import java.util.ArrayList;

public class Doctor extends HealthCareStaff implements IViewPatients {

    public Doctor(String name, String id, String gender, String birthday, String registryNumber, double salary,
                  String startingDate, Policlinic policlinic, int watchCount, int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic, watchCount, dayOffCount);
    }

    // function to add diagnosis to patient
    public void addDiagnosis(String personalId, String diagnosisId) throws SQLException {

        ArrayList<ArrayList> patientFromDB = dbHelper.selectData("patient", "id,diagnosisId", "personalId=" + personalId);
        String diagnosisFromDB = (String) patientFromDB.get(0).get(1);
        diagnosisFromDB = diagnosisFromDB + "-" + diagnosisId;
        dbHelper.updateData("patient", "diagnosisId", diagnosisFromDB, "id", (String) patientFromDB.get(0).get(0));
    }

    // function to add medicine to patient
    public void addMedicine(String personalId, String medicineId) throws SQLException {

        ArrayList<ArrayList> patientFromDB = dbHelper.selectData("patient", "id,medicinesId", "personalId=" + personalId);
        String medicinesFromDB = (String) patientFromDB.get(0).get(1);
        medicinesFromDB = medicinesFromDB + "-" + medicineId;
        dbHelper.updateData("patient", "medicinesId", medicinesFromDB, "id", (String) patientFromDB.get(0).get(0));

    }

    //function that checks for empty inpatient rooms in hospital
    public int giveRoomNumber() throws SQLException {

        ArrayList<ArrayList> emptyRoomsNo = dbHelper.selectData("inpatientroom", "id,isEmpty", "isEmpty=0");

        // if i is 51 it means there is no empty room in hospital because there are 50 room
        if (emptyRoomsNo.size() == 0) {
            return 0;
        }
        // if there is an empty room i is the number of the room
        else {
          return Integer.valueOf((String) emptyRoomsNo.get(0).get(0));
        }
    }

    // function to enroll the patient in the inpatient department
    public void makeInpatient(String personalId) throws SQLException {

        if (giveRoomNumber() != 0) {

            ArrayList<ArrayList> patientFromDB = dbHelper.selectData("patient", "id,roomId", "personalId=" + personalId);

            // to memorize the room number
            int roomNo = Integer.valueOf((String) patientFromDB.get(0).get(1));
            // checking is patient have a room and to place in the room if the patient does not have a room
            if (roomNo == 0) {

                dbHelper.updateData("patient", "roomId", Integer.toString(giveRoomNumber()), "id", (String) patientFromDB.get(0).get(0));
                dbHelper.updateData("inpatientroom", "isEmpty", "1", "id", Integer.toString(giveRoomNumber()));

            }
            // displays the information if the patient already has a room.
            else {
                System.out.println("Hasta zaten " + roomNo + " numaralı odada kalmaktadır");
            }
        }
        // If there is no empty room in the hospital, it displays the information.
        else {
            System.out.println("Yataklı hasta bölümünde boş yatak bulunmamaktadır.");
        }

    }

    // function to discharge the inpatient
    public void dischargeInpatient(String personalId) throws SQLException {

        ArrayList<ArrayList> patientFromDB = dbHelper.selectData("patient", "id,roomId", "personalId=" + personalId);

        // to memorize the room number
        int roomNo = Integer.valueOf((String) patientFromDB.get(0).get(1));
        // checking is patient have a room and to place in the room if the patient does not have a room
        if (roomNo != 0) {

            dbHelper.updateData("patient", "roomId", "0", "id", (String) patientFromDB.get(0).get(0));
            dbHelper.updateData("inpatientroom", "isEmpty", "0", "id", Integer.toString(roomNo));

        }
        // displays the information if the patient already has a room.
        else {
            System.out.println("Hasta zaten yatan hasta değildir");
        }
    }


    @Override
    public double calculateSalary() {
        return 1;
    }


    @Override
    public ArrayList<ArrayList> viewPatients() {
        return null;
    }
}
