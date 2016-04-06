
/**
 * This is the BusRoute class, representing a bus route
 * 
 * @author Marc Watkins (A8900589)
 * @version 0.1 (2014-04-18)
 */

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;



public class BusRoute
{
   private String routeNumber; // route numbers may be alphanumeric, hence String
   private boolean isNightRoute;
   protected Map<Integer, BusStop> route; //map to contain bus stops of the route
   protected List<Integer> startTimes; //list to contain the start times of the route as integers ([H]HMM)
   
   
   /**
    * Constructor for objects of class BusRoute
    */
   public BusRoute(String aRouteNumber, boolean aNightRouteStatus)
   {
      this.routeNumber = aRouteNumber;
      this.isNightRoute = aNightRouteStatus;
      this.route = new TreeMap<Integer, BusStop>();
      this.startTimes = new ArrayList<Integer>();
   }

   /**
    * Getter method for route number
    */
   public String getRouteNumber()
   {
      return this.routeNumber;
   }

   /**
    * Setter method for route number
    */
   public void setRouteNumber(String aRouteNumber)
   {
      this.routeNumber = aRouteNumber;
   }

   /**
    * Getter method for night route status
    */
   public boolean isNightRoute()
   {
      return this.isNightRoute;
   }
   
   /**
    * Setter method for night route status
    */
   public void setNightRoute(boolean aNightRouteStatus)
   {
      this.isNightRoute = aNightRouteStatus;
   }
   
   /**
    * Getter method for start times
    */
   
   public List<Integer> getStartTimes()
   {
      return this.startTimes;
   }
   
   /**
    * method to clear route of route data by assinging route attribute
    * to a new instance of the Map collection
    */
   public void clearRoute()
   {
      this.route = new TreeMap<Integer, BusStop>();
   }
   
   /**
    * method to populate instance with some test data
    *  
    */
   public void setTestData()
   {
      BusStop b;

      // a list of bus stop names
      String[] nameList = {"High Street", "Downs Avenue", "Town Hall", 
       "Royal Hospital", "Lakeside", "Memorial Park", "West Side", "Crown Plaza", "Hill Road", "Mile End"};
       
      int i;
      int j;
      boolean shelter = false;
      boolean night = false;
      
      //loop to populate the route attribute
      for (i = 0; i < 10; i++)
      {
         // set shelter attribute to true for some bus stops
         if (i % 3 == 0)
         {
            shelter = true;
         }
         //set night stop attribute to true for some bus stops
         if (i % 2 == 0)
         {
            night = true;
         }
         // populate route attribute with new bus stop object
         b = new BusStop(nameList[i], shelter, night);
         this.route.put((int)(i*2.3),b);
         shelter = false;
         night = false;
      }
      
      // add start times from 700 to 2200 in 30 mins intervals
      for (j = 700; j<2300; j = j+100)
      {
         this.startTimes.add(j);
         this.startTimes.add(j+30);
      }
   }

    /**
    * method to populate instance with some alternative test data
    *  
    */
   public void setAltTestData()
   {
      BusStop b;

      // a list of bus stop names
      String[] nameList = {"42nd Street", "Hilbert Square", 
       "Fermat Pier", "Mandelb Road", "Abel Close", "Infinity Point"};
       
      int i;
      int j;
      boolean shelter = false;
      boolean night = false;
      
      //loop to populate the route attribute
      for (i = 0; i < 6; i++)
      {
         // set shelter attribute to true for some bus stops
         if (i % 2 == 0)
         {
            shelter = true;
         }
         //set night stop attribute to true for some bus stops
         if (i % 3 == 0)
         {
            night = true;
         }
         // populate route attribute with new bus stop object
         b = new BusStop(nameList[i], shelter, night);
         this.route.put((int)(i*2.5),b);
         shelter = false;
         night = false;
      }
      
      // add start times from 700 to 2200 in 30 mins intervals
      for (j = 700; j<2300; j = j+100)
      {
         this.startTimes.add(j);
         this.startTimes.add(j+30);
      }
   }
   
   /**
    * routeToString method to return a String representation of the bus route instance (for printing).
    * It iterates through the routes attribute (a SortedMap) and prints a route summary
    * consisting of Bus route number, and a table with bus stop name, minutes from start,
    * shelter status and night stop status.
    */
   public String routeToString()
   {
      StringBuilder out = new StringBuilder(1000);
      out.append("This is bus route " + this.routeNumber +"\n\n");
      out.append("Start times: ");
      
      for (Integer time : this.startTimes)
      {
         out.append(time.toString() + " ");
      }
      
      out.append("\nStop Name\tmins\tsheltered\tnight stop\n");
      for (Integer i : this.route.keySet())
      {
         BusStop stop = this.route.get(i);
         out.append(stop.getName() + "\t");
         out.append(i.toString() + "\t");
         out.append(stop.isSheltered() + "\t\t");
         out.append(stop.isNightStop() + "\n");
      }
      out.append("\n");
      return out.toString();
   }
   
   /**
    * printRoute method to print a route to standard output.
    */
   public void printRoute()
   {
       System.out.println(this.routeToString());
   }
}
