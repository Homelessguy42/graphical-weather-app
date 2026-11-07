package weatherGui;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class geocoderUtils {


                Float latitude = null;
                Float longitude = null;


    public String coordinateGrabber (String city, String state, String zipcode)throws IOException,InterruptedException{

            HttpClient geocoderClient = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .build();


            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create( "https://nominatim.openstreetmap.org/search?city=" + city + "&state=" + state + "&postalcode=" + zipcode + "&format=json"))
                .header("Antonio-DeBono", "Currently Unnamed Weather App, created for learning (antoniodebono7@protonmail.com")
                .GET()
                .build();


                //stores response from the request. Request uses geocoder client
                HttpResponse<String> response = geocoderClient.send(request, HttpResponse.BodyHandlers.ofString());
                     String responseString = response.body();

                     return responseString;
    }

                //Logic for splitting the response into workable values

    public void coordinateParser (String responseString){

                String targetLat =  "\"lat\":\"";
                String targetLong = "\"lon\":\"";

                    if (latitude == null && longitude == null){
                        int startIndexLat = responseString.indexOf(targetLat) + targetLat.length();

                        int endIndexLat = responseString.indexOf("\"",startIndexLat);
                        latitude = Float.valueOf(responseString.substring(startIndexLat, endIndexLat));
                    }

                     if(latitude != null && longitude == null){
                        int startIndexLong = responseString.indexOf(targetLong) + targetLong.length();
                        int endIndexLong = responseString.indexOf("\"",startIndexLong);

                        longitude = Float.valueOf(responseString.substring(startIndexLong, endIndexLong));
                    }    
        }


        // Getter methods for sending the latitude and longitude

        public Float getLat(){
            return latitude;
        }

        public Float getLong(){
            return longitude;
        }


}
