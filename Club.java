
/**
 * class Club is a very simple model of a Football Club
 * 
 * @author Marc Watkins
 * @version 2013-12-21
 */
public class Club
{
   private String name, city, league;
   private int averageSalary;
     
   
   /**
    * Constructor for objects of class Club
    */
   public Club(String aName, String aCity, String aLeague, int anAverageSalary)
   {
      this.name = aName;
      this.city = aCity;
      this.league = aLeague;
      this.averageSalary = anAverageSalary;
   }

   /**
    * Getter method for attribute name 
    * 
    * 
    * @return     the name of the Club as a String 
    */
   public String getName()
   {
      return this.name;
   }
      
  /**
   * Setter method for attribute name
   * 
   * @param aName    the name of the Club as a String
   */
  public void setName(String aName)
  {
     this.name = aName;
  }
    
  /**
   * Getter method for attribute city
   * 
   * @return   the name of the city as a String
   */
  public String getCity()
  {
     return this.city;
  }
  
  /**
   * Setter method for attribute city
   * 
   * @param aCity    name of the city as a String
   */
  public void setCity(String aCity)
  {
     this.city = aCity;
  }
  
  /**
   * Getter method for attribute league
   * 
   * @return   the name of the league as a String
   */
  public String getLeague()
  {
     return this.league;
  }
    
  /**
   * Setter method for attribute league
   * 
   * @param aLeague    name of the league as a String
   */
  public void setLeague(String aLeague)
  {
     this.league = aLeague;
  }
  
  /**
   * Getter method for attribute averageSalary
   * 
   * @return    the average salary of the Club as an int
   */
  public int getAverageSalary()
  {
     return this.averageSalary;
  }
  
  /**
   * Setter method for attribute averageSalary
   * 
   * param anAverageSalary    the average salary of the Clug as an int
   */
  public void setAverageSalary(int anAverageSalary)
  {
     if (anAverageSalary < 0)
     {
        anAverageSalary = 0;     // salary should not be negative
     }
     this.averageSalary = anAverageSalary;
  }
  
  /**
   * toString method for Club object
   * 
   * @return   information on the Club object as a String
   */
  public String toString()
  {
     return "Club " + this.name + " from " + this.city + " playing in " + this.league;
  }
}
