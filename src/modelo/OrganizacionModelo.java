/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author USUARIO
 */
public class OrganizacionModelo extends Modelo {
    
    @Override
    public void crear(String codigo, String nombre, String direccion, String telefono, String correo, String estado){
        
        try{
            
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into organizaciones values (?,?,?,?,?,?)");
            
            pst.setString(1, codigo);
            pst.setString(2, nombre);
            pst.setString(3, direccion);
            pst.setString(4, telefono);
            pst.setString(5, correo);
            pst.setString(6, estado);
            
            pst.executeQuery();
            
            cn.close();
            
        }catch(SQLException e){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error al iniciar sesión, contacte al administrador.");
            alert.showAndWait();
            
        }
        
    }
    
}
