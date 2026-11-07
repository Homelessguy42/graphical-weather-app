package weatherGui;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class getRequest {

     

        public String weatherChecker( int date, HttpClient clientParam)throws IOException,InterruptedException {


                HttpClient weatherClient = HttpClient.newBuilder()
                           .followRedirects(HttpClient.Redirect.NORMAL)
                           .build();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.open-meteo.com/v1/forecast&forecast_days=7"))
                .GET()
                .build();

                
                    //Send request and get response
                    HttpResponse<String> response = weatherClient.send(request,HttpResponse.BodyHandlers.ofString());

                    //Print response status code and body
                    System.err.println("Status code: " + response.statusCode());
                    System.out.println("Response: " + response.body());

                    return response.body(); 
                
     }


     //Function to grab location and give it to weather api in one fell swoop

     // figure out how to take location from entry box in ui, maybe a dropdown menu with a search box where the user can type their city and click on it?
     //Read more into scenebuilder logic 

     //Find some pictures to depict the weather conditions 

        //timezone,preciptitation, showers, snow depth, visibility,
        //TODO:  FLESH OUT UI, COMPILE TO EXE

    }

