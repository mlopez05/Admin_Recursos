/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    
    public static Connection conectar(){
        
        try{
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/admin_recursos", "appUser", "proyecto1234");
            return cn;
            
        }catch(SQLException e){
            
            System.out.println("Error en conexion " + e);
            
        }
        
        return (null);
    }
}
