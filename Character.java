import java.util.*;

public class Character
{
  private String name;

  protected void setName(String playerName)
  {
    name = playerName;
  }

  protected String getName()
  {
    return name;
  }

  /*
    Create a level up function that'll update the stats (int the player subclass), and a
    rank up function that increases the rank each time you reach a certain level
  */
  private int level;
  private int rank;
  public String domain;

  protected int[] getCredentials()
  {
    int[] creds = new int[2];

    creds[0] = level;
    creds[1] = rank;

    return creds;
  }

  public Map<String, Integer> stats;

  // Variations of the available classes
  public static final Character ALCHEMIST()
  {
    String domain = "alchemist";

    // Modifiers vary depending on class- true or false for each stat
    boolean[] modifiers = new boolean[4];
    modifiers[0] = false; // HP
    modifiers[1] = true; // ATK
    modifiers[2] = true; // DEF
    modifiers[3] = false; // SPD

    Map<String, Integer> stats = setStats(modifiers);

    return new Character(domain, stats);
  }

  public static final Character ENCHANTER()
  {
    String domain = "enchanter";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = setStats(modifiers);

    return new Character(domain, stats);
  }

  public static final Character SHAMAN()
  {
    String domain = "shaman";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = false;

    Map<String, Integer> stats = setStats(modifiers);

    return new Character(domain, stats);
  }

  public static final Character SORCERER()
  {
    String domain = "sorcerer";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = setStats(modifiers);

    return new Character(domain, stats);
  }

  public static final Character WITCH_DOCTOR()
  {
    String domain = "witch doctor";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = false;

    Map<String, Integer> stats = setStats(modifiers);

    return new Character(domain, stats);
  }

  public static final Character WIZARD()
  {
    String domain = "wizard";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = true;

    Map<String, Integer> stats = setStats(modifiers);

    return new Character(domain, stats);
  }

  public static Map<String, Integer> setStats(boolean[] modifiers)
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
          break;
	      case 1:
          val = modifiers[1]
            ? 7 + (int)((Math.random() * 3) + 1) // 7 + (1 -> 2)
            : 7 + (int)((Math.random() * 3) - 1); // 7 + (-1 -> 1)
          stats.put("atk", val);
          break;
        case 2:
          val = modifiers[2]
            ? 3 + (int)((Math.random() * 3) + 1)
            : 3 + (int)((Math.random() * 3) - 1);
          stats.put("def", val);
          break;
        case 3:
          val = modifiers[3]
            ? 10 + (int)(Math.random() * 4) // 10 + (0 -> 3)
            : 10 + (int)((Math.random() * 3) - 1); // 10 + (-1 -> 1)
          stats.put("spd", val);
          break;
      }
    }

    return stats;
  }


  // Constructor for class after calling one of the 6 domain methods
  Character(String domain, Map<String, Integer> stats)
  {
    level = 1;
    rank = 0;

    this.domain = domain;
    this.stats = stats;
  }

}
