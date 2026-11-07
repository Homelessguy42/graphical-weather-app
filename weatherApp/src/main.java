
public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
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


       // float[] rainArray = checkWeather.pullFloatArray("rain", responseString);

       // int globalIndex = 0;
       // for (int day = 0; day < 7; day ++){
         //   for (int hour = 0; day < 7; day++){
         //       if( globalIndex < rainArray.length){
          //          weeklyWeather.days[day].hours[hour].rain = rainArray[globalIndex];
           //     }
          //  }
       // }

        checkWeather.intParamCycle(checkWeather.intWeatherVals, responseString);

         checkWeather.floatParamCycle(checkWeather.floatWeatherVals, responseString);

         System.out.println(responseString);

        //checkWeather.dateGrabber(responseString);

        //System.out.println("Day 1, Hour 0 Rain: " + weeklyWeather.days[0].hours[0].rain + " in");
       //System.out.println("Day 1, Hour 1 Rain: " + weeklyWeather.days[0].hours[3].rain + " in");

        System.out.println("Program finished");
        

       
    }
}
