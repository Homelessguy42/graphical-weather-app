package weatherGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import weatherGui.geocoderUtils;
import weatherGui.weatherUtils;
import weatherGui.weeklyForecast;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("weatherGui.fxml"));
        primaryStage.setTitle("Weather App");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println("Starting program");

        //Fix this naming scheme
        geocoderUtils parser = new geocoderUtils();
        weatherUtils checkWeather = new weatherUtils();
        weeklyForecast weeklyWeather = new weeklyForecast();
        



        String city = "Taylor";
        String state = "Michigan";
        String zipCode = "48180";
        String safeCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String safeState = URLEncoder.encode(state, StandardCharsets.UTF_8);
        String safeZip = URLEncoder.encode(zipCode, StandardCharsets.UTF_8);
        
        String unformattedResponse = parser.coordinateGrabber(safeCity, safeState, safeZip);

        parser.coordinateParser(unformattedResponse);

        Float responseLat = parser.getLat();
        Float responseLong = parser.getLong(); 
        
        System.out.println("Latitude is " + responseLat + " and " + " the Longitude is " + responseLong);

        //change this name too
        checkWeather.weatherChecker(responseLat, responseLong);
        String responseString  =  checkWeather.getResponseString();

        checkWeather.intParamCycle(checkWeather.intWeatherVals, responseString);

         checkWeather.floatParamCycle(checkWeather.floatWeatherVals, responseString);

         System.out.println(responseString);

        //checkWeather.dateGrabber(responseString);

        //System.out.println("Day 1, Hour 0 Rain: " + weeklyWeather.days[0].hours[0].rain + " in");
       //System.out.println("Day 1, Hour 1 Rain: " + weeklyWeather.days[0].hours[3].rain + " in");

        System.out.println("Program finished");

        launch(args);
    }
}