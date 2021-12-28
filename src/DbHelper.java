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

/*    public void createNewData(String table, String columns, String values) {
        String sql = "insert into " + table + " ( " + columns + " ) " + " values " + " (" + values + ") ";
        openConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Kayıt eklendi");
        } catch (SQLException e) {
            showErrorMessage(e);
        } finally {
            closeConnection();
        }
    }*/

    public void deleteData(String table, String client, String filter) {
        PreparedStatement statement = null;
        openConnection();
        try {
            String sql = "delete from " + table + " where " + client + " = " + filter;
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

    public void updateData(String table, String column, String value, String client, String filter) {
        PreparedStatement statement = null;
        openConnection();
        try {

            String sql = "update city set " + column + " = '" + value + "' where " + client + " = " + filter;
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

    public ArrayList<ArrayList> selectData(String table, String columns) {
        Statement statement = null;
        ResultSet resultSet;
        openConnection();
        String[] columns1 = columns.split(",");
        ArrayList<ArrayList> data = new ArrayList<ArrayList>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select " + columns + " from  " + table);
            //ArrayList<String> asd=new ArrayList<String>(Arrays.asList(""));

            while (resultSet.next()) {
                ArrayList<String> asd = new ArrayList<String>();
                for (String code : columns1) {
                    asd.add(resultSet.getString(code));

                }
                data.add(asd);
            }
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
        return data;

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
    public void createNewData(String client) {
        //String sql = "insert into " + table + " ("+columns+") "+ "values" + " (" + values + ") ";
        //String client=sql;
        //String sql1="insert into city (Name,CountryCode,District,Population) values ('Samet City','TUR','Smt','13690')";
        //System.out.println(sql+"\n"+sql1+"\n"+client);
        openConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(client);
            statement.executeUpdate();
            System.out.println("Kayıt eklendi");
        } catch (SQLException e) {
            showErrorMessage(e);
        } finally {
            closeConnection();
        }
    }
/*
    public void createNewData(String table, String columns, String values) { // burada patlıyor 1064
        String[] columns1 = columns.split(",");
        String[] valuesArray = values.split(",");
        String values1="";
        for(int i=0;i<columns1.length;i+=1){
            if(i==columns1.length-1){
                values1+="?";
            }
            else{
                values1+="?,";
            }
        }
        System.out.println( "values 1 "+values1);
        String sql = "insert into " + "city" + " ( " + "Name,CountryCode,District,Population" + " ) " + " values " + " ( " + "SametCity,SKA,Gazi,13690" + " ) ";
        //"city","Name,CountryCode,District,Population","Samet City,SKA,Gazi,13690"
        System.out.println("sql string "+ sql);
        for (String dta:valuesArray) {
            System.out.println(dta);
        }
        openConnection();
        try {
            //PreparedStatement statement = connection.prepareStatement(sql);
            Statement statement=connection.createStatement();
            int ctr=0;


            //for(int i=0;i<valuesArray.length;i++){
            //    statement.setString(i+1,valuesArray[i]);
            //}
            // "INSERT INTO city VALUES (SametCity,SKA,Gazi,13690) "
            statement.executeUpdate("INSERT INTO city (Name,CountryCode,District,Population) VALUES (yhg,SKA,Gazi,13690)");
            System.out.println("Kayıt eklendi");
        } catch (SQLException e) {
            showErrorMessage(e);
        } finally {
            closeConnection();
        }
    }*/

    public void createNewData(String table, String columns, String values) { // burada patlıyor 1064
        String[] columns1 = columns.split(",");
        String[] valuesArray = values.split(",");
        String values1="";
        for(int i=0;i<columns1.length;i+=1){
            if(i==columns1.length-1){
                values1+="?";
            }
            else{
                values1+="?,";
            }
        }
        System.out.println( "values 1 "+values1);
        String sql = "insert into " + table + " ( " + columns + " ) " + " values " + " ( " + values + " ) ";
        //"city","Name,CountryCode,District,Population","Samet City,SKA,Gazi,13690"
        System.out.println("sql string "+ sql);
        for (String dta:valuesArray) {
            System.out.println(dta);
        }
        openConnection();
        try {
            //PreparedStatement statement = connection.prepareStatement(sql);
            Statement statement=connection.createStatement();
            int ctr=0;


            //for(int i=0;i<valuesArray.length;i++){
            //    statement.setString(i+1,valuesArray[i]);
            //}
            // "INSERT INTO city VALUES (SametCity,SKA,Gazi,13690) "
            statement.executeUpdate(sql);
            System.out.println("Kayıt eklendi");
        } catch (SQLException e) {
            showErrorMessage(e);
        } finally {
            closeConnection();
        }
    }
}