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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.OrganizacionModelo;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class OrganizacionController implements Initializable {

    @FXML
    private TextField txt_CodigoOrg;
    @FXML
    private TextField txt_NombreOrg;
    @FXML
    private TextField txt_DireccionOrg;
    @FXML
    private TextField txt_TelefonoOrg;
    @FXML
    private TextField txt_CorreoOrg;
    @FXML
    private Button btn_CrearOrg;
    @FXML
    private Button btn_modificarOrg;
    @FXML
    private Button btn_EstadoOrg;
    @FXML
    private ComboBox<String> cmb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearOrganizacion(ActionEvent event) {
        
        String codigoOrg, nombreOrg, direccionOrg, telefonoOrg, correoOrg, estado;
        int validacion = 0;
        
        OrganizacionModelo org = new OrganizacionModelo();
        
        codigoOrg = txt_CodigoOrg.getText().trim();
        nombreOrg = txt_NombreOrg.getText().trim();
        direccionOrg = txt_DireccionOrg.getText().trim();
        telefonoOrg = txt_TelefonoOrg.getText().trim();
        correoOrg = txt_CorreoOrg.getText().trim();
        estado = "A";
        
        if(codigoOrg.equalsIgnoreCase("")){
            validacion = 1;
        }
        if(nombreOrg.equalsIgnoreCase("")){
            validacion = 1;
        }
        if(direccionOrg.equalsIgnoreCase("")){
            validacion = 1;
        }
        if(telefonoOrg.equalsIgnoreCase("")){
            validacion = 1;
        }
        if(correoOrg.equalsIgnoreCase("")){
            validacion = 1;
        }
        
        if(validacion == 0){
            org.crear(codigoOrg, nombreOrg, direccionOrg, telefonoOrg, correoOrg, estado);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("Organización registrada con éxito.");
            alert.showAndWait();
            
        }else{
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Todos los campos son obligatorios.");
            alert.showAndWait();
            
        }
        
        txt_CodigoOrg.setText("");
        txt_NombreOrg.setText("");
        txt_DireccionOrg.setText("");
        txt_TelefonoOrg.setText("");
        txt_CorreoOrg.setText("");
        
    }

    @FXML
    private void modificarOrganizacion(ActionEvent event) {
    }

    @FXML
    private void habilitarOrganizacion(ActionEvent event) {
    }

    @FXML
    private void comboBoxEstado(ActionEvent event) {
    }
    
}
