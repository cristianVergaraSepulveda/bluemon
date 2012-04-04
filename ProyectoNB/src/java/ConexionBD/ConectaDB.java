package ConexionBD;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConectaDB {
       /*
        //SQL SERVER
        private String	driver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String 	url= "jdbc:sqlserver://localhost:1433;databaseName=agora";
	private String 	login= "usuarioturismo";
	private String 	password= "1234567";
      
          SQL SERVER CON DSN */
	/*
        private String	driver= "sun.jdbc.odbc.JdbcOdbcDriver";
	private String 	url= "jdbc:odbc:dsnturismo";
	private String 	login= "usuarioturismo";
	private String 	password= "1234567";*/
	
	/*POSTGRES
	private String	driver= "org.postgresql.Driver";
	private String 	url= "jdbc:postgresql://localhost:5432/translima";
	private String 	login= "postgres";
	private String 	password= "postgres";*/
	
	
	 //SQLMYSQL
	private String	driver= "com.mysql.jdbc.Driver";
	private String 	url= "jdbc:mysql://190.164.211.99:3306/monitoreo";       //192.168.150.224
	private String 	login= "cris";
	private String 	password= "cris";
	
	/*ORACLE
	private String	driver= "oracle.jdbc.driver.OracleDriver";
	private String 	url= "jdbc:oracle:thin:@localhost:1521:oraculo";
	private String 	login= "hr";
	private String 	password= "hr";
	*/
       
    // Retorna la connection. Caso contrario, null si no a sido posible.
    public Connection getConnection() {
    Connection cn= null;
        
        try{
            Class.forName(driver).newInstance();
            cn= DriverManager.getConnection(url, login, password);
            
        } catch(SQLException e) {
            System.out.println(e.toString());
            cn= null;
        } catch(Exception e) {
            System.out.println(e.toString());
            cn= null;
        }
        
        return cn;
    }
}

