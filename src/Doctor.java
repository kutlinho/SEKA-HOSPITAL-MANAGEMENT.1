import java.sql.*;
import java.util.ArrayList;

public class Doctor extends HealthCareStaff implements IViewPatients {

    public Doctor(String name, String id, String gender, String birthday, String registryNumber, double salary,
                  String startingDate, Policlinic policlinic, int watchCount, int dayOffCount) {
        super(name, id, gender, birthday, registryNumber, salary, startingDate, policlinic, watchCount, dayOffCount);
    }

    DbHelper helper = new DbHelper();

    // function to add diagnosgis to patient
    public void addDiagnosis(String personalId, String diagnosisId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();

            //query for patient's diagnoses info in database
            String selectDB = "select diagnosisId from patient where personalId=?";
            statement = connection.prepareStatement(selectDB);
            statement.setString(1, personalId);
            resultSet = statement.executeQuery();

            //variable decleration to take data from database and merge it with new data
            String diagnosisIdDB = null;
            while (resultSet.next()) {
                diagnosisIdDB = resultSet.getString("diagnosisId");
            }
            diagnosisIdDB = diagnosisIdDB + "-" + diagnosisId;

            //update patient's diagnoses data
            String updateDB = "update patient set diagnosisId =? where personalId=?";
            statement = connection.prepareStatement(updateDB);
            statement.setString(1, diagnosisIdDB);
            statement.setString(2, personalId);
            statement.executeUpdate();

            System.out.println("Hastalık eklendi");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    // function to add medicine to patient
    public void addMedicine(String personalId, String medicineId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();

            //query for patient's medicines info
            String selectDB = "select medicinesId from patient where personalId=?";
            String updateDB = "update patient set medicinesId =? where personalId=?";
            statement = connection.prepareStatement(selectDB);
            statement.setString(1, personalId);
            resultSet = statement.executeQuery();

            //variable decleration to take data from database and merge it with new data
            String medicinesIdDB = null;
            while (resultSet.next()) {
                medicinesIdDB = resultSet.getString("medicinesId");
            }
            medicinesIdDB = medicinesIdDB + "-" + medicineId;

            //update patient's medicines data
            statement = connection.prepareStatement(updateDB);
            statement.setString(1, medicinesIdDB);
            statement.setString(2, personalId);
            statement.executeUpdate();

            System.out.println("İlaç eklendi");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    //function that checks for empty inpatient rooms in hospital
    public int giveRoomNumber() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;

        // variable that will keep empty room in memory
        int i = 1;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();

            // query to take info about inpatient rooms
            String sql = "select id,isEmpty from inpatientroom";
            resultSet = statement.executeQuery(sql);

            int roomNo = -1;
            // variable decleration to detect which room is empty
            while (resultSet.next()) {
                roomNo = resultSet.getInt("isEmpty");
                if (roomNo == 0) {
                    break;
                } else {
                    i++;
                }
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

        // if i is 51 it means there is no empty room in hospital because there are 50 room
        if (i == 51) {
            return 0;
        }
        // if there is an empty room i is the number of the room
        else {
            return i;
        }
    }

    // function to enroll the patient in the inpatient department
    public void makeInpatient(String personalId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = helper.getConnection();
            //checking if all rooms are full
            if (giveRoomNumber() != 0) {

                // query to check whether the patient has a room
                String control = "select roomId from patient where personalId=?";
                statement = connection.prepareStatement(control);
                statement.setString(1, personalId);
                resultSet = statement.executeQuery();

                // to memorize the room number
                int roomNo = 0;
                while (resultSet.next()) {
                    roomNo = resultSet.getInt("roomId");
                }

                // checking is patient have a room and to place in the room if the patient does not have a room
                if (roomNo == 0) {

                    //updating inpatient room data in database
                    String updateDB = "update inpatientroom set isEmpty =1 where id=?";
                    statement = connection.prepareStatement(updateDB);
                    statement.setInt(1, giveRoomNumber());
                    statement.executeUpdate();

                    // updating patient data in database
                    String updatepatientDB = "update patient set roomId =? where personalId=?";
                    statement = connection.prepareStatement(updatepatientDB);
                    statement.setInt(1, giveRoomNumber());
                    statement.setString(2, personalId);
                    statement.executeUpdate();
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
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    // function to discharge the inpatient
    public void dischargeInpatient(String personalId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = helper.getConnection();
            // query for taking the patient's room number information from the database
            String control = "select roomId from patient where personalId=?";
            statement = connection.prepareStatement(control);
            statement.setString(1, personalId);
            resultSet = statement.executeQuery();

            // variable decleration to memorize the patient's room
            int roomNo = 0;
            while (resultSet.next()) {
                roomNo = resultSet.getInt("roomId");
            }

            // if the patient is not registered as an inpatient
            if (roomNo != 0) {
                // emptying the room that is already full in the database
                String updateDB = "update inpatientroom set isEmpty =0 where id=?";
                statement = connection.prepareStatement(updateDB);
                statement.setInt(1, giveRoomNumber());
                statement.executeUpdate();

                // deleting the patient's room number in the database
                String updatepatientDB = "update patient set roomId =? where personalId=?";
                statement = connection.prepareStatement(updatepatientDB);
                statement.setInt(1, 0);
                statement.setString(2, personalId);
                statement.executeUpdate();

                System.out.println("Hasta taburcu edildi");
            }
            // displaying information if the patient is not already an inpatient
            else {
                System.out.println("Hasta, yatan hasta bölümünde bulunmamaktadır");
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
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
