package weatherGui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class Controller implements Initializable {

    @FXML 
    private WebView weatherStatus;

    @Override 

    public void initialize (URL path, ResourceBundle resources){

        URL svgUrl = getClass().getResource("/weatherGui/images/gears-setup-svgrepo-com.svg");

        if (svgUrl != null){
            System.out.println("Resource found");
            weatherStatus.getEngine().load(svgUrl.toExternalForm());
        } else {
            System.out.println("Resource not found!");
        }
    }



    //Placeholder for the observable list
    @FXML
    private ListView<String> sevenDayWeatherList;


    }
