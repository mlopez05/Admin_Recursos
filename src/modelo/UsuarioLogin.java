/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import javafx.scene.control.Alert;

/**
 *
 * @author USUARIO
 */
public class UsuarioLogin {
    
    public int login(String usuario, String contraseña){
        
        int estatus = 0;
        
        try{
            
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select nombre_usuario, estado from usuarios "
                    + "where nombre_usuario = '" + usuario + "' and contraseña = '" + contraseña + "'");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                String tipo = rs.getString("tipo_usuario");
                String estado = rs.getString("estado");
                
                if(tipo.equalsIgnoreCase("A") && estado.equalsIgnoreCase("A")){
                    estatus = 1;
                }else if(tipo.equalsIgnoreCase("U") && estado.equalsIgnoreCase("A")){
                    estatus = 2;
                }
            }else{
                estatus = -1;
            }
            
        }catch(SQLException e){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error al iniciar sesión, contacte al administrador.");
            alert.showAndWait();
        }
        
        return estatus;
        
    }
    
}
