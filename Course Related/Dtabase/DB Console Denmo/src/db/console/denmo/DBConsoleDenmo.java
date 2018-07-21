package db.console.denmo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConsoleDenmo {
     private final String HOSTNAME = "localhost:3306" ;
     private final String DBNAME = "todolist" ;
     private final String USERNAME = "root" ;
     private final String PASSWORD = "" ;
     private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    public DBConsoleDenmo() {
        try{
        Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD) ;
            System.out.println("Connection OKAY");
            
            Statement statement = connection.createStatement() ;
            
            //inserting data 
          /*  String query = "insert into todotask values(4,'girl',1);";
            int row = statement.executeUpdate(query) ;
            System.out.println("Rows Affected"+row);   */
          
          //retrieving data
          String query = "select id, task from todotask;" ;
          ResultSet resultSet = statement.executeQuery(query) ;
          while(resultSet.next()){
              int NameId = resultSet.getInt("id") ;
              String taskName = resultSet.getString("task") ;
              System.out.println(NameId +" "+ taskName);
          }
        }
        catch(SQLException sqle){
            System.err.println(sqle);
        }
    }

    public static void main(String[] args) {
      new DBConsoleDenmo() ;
    }
    
}
