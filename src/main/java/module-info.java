module ni.edu.uam.serviciosweb {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.serviciosweb to javafx.fxml;
    exports ni.edu.uam.serviciosweb;
}