/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarecomendación;

/**
 *
 * @author usuario
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Connect to SQL Server, execute a SELECT query, print the results.
*
*/  
public class SqlServerConnection
{
  //The SQL Server JDBC Driver is in 
  //C:\Program Files\Microsoft JDBC Driver 6.0 for SQL Server\sqljdbc_6.0\enu\auth\x64
  private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  
  //The JDBC connection URL which allows for Windows authentication is defined below.
  private static final String jdbcURL = "jdbc:sqlserver://localhost:1433;databasename=SistemaDeRecomendacion;integratedSecurity=true;";
  //To make Windows authentication work we have to set the path to sqljdbc_auth.dll at the command line
  
  /**
  * main method.
  *
  * @param  args  command line arguments
  */  
  public static void main(String[] args)
  {
    System.out.println("Program started");
    try
    {
       Class.forName(jdbcDriver).newInstance();
       System.out.println("JDBC driver loaded");
    }
    catch (Exception err)
    {
       System.err.println("Error loading JDBC driver");
       err.printStackTrace(System.err);
       System.exit(0);
    }
    
    Connection databaseConnection= null;
    try
    {
      //Connect to the database
      databaseConnection = DriverManager.getConnection(jdbcURL);
      //databaseConnection = DriverManager.getConnection("jdbc:odbc:SistemaRecomendacion","sa","orchid");
      System.out.println("Connected to the database");
    
      //declare the statement object
      Statement sqlStatement = databaseConnection.createStatement();

      //declare the result set    
      ResultSet rs = null;
  
      //Build the query string, making sure to use column aliases
      String queryString="select PersonID as [Id],";
      queryString+="LastName as [Last Name],";
      queryString+="FirstName as [First Name],";
      queryString+="Address as [Address],";
      queryString+="City as [City]";
      queryString+="from Persons;";

      //print the query string to the screen
      System.out.println("\nQuery string:");
      System.out.println(queryString);
      
      //execute the query
      rs=sqlStatement.executeQuery(queryString);
      
      //print a header row
      System.out.println("\nId\t|\tLast Name\t|\tFirst Name");
      System.out.println("----------------------\t|\t----------------\t|\t------------");
      
      //loop through the result set and call method to print the result set row
      while (rs.next())
      {
        printResultSetRow(rs);
      }    
      
      //close the result set
      rs.close();
      System.out.println("Closing database connection");

      //close the database connection
      databaseConnection.close();
    }
    catch (SQLException err)
    {
       System.err.println("Error connecting to the database");
       err.printStackTrace(System.err);
       System.exit(0);
    }
    System.out.println("Program finished");
  }
  
  
  
  
  
  /**
  * Prints each row in the ResultSet object to the screen.
  *
  * @param  rs  the result set from the SELECT query
  * @throws SQLException SQLException thrown on error
  */  
  public static void printResultSetRow(ResultSet rs) throws SQLException
  {
    //Use the column name alias as specified in the above query
    String OrganizationName= rs.getString("Id");
    String ParentOrganizationName= rs.getString("Last Name");
    String CurrencyName= rs.getString("First Name");
    System.out.println(ParentOrganizationName+"\t|\t"+ OrganizationName + "\t|\t" + CurrencyName);  
  }
}
