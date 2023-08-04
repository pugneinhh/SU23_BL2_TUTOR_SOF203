/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Phanh
 */
public class DBConnect {
     public static String Url = "jdbc:sqlserver://localhost:1433;databaseName=PTPM_FINALLY_JAVA_SOF203;encrypt=true;trustServerCertificate=true";
    public static String Username = "sa";
    public static String Pass = "123";

    static {
        try {          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public
            static Connection getConnection(){
        Connection cn = null;
        
           try {
               cn = DriverManager.getConnection(Url, Username, Pass);
           } catch (SQLException ex) {
              ex.printStackTrace();
           }
       
            
        
        return cn;
    }
    public static void main(String[] args) {
        Connection cn = getConnection();
        if(cn != null){
            System.out.println("Kết nối thành công!");
        } else{
            System.out.println("Lỗi kết nối");
        }
    }
}
