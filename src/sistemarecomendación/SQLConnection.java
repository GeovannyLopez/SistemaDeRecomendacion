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
import java.util.ArrayList;
import java.util.List;

/**
* Connect to SQL Server, execute a SELECT query, print the results.
*
*/  
public class SQLConnection {
    //The SQL Server JDBC Driver is in 
    //C:\Program Files\Microsoft JDBC Driver 6.0 for SQL Server\sqljdbc_6.0\enu\auth\x64
    private String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  
    //The JDBC connection URL which allows for Windows authentication is defined below.
    private String jdbcURL = "jdbc:sqlserver://localhost:1433;databasename=SistemaDeRecomendacion;integratedSecurity=true;";
    //To make Windows authentication work we have to set the path to sqljdbc_auth.dll at the command line
    
    private Connection databaseConnection= null;
    
    public SQLConnection()
    {
        System.out.println("Start connection to DataBase");
        try
        {
           Class.forName(jdbcDriver).newInstance();
           System.out.println("JDBC driver loaded");
        }
        catch (Exception err)
        {
           System.err.println("Error loading JDBC driver");
           err.printStackTrace(System.err);
        }

        try
        {
          //Connect to the database
          databaseConnection = DriverManager.getConnection(jdbcURL);
          System.out.println("Connected to the database");
        }
        catch(Exception err)
        {
            System.err.println("Error loading JDBC driver");
            err.printStackTrace(System.err);            
        }
    }
    
    public ArrayList<ArrayList<String>> ExecuteReaderQuery(String queryString, List<String> Output)
    {
        try
        {
            ArrayList<ArrayList<String>> Result = new ArrayList<ArrayList<String>>();
            //declare the statement object
            Statement sqlStatement = databaseConnection.createStatement();

            //declare the result set    
            ResultSet rs = null;
            
            //execute the query
            rs=sqlStatement.executeQuery(queryString);
            
            ArrayList aux;
            //loop through the result set and call method to print the result set row
            while (rs.next())
            {
                aux = new ArrayList<String>();
                for (int i = 0; i < Output.size(); i++) {
                    aux.add(rs.getString(Output.get(i)));
                }
                Result.add(aux);
            }    
      
            //close the result set
            rs.close();
            return Result;
            
        }catch(Exception err)
        {
            System.err.println("Error executing query");
            err.printStackTrace(System.err);  
        }
        return null;
    }
    
    public Movie GenerarMovie(String Id) throws SQLException
    {
        Statement sqlStatement = databaseConnection.createStatement();
        Movie movie = new Movie();
        movie.Generos = new ArrayList<Integer>();
        movie.Id = Integer.parseInt(Id);
        String queryString = "SELECT "+
                            "Tipo [Tipo], Nombre [Nombre], " +
                            "Director [Director], Link [Link], " +
                            "Punteo [Punteo], NumRating [NumRating], " +
                            "Anio [Anio], Duracion [Duracion], Pais[Pais], " + 
                            "Idioma [Idioma], Clasificacion [Clasificacion], " +
                            "Actor1 [Actor1], Actor2 [Actor2], Actor3 [Actor3], " +
                            "LikesFb [LikesFb], " +
                            "(Punteo/2+5*(1-POWER((2.71828),-NumRating/1000000)))  [Ponderacion]" + 
                            "FROM MOVIE WHERE IDMOVIE = " + Id +";"; 
        //declare the result set    
        ResultSet rs = null;
        
            //execute the query
        rs=sqlStatement.executeQuery(queryString);
        while (rs.next())
        {
            movie.Tipo = rs.getString("Tipo");
            movie.Nombre = rs.getString("Nombre");
            movie.Director = rs.getString("Director");
            movie.Link = rs.getString("Link");
            movie.Punteo  = Double.parseDouble(rs.getString("Punteo"));
            movie.NumRating = Integer.parseInt(rs.getString("NumRating"));
            movie.Anio = Integer.parseInt(rs.getString("Anio"));
            movie.Duracion = Integer.parseInt(rs.getString("Duracion"));
            movie.Pais = rs.getString("Pais");
            movie.Idioma = rs.getString("Idioma");
            movie.Clasificacion = rs.getString("Clasificacion");
            movie.Ponderacion = Double.parseDouble(rs.getString("Ponderacion"));
            
            movie.Actores = new ArrayList<String>();
            movie.Actores.add(rs.getString("Actor1"));
            movie.Actores.add(rs.getString("Actor2"));
            movie.Actores.add(rs.getString("Actor3"));
            movie.LikesFB = Integer.parseInt(rs.getString("LikesFb"));
        }
        queryString = "SELECT IDGENERO [IDGENERO] "+
                       "FROM MOVIEGENERO WHERE IDMOVIE = " + Id +";"; 
        rs=sqlStatement.executeQuery(queryString);
        while (rs.next())
        {
            movie.Generos.add(Integer.parseInt(rs.getString("IDGENERO")));
        }
        
        return movie;
    }
    
    public ArrayList<String> GetMovieIds(List<Integer> Gustados) throws SQLException
    {
        ArrayList<String> Ids = new ArrayList<String>();
        String aux = "";
        Statement sqlStatement = databaseConnection.createStatement();
        String queryString = "SELECT IdMovie [IdMovie] FROM MOVIE "// +
                            //" WHERE IdMovie != " + Id + ";"
                ;
        
        ResultSet rs = null;
        
        //execute the query
        rs=sqlStatement.executeQuery(queryString);
        while (rs.next())
        {
            aux = rs.getString("IdMovie");
            //Si vamos a permitir hacer comparaciones con otros que ya esten en la lista pues se omite el if
            //if (!Gustados.contains(Integer.parseInt(aux))) {
                Ids.add(aux);
            //}
        }
        return Ids;
    }
}
