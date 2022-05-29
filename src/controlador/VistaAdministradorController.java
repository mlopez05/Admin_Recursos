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
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class VistaAdministradorController implements Initializable {

    @FXML
    private Button btn_Organizaciones;
    @FXML
    private Button btn_Usuarios;
    @FXML
    private Button btn_Recursos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gestionarOrganizaciones(ActionEvent event) {
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Organizacion.fxml"));
                        Parent root = loader.load();
                        
                        OrganizacionController organizacion = loader.getController();
                        
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
    }

    @FXML
    private void gestionarUsuarios(ActionEvent event) {
    }

    @FXML
    private void gestionarRecursos(ActionEvent event) {
    }
    
}
