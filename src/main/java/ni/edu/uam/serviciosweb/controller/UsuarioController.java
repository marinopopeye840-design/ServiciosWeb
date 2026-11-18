package ni.edu.uam.serviciosweb.controller;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ni.edu.uam.serviciosweb.model.Usuario;
import ni.edu.uam.serviciosweb.service.UsuarioService;

import java.util.List;

public class UsuarioController {
    @FXML
    private TableView<Usuario> tblUsuarios;
    @FXML
    private TableColumn<Usuario, Integer> colId;
    @FXML
    private TableColumn<Usuario, String> colNombre;
    @FXML
    private TableColumn<Usuario, String> colUsername;
    @FXML
    private TableColumn<Usuario, String> colEmail;
    @FXML
    private TableColumn<Usuario, String> colTelefono;
    @FXML
    private TableColumn<Usuario, String> colCiudad;
    @FXML
    private TableColumn<Usuario, String> colEmpresa;

    @FXML private Button btnConsultar;
    @FXML private Label lblEstado;
    private final UsuarioService service = new UsuarioService();

    @FXML
    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
    }

    @FXML
    private void consultarUsuarios(){
        Task<List<Usuario>> task = new Task<List<Usuario>>() {
            @Override
            protected List<Usuario> call() throws Exception {
                return service.obtenerUsuarios();
            }
        };

        btnConsultar.disableProperty().bind(task.runningProperty());
        lblEstado.setText("Consultando API REST..........");
        // En caso de que el resultado haya sido exitoso
        task.setOnSucceeded(e -> {
            List<Usuario> usuarios = task.getValue();
            tblUsuarios.setItems(FXCollections.observableArrayList(usuarios));
            lblEstado.setText("Usuarios encontrados:");
        } );
        // En caso de error
        task.setOnFailed(e -> {
            Throwable error = task.getException();
            lblEstado.setText(error.getMessage());
        });
        Thread hilo = new Thread(task);
        hilo.setDaemon(true);
        hilo.start();
    }
}