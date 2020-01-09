import java.util.*;

public class Character
{
  // Domain = class choice (name sake done to avoid problems w/ Java syntax)
  private String name;
  protected String domain;

  // Setter and getter methods to avoid corrupting the name of the entity
  protected void setName(String playerName)
  {
    name = playerName;
  }

  protected String getName()
  {
    return name;
  }

  // Levels are a measure of the player's progress in the game; rank determines the
  // available services(?) available. Ranks scale with level and are updated as such
  protected int level;
  protected int rank;

  // Increments the level of the NPC/Player by 1 and updates the rank value as such
  protected void increaseLevel()
  {
    int currentLvl = level;
    currentLvl++;

    if (currentLvl >= 10 && currentLvl < 24)
      rank = 1; // Set Rank to 1
    else if (currentLvl >= 25 && currentLvl < 39)
      rank = 2; // Set Rank to 2
    else if (currentLvl >= 45 && currentLvl < 51)
      rank = 3; // Set Rank to 3

    int val;
    for (int i = 0; i < 4; i++)
    {
      switch (i)
      {
        case 0:
          val = modifiers[0]
            ? (int)((Math.random() * 4) + 3) // +(3 -> 6)
            : (int)((Math.random() * 4) + 2); // +(2 -> 5)
          val += stats.get("hp");

          stats.put("hp", val);
          stats.put("current_hp", val);
          break;
        case 1:
          val = modifiers[1]
            ? (int)((Math.random() * 3) + 2) // +(2 -> 4)
            : (int)((Math.random() * 3) + 1); // +(1 -> 3)
          val += stats.get("atk");

          stats.put("atk", val);
          stats.put("temp_atk", val);
          break;
        case 2:
          val = modifiers[2]
            ? (int)((Math.random() * 3) + 2)
            : (int)((Math.random() * 3) + 1);
          val += stats.get("def");

          stats.put("def", val);
          stats.put("temp_def", val);
          break;
        case 3:
          val = modifiers[3]
            ? (int)((Math.random() * 2) + 2) // +(2 -> 3)
            : (int)((Math.random() * 2) + 1); // +(1 -> 2)
          val += stats.get("spd");

          stats.put("spd", val);
          stats.put("temp_spd", val);
          break;
      }
    }

    level = currentLvl;
  }


  // Modifiers vary depending on class- true or false for each stat
  protected static boolean[] modifiers = new boolean[4];
  protected Map<String, Integer> stats;

  // Creates a varied set of base stats based on the type of domain the Character is
  protected static Map<String, Integer> setStats(boolean[] modifiers)
  {
    Map<String, Integer> stats = new TreeMap<>();

    int val;
    for (int i = 0; i < 4; i++)
    {
      switch (i)
      {
        case 0:
          val = modifiers[0]
            ? 15 + (int)((Math.random() * 3) + 3) // 15 + (3 -> 5)
            : 15 + (int)(Math.random() * 3); // 15 + (0 -> 2)
          stats.put("hp", val);
          stats.put("current_hp", val);
          break;
	      case 1:
          val = modifiers[1]
            ? 7 + (int)((Math.random() * 3) + 1) // 7 + (1 -> 2)
            : 7 + (int)((Math.random() * 3) - 1); // 7 + (-1 -> 1)
          stats.put("atk", val);
          stats.put("temp_atk", val);
          break;
        case 2:
          val = modifiers[2]
            ? 3 + (int)((Math.random() * 3) + 1)
            : 3 + (int)((Math.random() * 3) - 1);
          stats.put("def", val);
          stats.put("temp_def", val);
          break;
        case 3:
          val = modifiers[3]
            ? 10 + (int)(Math.random() * 4) // 10 + (0 -> 3)
            : 10 + (int)((Math.random() * 3) - 1); // 10 + (-1 -> 1)
          stats.put("spd", val);
          stats.put("temp_spd", val);
          break;
      }
    }

    return stats;
  }


  // Constructor for class when NOT calling predefined domain methods
  // Helps with NonPlayer and Player subclasses
  Character()
  {
    level = 1;
    rank = 0;
  }
  // Constructor for class after calling one of the 6 domain methods
  Character(String domain, boolean[] modifiers, Map<String, Integer> stats)
  {
    level = 1;
    rank = 0;

    this.domain = domain;
    this.modifiers = modifiers;
    this.stats = stats;
  }
}
