import java.util.Random;

public class Character
{
  private String name;
  
  /*
    Create a level up function that'll update the stats, and a rank up function that
    increases the rank each time you reach a certain level
  */
  private int level;
  private int rank;
  public String domain;
  
  // StatsSheet is a seperate class with fields for HP, Atk, Def, Spd
  public Map<String, int> stats;
  
  public void setName(String playerName) 
  {
    name = playerName;
  }
  
  
  // Constructor for class methods
  Character(String domain, Map<String, int> stats)
  {
    level = 0;
    rank = 0;
    
    this.domain = domain;
    this.stats = stats;
  }
  
  
  /*
    Maybe have a way where you set modifiers for specific elements; since 4C2 is 6,
    we favor 2 stats during level up, and boost the other 2 as base stats?
  */
  // Variations of the available classes
  public static final Character ALCHEMIST()
	{
    String domain = "alchemist";
    
    Map<String, int> stats = new TreeMap<>();
    
    return new Character(domain);
  }
  
  public static final Character ENCHANTER()
	{
    String domain = "enchanter";
    return new Character(domain);
  }
  
  public static final Character SHAMAN()
	{
    String domain = "shaman";
    return new Character(domain);
  }
  
  public static final Character SORCERER()
	{
    String domain = "sorcerer";
    return new Character(domain);
  }
  
  public static final Character WITCH_DOCTOR()
	{
    String domain = "witch doctor";
    return new Character(domain);
  }
  
  public static final Character WIZARD()
	{
    String domain = "wizard";
    return new Character(domain);
  }
  
  /*
    Set the Map of stats here... or something similar? Possible use of the Random function to
    generate a value every level up?
  */
  public static void setStats(Map<String, int> stats)
  {
    
  }
}
