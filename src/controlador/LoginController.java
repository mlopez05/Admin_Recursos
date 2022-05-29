/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
                
                if(state == 1){
                    
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaAdministrador.fxml"));
                        Parent root = loader.load();
                        
                        VistaAdministradorController controladorAdmin = loader.getController();
                        
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                 
                }else if(state == -1){
                
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
