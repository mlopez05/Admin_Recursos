/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelo.UsuarioLogin;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class LoginController implements Initializable {
    
    UsuarioLogin model = new UsuarioLogin();

    @FXML
    private TextField txt_usuario;
    @FXML
    private TextField txt_contraseña;
    @FXML
    private Button btn_inicio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciar(ActionEvent event) {
        
        Object evt = event.getSource();
        
        if(evt.equals(btn_inicio)){
            
            if(!txt_usuario.getText().isEmpty() && !txt_contraseña.getText().isEmpty()){
                
                String usuario = txt_usuario.getText().trim();
                String contraseña = txt_contraseña.getText().trim();
                
                int state = model.login(usuario, contraseña);
                
                if(state != -1){
                    if(state == 1){
                        
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Bienvenido.");
                alert.showAndWait();
                        
                        
                    }else if(state == 2){
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Usuario Local.");
                alert.showAndWait();
                        
                    }
                }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Datos incorrectos.");
                alert.showAndWait();
                    
                }
                
            }else{
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Los campos son obligatorios.");
                alert.showAndWait();
                
            }
        }
    }

    @FXML
    private void validar(KeyEvent event) {
        
        Object evt = event.getSource();
        
        if(evt.equals(txt_usuario)){
            
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
            
        }else if(evt.equals(txt_contraseña)){
            
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
            
        }
    }
    
}
