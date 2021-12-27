import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DbHelper {
    private String username = "root";
    private String password = "Kutluhan.18";
    private String dbUrl = "jdbc:mysql://localhost:3306/world";
    Connection connection = null;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public void openConnection() {
        try {
            connection = getConnection();
        } catch (SQLException exception) {
            showErrorMessage(exception);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            showErrorMessage(exception);
        }
    }

    public void createNewData(String table, String columns, String values) {
        String sql = "insert into " + table + " ( " + columns + " ) " + " values " + " ( " + values + " ) ";
        openConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            showErrorMessage(e);
        } finally {
            closeConnection();
        }
    }

    public void deleteData(String table, String client,String filter){
        PreparedStatement  statement = null;
        openConnection();
        try {
            String sql = "delete from "+table+" where "+client+" = "+filter;
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(); // returns "... rows affected"
            System.out.println("Kayıt silindi");

        } catch (SQLException exception) {
            showErrorMessage(exception);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                showErrorMessage(e);
            }
            closeConnection();
        }
    }

    public void updateData(String table,String column,String value,String client,String filter){
        PreparedStatement statement = null;
        openConnection();
        try {

            String sql = "update city set " +column+ " = "+value+" where "+client+" = "+filter;
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi");

        } catch (SQLException exception) {
            showErrorMessage(exception);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                showErrorMessage(e);
            }
            closeConnection();
        }
    }

    public void selectData(String table,String columns){
        Statement statement = null;
        ResultSet resultSet;
        openConnection();
        String[] columns1 = columns.split(",");
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select "+columns +" from  "+table);
            //ArrayList<String> asd=new ArrayList<String>(Arrays.asList(""));
            ArrayList<ArrayList> data = new ArrayList<ArrayList>();
            while (resultSet.next()) {
                ArrayList<String> asd = new ArrayList<String>();
               for(String code:columns1){
                   asd.add(resultSet.getString(code));

               }
                data.add(asd);
            }
        }catch (SQLException exception){
            showErrorMessage(exception);
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                showErrorMessage(e);
            }
            closeConnection();
        }
    }
    //resultSet.getString("Code"),
    //       resultSet.getString("Name"),
    //     resultSet.getString("Continent"),
    //   resultSet.getString("Region")}
    //


    public void showErrorMessage(SQLException e) {
        System.out.println("Error : " + e.getMessage());
        System.out.println("Error Code : " + e.getErrorCode());
    }
}