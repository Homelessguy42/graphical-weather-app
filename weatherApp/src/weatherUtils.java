import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class weatherUtils {

        public String [] intWeatherVals = {"precipitationProbability", "cloudCover" , "relativeHumidity"};

      String [] floatWeatherVals = {"rain", "snow", "showers", "apparentTemperature", "temperature", "dewPoint", "windSpeed", "totalPrecipitation", "visibility", "snowDepth" };


        String currentDate = null;
        String responseString = null;

       weeklyForecast myWeek = new weeklyForecast();

        public String dateGrabber(String responseString){
                String regex = "\"?daily\"?\\s*:\\s*\\{\\s*\"time\"\\s*:\\s*\\[\\s*\"(\\d{4}-\\d{2}-\\d{2})\"";
                Matcher matcher = Pattern.compile(regex).matcher(responseString);
                 currentDate = null;
                if (matcher.find()){
                         currentDate = matcher.group(1);
                        System.out.println("This weekly starts on " + currentDate);
                }
                return currentDate;
        }


        public int [] pullIntArray (String [] params, String apiParam, String responseString){
                 String regex  = "\"?" + apiParam +"\"?\\s*:\\s*\\[\\s*([^\\]]+)\\]";

                  Matcher matcher = Pattern.compile(regex).matcher(responseString);

                  if (matcher.find()){

                        String[] rawValues = matcher.group(1).split("\\s*,\\s*");
                        int [] values = new int[rawValues.length];
                        for (int i = 0; i < rawValues.length; i++) {
                            values [i] = Integer.parseInt(rawValues[i]);
                        }
                        return values;

                  }
                  return new int[0];

                }

        public void  intParamCycle (String [] paramArray, String inputResponseString){

                for (int i = 0; i < paramArray.length; i++){

                       int [] intResults = pullIntArray(paramArray, paramArray[i], inputResponseString);

                        }
                 
                }



//pass parameter to get weather data on it
        public float[] pullFloatArray( String [] params,String apiParam, String responseString){
                String regex  = "\"?" + apiParam +"\"?\\s*:\\s*\\[\\s*([^\\]]+)\\]";

                  Matcher matcher = Pattern.compile(regex).matcher(responseString);

                  if (matcher.find()){

                        String[] rawValues = matcher.group(1).split("\\s*,\\s*");
                        float [] values = new float[rawValues.length];
                        for (int i = 0; i < rawValues.length; i++) {
                            values [i] = Float.parseFloat(rawValues[i]);
                        }
                        return values;

                  }
                  return new float[0];
        }


         public void  floatParamCycle (String [] paramArray, String inputResponseString){

                for (int i = 0; i < paramArray.length; i++){

                       float [] floatResults = pullFloatArray(paramArray, paramArray[i], inputResponseString);

                        }
                 
                }



        // Like this float[] rainValues = extractFloatArray("rain", responseString);
        //int globalIndex = 0;
//for (int day = 0; day < 7; day++) {
  //  for (int hour = 0; hour < 24; hour++) {
    //    forecast.days[day].hours[hour].rain = rainValues[globalIndex];
      //  forecast.days[day].hours[hour].snow = snowValues[globalIndex];
        // forecast.days[day].hours[hour].temperature = tempValues[globalIndex];
        // globalIndex++;
        //  PUT PARAMETERS INTO STRING ARRAY AND CYCLE TRHOUGH AND CALL THEM LIKE THAT INSTEAD OF MULTIPLE FUNCTION CALLS FOR THE SAME METHOD 
        //
        //
        //

        //Get current date
        public String weatherChecker(Float latitude, Float longitude)throws IOException,InterruptedException {
                HttpClient weatherClient = HttpClient.newBuilder()
                           .followRedirects(HttpClient.Redirect.NORMAL)
                           .build();


//pull diifferent parameters and the end user can decide what they want to see via the gui 

        HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude=" + latitude 
                                 + "&longitude=" + longitude 
                                 + "&daily=temperature_2m_max,daylight_duration"
                                  + "&hourly=relative_humidity_2m,dew_point_2m,temperature_2m,apparent_temperature,precipitation_probability,snow_depth,precipitation,rain,showers,snowfall,cloud_cover,visibility,wind_speed_80m,temperature_80m"
                                 + "&current=precipitation,rain,showers,snowfall"
                                 + "&timezone=America%2FNew_York"
                                 + "&wind_speed_unit=mph"
                                 + "&temperature_unit=fahrenheit"
                                + "&precipitation_unit=inch"))
                .header("User-Agent", "Currently Unnamed Weather App, created for learning (antoniodebono7@protonmail.com)")
                .GET()
                .build();

                HttpResponse<String> response = weatherClient.send(request,HttpResponse.BodyHandlers.ofString());

               //https://api.open-meteo.com/v1/forecast?latitude=" + latitude +  "&longitude=" + longitude &daily=temperature_2m_max,daylight_duration&hourly=relative_humidity_2m,dew_point_2m,temperature_2m,apparent_temperature,precipitation_probability,snow_depth,precipitation,cloud_cover,visibility,wind_speed_80m,temperature_80m&current=precipitation,rain,showers,snowfall&timezone=America%2FNew_York&wind_speed_unit=mph&temperature_unit=fahrenheit&precipitation_unit=inch 
                    //Send request and get response
                   
 

                    //Print response status code and body
                    System.err.println("Status code: " + response.statusCode());
                    System.out.println("Response: " + response.body());
                     responseString = response.body();

                        //grab dates 
                        return response.body(); 
                }

                    //check first day of week
                
       public String getResponseString(){
                return responseString;
       }

     // figure out how to take location from entry box in ui, maybe a dropdown menu with a search box where the user can type their city and click on it?
     //Read more into scenebuilder logic 

     //Find some pictures to depict the weather conditions 

        //timezone,preciptitation, showers, snow depth, visibility,

        //RETURN POINT: Next, sort the weather json into more manageable data sets. 
        //TODO: TEST API CALLS IN MAIN, ORGANIZE WEATHER RESPONSE, FLESH OUT UI, COMPILE TO EXE

    }


    
