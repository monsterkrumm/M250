
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import ou.*;


/**
 * This is the BusSystem class. It represents a collection of bus routes.
 * 
 * @author Marc Watkins 
 * @version 0.1 (2014-04-18)
 */


public class BusSystem
{
   private Map<String, BusRoute> routes;
   
   /**
    * Constructor for objects of class BusSystem
    */
   public BusSystem()
   {
      this.routes = new TreeMap<String, BusRoute>();
   }
   
   /**
    * Getter for specific route within collection
    * 
    * @param aRouteNumber a String identifying the route within the routes collection
    * 
    */
   public BusRoute getRoute(String aRouteNumber)
   {
      return this.routes.get(aRouteNumber);
   }
   
   /**
    * addRoute() method, this method allows to add instances of the BusRoute class to the bus system.
    * 
    * @param  aBusRoute   an instance of the BusRoute class, bus routes are added into a map with
    * keys consisting of the route number (a String as it can contain alphanumeric values)
    * 
    */
   public void addRoute(BusRoute aBusRoute)
   {
      // insert new route if it does not exists or user confirms to replace (making use of lazy evaluation)
      // else do nothing.
      if (this.getAllRoutes().get(aBusRoute.getRouteNumber()) == null 
       || OUDialog.confirm("Route exists. Replace?"))
      {
         this.routes.put(aBusRoute.getRouteNumber(), aBusRoute);
      }
   }
   
   /**
    * getAllRoutes method, a method getting all routes stored in the BusSystem instance
    * 
    * @return returns a Map of bus routes
    */
   public Map<String, BusRoute> getAllRoutes()
   {
      return this.routes;
   }
   
   /**
    * printAllRoutes method, this method iterates through the routes map and prints each route
    */
   public void printAllRoutes()
   {
      for (String rNumber : this.getAllRoutes().keySet())
      {
         System.out.println(this.getAllRoutes().get(rNumber).routeToString());
      }
   }
   
   /**
    * printRoute() method, this method prints a specific route if present in the map,
    * and displays an alert to the user if it is not present.
    * 
    * @param aRouteNumber a route number (as a String, since it can be alphanumeric)
    */
   
   public void printRoute(String aRouteNumber)
   {
      BusRoute rt = this.getAllRoutes().get(aRouteNumber);
      if (rt == null)
      {
         OUDialog.alert("Sorry, no such route: " + aRouteNumber);
      }
      else
      {
         System.out.println(rt.routeToString());
      }
   }
   
   /**
    * addTestData method, adds some routes to the routes attribute (a Map of BusRoutes),
    * including test data within the bus routes by invoking setTestData() method on bus route objects.
    */
   public void addTestData()
   {
      BusRoute br1 = new BusRoute("H11", false);
      BusRoute br2 = new BusRoute("140", false);
      br1.setTestData();
      br2.setTestData();
      this.addRoute(br1);
      this.addRoute(br2);
      
   }
   
   /**
    * createNightRoute() method, for creating a night route from a normal route, based on 
    * bus stops that can be used as a night stop.
    * 
    * Note that this only creates and returns a night route but does not add it to the bus system.
    * For this, use addRoute() and pass in the created night route.
    * 
    * @param aBusRoute takes a bus route and converts it to a night route based on night bus stops.
    */
   
   public BusRoute createNightRoute(BusRoute aBusRoute)
   {
      //create new bus route from bus route passed in, adding 'N' to the route number
      // and setting night route status to true.
      BusRoute nightRoute = new BusRoute(aBusRoute.getRouteNumber() + "N", true);
      int[] timeList = {2300, 0, 100,200,300,400,500,600}; // list of night times of night route start times
      for (Integer time : timeList)
      {
         nightRoute.startTimes.add(time);
      }

      for (Integer stop : aBusRoute.route.keySet())
      {
         if (aBusRoute.route.get(stop).isNightStop())
         {
            nightRoute.route.put(stop, aBusRoute.route.get(stop));
         }
      }
      return nightRoute;
   }
   
   /**
    * method to add additional start times to a particular route in the collection
    * 
    * @param aRouteNumber to identify the route in the collection
    * @param anInteger representing a new start time to be added
    */
   public void addStartTime(String aRouteNumber, Integer anInteger)
   {
      this.routes.get(aRouteNumber).startTimes.add(anInteger);
   }
   
   /**
    * method to remove a start time from a particular route in the collection
    * 
    * @param aRouteNumber to identify the route in the collection
    * @param anInteger representing the start time that is to be removed
    * 
    */
   public void removeStartTime(String aRouteNumber, Integer anInteger)
   {
      this.routes.get(aRouteNumber).startTimes.remove(anInteger);
   }
}
