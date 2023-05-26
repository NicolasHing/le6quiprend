module com.example.le6quiprend {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
            
    opens com.example.le6quiprend to javafx.fxml;
    exports com.example.le6quiprend;
}