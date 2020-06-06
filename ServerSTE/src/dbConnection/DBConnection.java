/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Stefan
 */
public class DBConnection {
   private String driver;
    private String url;
    private String user;
    private String password;
   
    private Connection connection;
    
    private static DBConnection instance;
    
    private DBConnection() throws Exception{
        
        try {
            driver="com.mysql.jdbc.Driver";
            url="jdbc:mysql://localhost:3306/seminarskips";
            user="root";
            password="";
            
            connection=DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            System.out.println("Uspesna konekcija sa bazom!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Neuspesna konekcija sa bazom!\n"+ex.getMessage());
        }
        
    }
    
    public static DBConnection getInstance() throws Exception{
        if(instance==null){
            instance=new DBConnection();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
     
}
