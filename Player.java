import java.util.*;
import java.lang.*;

public class Player extends Character
{
  // Some form of Array as the active slots for spells...?
  // Arraylist? List? Compendium type needs to be figured out

  // ArrayList with limit size constants, allowing for a dynamically sizeable
  // array upon reaching a new rank
  protected ArrayList<Trinket> inventory = new ArrayList<>();
  private static final int INV_R0_LIMIT = 15;
  private static final int INV_R1_LIMIT = 20;
  private static final int INV_R2_LIMIT = 30;
  private static final int INV_R3_LIMIT = 50;

  int exp = 0;
  int expBarrier = 1;
  private static final int MAX_EXP = 100000;

  // Adds a given amount of experience based on an encounter and triggers a
  // levelup if the current exp value surpasses the current exp barrier
  protected void addExperience(int exp)
  {
    this.exp += exp;
    if (this.exp > MAX_EXP)
      this.exp = MAX_EXP;

    while ((this.exp >= expBarrier) && (level < 50))
    {
      increaseLevel();
      updateExpBarriers();
    }
  }

  // Upon leveling up this function is called to create a new level-up
  // threshold based on a predetermined exponential function
  protected void updateExpBarriers()
  {
    expBarrier = (4 * (int)(Math.pow(level, 3))) / 5;
  }

  // Presents the given player's information in a semi-organized format
  public void printCharacterInfo()
  {
    System.out.println("===============================");
    System.out.println("\tCharacter Info:");
    System.out.println("===============================\n");

    System.out.println("Name: " + getName());
    System.out.println("Domain: " + domain + "\n");

    System.out.println("Level: " + level);
    System.out.println("Exp Progress: " + exp + "/" + expBarrier);
    System.out.println(domain + " Rank: " + rank + "\n");

    System.out.println("HP: " + stats.get("current_hp") + "/" + stats.get("hp"));
    System.out.println("MP: " + stats.get("current_mp") + "/" + stats.get("mp") + "\n");

    System.out.println("Base ATK: " + stats.get("atk"));
    System.out.println("Base DEF: " + stats.get("def"));
    System.out.println("Base SPD: " + stats.get("spd") + "\n");

    System.out.println("===============================\n");
  }

  // Default constructor set as a precaution
  Player()
  {
    level = 1;
    rank = 0;
    modifiers = 0;
    effects = 0;
  }

  // Constructor for first creating the player
  Player(String domain, int modifiers, int effects, Map<String, Integer> stats)
  {
    level = 1;
    rank = 0;

    this.domain = domain;
    this.modifiers = modifiers;
    this.effects = effects;
    this.stats = stats;
  }

  // Constructor for loading an existing player
  Player(String name, String domain,
         int rank, int level, String expState,
         int modifiers, int effects,
         String hpState, String mpState, int atk, int def, int spd)
  {
    setName(name);
    this.domain = domain;

    this.level = level;
    this.rank = rank;
    exp = Integer.parseInt(expState.substring(0, expState.indexOf(":")));
    expBarrier = Integer.parseInt(expState.substring(expState.indexOf(":") + 1, expState.length()));

    this.modifiers = modifiers;
    this.effects = effects;

    stats = new TreeMap<>();

    stats.put("current_hp", Integer.parseInt(hpState.substring(0, hpState.indexOf(":"))));
    stats.put("hp", Integer.parseInt(hpState.substring(hpState.indexOf(":") + 1, hpState.length())));
    stats.put("current_mp", Integer.parseInt(mpState.substring(0, mpState.indexOf(":"))));
    stats.put("mp", Integer.parseInt(mpState.substring(mpState.indexOf(":") + 1, mpState.length())));

    stats.put("atk", atk);
    stats.put("def", def);
    stats.put("spd", spd);
  }
}
