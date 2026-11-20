
package ni.edu.uam.serviciosweb.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import ni.edu.uam.serviciosweb.model.UsuarioP;
import ni.edu.uam.serviciosweb.service.UsuarioPService;

import java.util.List;

public class UsuarioPController {

    @FXML private TableView<UsuarioP> tblUsuariosP;

    @FXML private TableColumn<UsuarioP, Integer> colId;
    @FXML private TableColumn<UsuarioP, String> colNombre;
    @FXML private TableColumn<UsuarioP, String> colApellido;
    @FXML private TableColumn<UsuarioP, String> colCorreo;
    @FXML private TableColumn<UsuarioP, String> colTelefono;
    @FXML private TableColumn<UsuarioP, String> colFechaNacimiento;
    @FXML private TableColumn<UsuarioP, String> colPais;
    @FXML private TableColumn<UsuarioP, String> colCiudad;
    @FXML private TableColumn<UsuarioP, String> colDireccion;
    @FXML private TableColumn<UsuarioP, Double> colIngreso;
    @FXML private TableColumn<UsuarioP, Integer> colPuntaje;
    @FXML private TableColumn<UsuarioP, String> colDeuda;
    @FXML private TableColumn<UsuarioP, Double> colMontoDeuda;
    @FXML private TableColumn<UsuarioP, String> colEstado;

    @FXML private Label lblEstado;
    @FXML private Button btnConsultar;

    private final UsuarioPService servicio = new UsuarioPService();

    @FXML
    public void initialize() {
        configurarTableView();
    }

    private void configurarTableView() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colApellido.setCellValueFactory(
                new PropertyValueFactory<>("apellido"));

        colCorreo.setCellValueFactory(
                new PropertyValueFactory<>("correo"));

        colTelefono.setCellValueFactory(
                new PropertyValueFactory<>("telefono"));

        colFechaNacimiento.setCellValueFactory(
                new PropertyValueFactory<>("fechaNacimiento"));

        colPais.setCellValueFactory(
                new PropertyValueFactory<>("pais"));

        colCiudad.setCellValueFactory(
                new PropertyValueFactory<>("ciudad"));

        colDireccion.setCellValueFactory(
                new PropertyValueFactory<>("direccion"));

        colIngreso.setCellValueFactory(
                new PropertyValueFactory<>("ingresoAnual"));

        colPuntaje.setCellValueFactory(
                new PropertyValueFactory<>("puntajeCrediticio"));

        colDeuda.setCellValueFactory(datos ->
                new SimpleStringProperty(
                        datos.getValue().isTieneDeuda() ? "Sí" : "No"
                )
        );

        colMontoDeuda.setCellValueFactory(
                new PropertyValueFactory<>("montoDeuda"));

        colEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado"));
    }

    @FXML
    private void consultarUsuarios() {

        try {

            lblEstado.setText("Consultando usuarios...");

            List<UsuarioP> usuarios = servicio.obtenerUsuarios();

            tblUsuariosP.setItems(
                    FXCollections.observableArrayList(usuarios)
            );

            lblEstado.setText(
                    "Usuarios cargados: " + usuarios.size()
            );

        } catch (Exception ex) {

            lblEstado.setText("Error al consultar usuarios");

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText(
                    "No se pudieron obtener los usuarios: " + ex.getMessage()
            );
            alerta.showAndWait();

            ex.printStackTrace();
        }
    }
}
