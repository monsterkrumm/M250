
/**
 * class Player is a very simple model of a football player beloning to a Club.
 * 
 * @author Marc Watkins 
 * @version 2013-12-21
 */
public class Player
{
   // instance variables - replace the example below with your own
   private String name;
   private int salary, motivation, health;
   private Club club;
   private boolean isSuspended;   // true means suspended, false means not suspended
   
   /**
    * Constructor for objects of class Player. 
    * Only a constructor with mandatory arguments is provided, there are no default or optional values.
    */
   public Player(String aName, int aSalary, int aMotivation, int aHealth, Club aClub, boolean aSuspensionStatus)
   {
      this.name = aName;
      
      if (aSalary < 0)
      {
         aSalary = 0;         // salary cannot be negative
      }
      this.salary = aSalary;
      
      if (aMotivation < 0)
      {
         aMotivation = 0;
      }
      else
      {
         if (aMotivation > 100)
         {
            aMotivation = 100;   // motivation should be expressed as an int between 0 and 100
         }
      }
      this.motivation = aMotivation;
      
      
      if (aHealth < 0)
      {
         aHealth = 0;
      }
      else
      {
         if (aHealth > 100)
         {
            aHealth = 100;   // health should be expressed as an int between 0 and 100
         }
      }
      this.health = aHealth;
          
      this.club = aClub;
      
      this.isSuspended = aSuspensionStatus;
   }

   /**
    * Getter method for attribute name
    *
    * @return     the name of the player as a string 
    */
   public String getName()
   {
      return this.name;
   }
   
   /**
    * Setter method for attribute name
    * 
    * @param aName   a name for the player as String
    */
   public void setName(String aName)
   {
      this.name = aName;
   }
   
   /**
    * Getter method for attribute salary
    * 
    * @return     the salary of the player as an int 
    */
   public int getSalary()
   {
      return this.salary;
   }
   
   /**
    * Setter method for attribute salary
    * 
    * @param aSalary     the salary of the player as an int 
    */
   public void setSalary(int aSalary)
   {
      if (aSalary < 0)
      {
         aSalary = 0;         // salary cannot be negative
      }
      this.salary = aSalary;
   }
   
   /**
    * Getter method for attribute motivation
    * 
    * @return     the motivation of the player as an int 
    */
   public int getMotivation()
   {
      return this.motivation;
   }
   
   /**
    * Setter method for attribute motivation
    * 
    * @param aMotivation     the motivation of the player as an int 
    */
   public void setMotivation(int aMotivation)
   {
      if (aMotivation < 0)
      {
         aMotivation = 0;
      }
      else
      {
         if (aMotivation > 100)
         {
            aMotivation = 100;   // motivation should be expressed as an int between 0 and 100
         }
      }
      this.motivation = aMotivation;
   }
   
   
   /**
    * Getter method for attribute health
    * 
    * @return     the health of the player as an int 
    */
   public int getHealth()
   {
      return this.health;
   }
   
   
   /**
    * Setter method for attribute health
    * 
    * @param aHealth     the health of the player as an int 
    */
   public void setHealth(int aHealth)
   {
      if (aHealth < 0)
      {
         aHealth = 0;
      }
      else
      {
         if (aHealth > 100)
         {
            aHealth = 100;   // health should be expressed as an int between 0 and 100
         }
      }
      this.health = aHealth;
   }
   
   /**
    * Getter method for attribute club
    * 
    * @return     the club of the player as a Club object 
    */
   public Club getClub()
   {
      return this.club;
   }
   
   
   /**
    * Setter method for attribute club
    * 
    * @param aClub     the club of the player as Club object
    */
   public void setClub(Club aClub)
   {
      this.club = aClub;
   }
  
   /**
    * Getter method for attribute isSuspended
    * In deviation from the getter method naming convention, it is convenient to name the method 'isSuspended'
    * 
    * @return     the suspension status of the player as boolean: true if suspended or false if not suspended
    */
   public boolean isSuspended()
   {
      return this.isSuspended;
   }
   
    /**
    * Setter method for explicitly setting the attribute isSuspended, passing a boolean parameter - see also instance methods suspend() and unsuspend()
    * 
    * @param suspension     the boolean suspension status of the player (true = suspended, false = not suspended)
    */
   public void setSuspensionStatus(boolean aSuspensionStatus)
   {
      this.isSuspended = aSuspensionStatus;
   }
   
   /**
    * Method for implicitly setting the attribute isSuspended to true (i.e. suspended). Same effect as setSuspensionStatus(true)
    * 
    * @param no parameter
    */
   public void suspend()
   {
      this.isSuspended = true;
   }
   
   /**
    * Method for implicitly setting the attribute suspensionStatus to false (i.e. not suspended). Same effect as setSuspensionStatus(false)
    * 
    * @param no parameter
    */
   public void unsuspend()
   {
      this.isSuspended = false;
   }
   
   /**
    * Method for returning a string representation of the player object in the following format:
    * 'Player [name] playing for [club]. Current salary is [salary] and motivation is [low, medium, high].'
    * 
    * @param no parameter
    */
   public String toString()
   {
      String motivationRange;
      if (this.motivation < 40)
      {
         motivationRange = "low";
      }
      else
      {
         if (motivation < 80)
         {
            motivationRange = "medium";
         }
         else
         {
            motivationRange = "high";
         }
      }
      return "Player " + this.name + " playing for " + this.club.getName() + ". Current salary is " + this.salary + " and motivation is " + motivationRange + ".";
   }
   
   /**
    * Method for determining whether the player will quit the club:
    * player quits if EITHER motivation is very low (below 20) OR if motivation is low (below 40) and salary below average of the club.
    * 
    * @param no parameter
    */
   public boolean willQuit(){
      int avgSalary = this.club.getAverageSalary();
      if ( (this.motivation < 20) || (this.motivation < 40 && this.salary < avgSalary) ) 
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    * Method for determining whether the player can play:
    * player can only play if health is sufficient ( i.e. > 80%) and not suspended
    * 
    * @param  no parameter
    * @return     boolean value, true if player can plan, false otherwise
    */
   public boolean canPlay()
   {
      if (this.health > 80 && !this.isSuspended())    
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}
