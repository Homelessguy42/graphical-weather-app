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
            try{
            String svgContent = new String(svgUrl.openStream().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
           //The svg is getting loaded in a piece of HTML that allows the size to be adjusted

           String svgImage =

           "<html>" + 
           "<body style= 'margin:0; padding:0; background:transparent; display: flex; justify-content:center; align-items:center; height: 100vh; '>" + 
           "<div style='width:50%; height:50%; display:flex; justify-content:center; align-items:center;'>"  + 
           svgContent + 
           "</div>" + 
           "</body>" + 
           "</html>";

           weatherStatus.getEngine().loadContent(svgImage);

           // Inject script/style to force SVG elements to scale within the wrapper container
            
            weatherStatus.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
                    weatherStatus.getEngine().executeScript(
                        "var style = document.createElement('style');" +
                        "style.innerHTML = 'svg { width: 100%; height: 100%; object-fit: contain; }';" +
                        "document.head.appendChild(style);"
                    );

                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }

        } else {
            System.out.println("Resource not found!");
        }
    }


}
