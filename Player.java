import java.util.*;
import java.lang.*;

public class Player extends Character
{
  // Some form of Array as the active slots for spells...?
  // Arraylist? List? Compendium type needs to be figured out
  // another dynamic contaianer type for the inventory


  private int exp = 0;
  private int expBarrier = 1;
  private static final int MAX_EXP = 100000;

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

  protected void updateExpBarriers()
  {
    expBarrier = (4 * (int)(Math.pow(level, 3))) / 5;
  }


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

    System.out.println("HP: " + stats.get("hp") + "/" + stats.get("current_hp"));
    System.out.println("Base ATK: " + stats.get("atk"));
    System.out.println("Base DEF: " + stats.get("def"));
    System.out.println("Base SPD: " + stats.get("spd") + "\n");

    System.out.println("===============================\n");
  }


  Player()
  {
    level = 1;
    rank = 0;
    modifiers = 0;
    effects = 0;
  }

  Player(String domain, int modifiers, int effects, Map<String, Integer> stats)
  {
    level = 1;
    rank = 0;

    this.domain = domain;
    this.modifiers = modifiers;
    this.effects = effects;
    this.stats = stats;
  }
}
