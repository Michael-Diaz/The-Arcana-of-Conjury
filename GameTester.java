import java.util.*;
import java.io.*;

public class GameTester
{
  static Scanner userInput = new Scanner(System.in);

  public static void main(String[] args) throws Exception
  {
    Player p1 = Entities.WITCH_DOCTOR_PC();
    p1.setName("Gin");
    Player p2 = Entities.ALCHEMIST_PC();
    p2.setName("Micle");

    NonPlayer n1 = Entities.ALCHEMIST_NPC();
    NonPlayer n2 = Entities.SHAMAN_NPC();
    NonPlayer n3 = Entities.SORCERER_NPC();
    n1.setName("Leonardo Bernardo III");
    n2.setName("Rupert the Hermit");
    n3.setName("Joan");

    p1.printCharacterInfo();
    p2.printCharacterInfo();

    Spell s1 = SpellList.BEES_TEST_SPELL();
    s1.printSpellInfo();

    fileSave(p1);
    fileSave(p2);

    Player loadedTest = fileLoad();
    loadedTest.printCharacterInfo();

    Player myTest = fileLoad();
    myTest.printCharacterInfo();

    myTest.printEquipped();
    myTest.printCompendium();

  }

  // Determine whether or not to make this a method in the Game Class, or
  // to make it exclusive to the Player Class
  public static void fileSave(Player player) throws Exception
  {
    System.out.print("Saving data for " + player.getName() + "...");

    // Prevents saving data for NPCs; may not be needed if the method is made
    // Player-Exclusive
    if (!(player instanceof Player))
    {
      System.out.println(" Cannot save data for an NPC!");
      return;
    }

    // Writes the save files to the specified "Saves" directory
    // find a way to detect/create the directory in case it does/doesn't exist
    FileWriter saveData = new FileWriter("Saves/" + player.getName().toLowerCase() + "_sav.txt");

    // Basic Player object information
    saveData.write(player.getName() + "\n");
    saveData.write(player.domain + "\n");

    saveData.write(Integer.toString(player.rank) + "\n");
    saveData.write(Integer.toString(player.level) + "\n");
    saveData.write(Integer.toString(player.exp) + ":");
    saveData.write(Integer.toString(player.expBarrier) + "\n");

    // Saves the domain stat modifiers for proper leveing up after loading a file
    saveData.write(Integer.toString(player.modifiers) + "\n");

    // Saves all the stats
    saveData.write(Integer.toString(player.effects) + "\n");
    saveData.write(Integer.toString(player.stats.get("current_hp")) + ":");
    saveData.write(Integer.toString(player.stats.get("hp")) + "\n");
    saveData.write(Integer.toString(player.stats.get("current_mp")) + ":");
    saveData.write(Integer.toString(player.stats.get("mp")) + "\n");

    saveData.write(Integer.toString(player.stats.get("atk")) + "\n");
    saveData.write(Integer.toString(player.stats.get("def")) + "\n");
    saveData.write(Integer.toString(player.stats.get("spd")) + "\n");

    saveData.close();

    System.out.println(" Data saved!");
  }

  // This'll have to be updated when the Player Class is completed, as we want
  // to load files and return a *Player* object based on the contents of the
  // specified file
  public static Player fileLoad() throws Exception
  {
    FileReader saveData = null;
    Player load = null;

    System.out.print("Whose tale do you wish to recount: ");
    String name = userInput.next();
    System.out.println();

    try
    {
      if (name.toLowerCase().equals(":exit:"))
      {
        System.out.println("Farewell...");
        System.exit(0);
      }

      // Checks the "Saves" directory for the file with the name specified by the player
      saveData = new FileReader("Saves/" + name.toLowerCase() + "_sav.txt");

      int i;

      // ***Make this a TreeMap for developer intuitiveness?***
      ArrayList<String> attributes = new ArrayList<>();
      StringBuilder attribute = new StringBuilder();

      // After each line, we put the built string into an ArrayList of player attributes
      while ((i = saveData.read()) != -1)
      {
        if ((char)i != '\n')
          attribute.append((char)i);
        else
        {
          attributes.add(attribute.toString());
          attribute.setLength(0);
        }
      }

      // Send the ArrayList of attributes to the loading constructor
      load = new Player(attributes.get(0), attributes.get(1),
                        Integer.parseInt(attributes.get(2)), Integer.parseInt(attributes.get(3)), attributes.get(4),
                        Integer.parseInt(attributes.get(5)), Integer.parseInt(attributes.get(6)),
                        attributes.get(7), attributes.get(8),
                        Integer.parseInt(attributes.get(9)), Integer.parseInt(attributes.get(10)), Integer.parseInt(attributes.get(11)));
    }
    catch (IOException fileNonExistent)
    {
      // If ":exit:" is not entered, then the player is given the prompt to enter
      // in a username again
      System.out.println("Hmm... There are no tales of the Magicker named " + name + ".\n");
      fileLoad();
    }
    catch (NullPointerException playerIsCorrupted)
    {
      System.out.println("Hmm... I seem to have trouble remembering " + name + "'s tale.\n");
      fileLoad();
    }
    finally
    {
      // Close the chosen file
      if (saveData != null)
        saveData.close();
    }

    return load;
  }

}

/*
  Alchemist (Elemental & Alchemical)
  Sorcerer (Summoning)
  Witch Doctor (Dark or Occult)
  Wizard (Energy to Shape Reality)
  Enchanter (Psychic)
  Shaman (Hexes, Curses, Blessings)
*/
// Bright; Alchemist, Wizard, Shaman
// Dark; Sorcerer, Enchanter, Witch Doctor
