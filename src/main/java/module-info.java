
module ni.edu.uam.serviciosweb {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens ni.edu.uam.serviciosweb to javafx.fxml;
    opens ni.edu.uam.serviciosweb.controller to javafx.fxml;
    opens ni.edu.uam.serviciosweb.model to com.fasterxml.jackson.databind, javafx.base;

    exports ni.edu.uam.serviciosweb;
}
