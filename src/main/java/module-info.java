module ni.edu.uam.serviciosweb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens ni.edu.uam.serviciosweb to javafx.fxml;
    exports ni.edu.uam.serviciosweb;
}