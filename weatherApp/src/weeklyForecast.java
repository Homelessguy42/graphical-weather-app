//One week has seven days


//One day has twenty four hours. 
class hourlyForecast {
public int hourNumber;

  //This is second of tow string arrays that server a similar purpose. This array holds values that will be parsed as floats


    public hourlyForecast(){
      
    }


}

 class dailyForecast{
 int month, day, year; 

 hourlyForecast[] hours = new hourlyForecast[24];

 public dailyForecast() {
  for(int i = 0; i < 24; i++){
    hours[i]  = new hourlyForecast();
    hours[i].hourNumber = i;
      }
    }
  }

class weeklyForecast{

String startDate;

int dayNumber;

dailyForecast[] days = new dailyForecast[7];

public weeklyForecast(){
  for (int i = 0; i < 7; i++){
    days[i] = new dailyForecast();
  }
}

} 

//go through and populate this 

// make function in weatherUtils

   




// Initialize each element using a loop
//for (int i = 0; i < hours.length; i++) {
  //  hours[i] = new Hour();
//}

// Access them via index
//hours[0].doSomething();  Replaces hour1


//weather data sort: maybe group them into 24 across seven days


//create week object based off first day of week/current week (one week from "today")


//function to get date
 

 //"today's" date (?<="?daily"?\s*:\s*\{\s*"time"\s*:\s*\[\s*")\d{4}-\d{2}-\d{2}

 

 //loop to create day seven day objects, need to read date from json response and use it to name object



//loop to create hour objects

// function to read hour objects