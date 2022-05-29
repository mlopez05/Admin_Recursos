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
            "select nombre_usuario, estado, tipo_usuario from usuarios where nombre_usuario = '" + usuario + "' and contraseña = '" + contraseña + "'");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                String tipo = rs.getString("tipo_usuario");
                String estado = rs.getString("estado");
                int valor = 0;
                
                if(tipo.equalsIgnoreCase("A") && estado.equalsIgnoreCase("A")){
                    valor = 1;
                }else if(tipo.equalsIgnoreCase("U") && estado.equalsIgnoreCase("A")){
                    valor = 2;
                }
                
                estatus = valor;
        
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
