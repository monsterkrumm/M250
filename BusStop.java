
/**
 * This is the BusStop class.
 * A bus stop has a name and location, the latter consisting of
 * a latitude value and a longitude value.
 * 
 * 
 * @author Marc Watkins 
 * @version 0.1 (2014-04-18)
 */
public class BusStop
{
   
   private String name;
   private boolean isSheltered; //indicates whether bus stop has a rain shelter
   private boolean isNightStop; //indicates whether bus stop is suitable as night stop


   /** 
    * Constructor for objects of class BusStop
    */
   public BusStop(String aName, boolean aShelterStatus, boolean aNightStopStatus)
   {
      this.name = aName;
      this.isSheltered = aShelterStatus;
      this.isNightStop = aNightStopStatus;
   }

   /**
    * Getter method for name attribute
    *
    * @return returns the name attribute of the BusStop instance
    */
   public String getName()
   {
      return this.name;
   }
   
   /**
    * Setter method for name attribute
    * 
    * @param  aName   String containing the new name of the BusStop
    */
   public void setName(String aName)
   {
      this.name = aName;
   }
     
   /**
    * Getter method for isSheltered attribute
    * 
    * @return    returns boolean indicating wether bus stop has a shelter
    */
   public boolean isSheltered()
   {
      return this.isSheltered;
   }
   
   /**
    * Setter method for isSheltered attribute
    * 
    * @param  aShelterStatus indicating whether the bus stop is sheltered
    */
   public void setSheltered(boolean aShelterStatus)
   {
      this.isSheltered = aShelterStatus;
   }
   
   /**
    * Getter method for isNightStop attribute
    * 
    * @return returns the night stop status as a boolean value
    */
   public boolean isNightStop()
   {
      return this.isNightStop;
   }
   
   /**
    * Setter method for isNightStop attribute
    * 
    * @param aNightStopStatus a boolean value indicating whether the bus stop is a night stop
    */
   public void setNightStop(boolean aNightStopStatus)
   {
      this.isNightStop = aNightStopStatus;
   }   
   
}
