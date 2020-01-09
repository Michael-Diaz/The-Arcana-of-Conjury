import java.util.*;

public class Entity
{
  // Variations of the available Character classes
  protected static final Character ALCHEMIST_CHAR()
  {
    String domain = "Alchemist";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false; // HP
    modifiers[1] = true; // ATK
    modifiers[2] = true; // DEF
    modifiers[3] = false; // SPD

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Character(domain, modifiers, stats);
  }

  protected static final Character ENCHANTER_CHAR()
  {
    String domain = "Enchanter";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Character(domain, modifiers, stats);
  }

  protected static final Character SHAMAN_CHAR()
  {
    String domain = "Shaman";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = false;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Character(domain, modifiers, stats);
  }

  protected static final Character SORCERER_CHAR()
  {
    String domain = "Sorcerer";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Character(domain, modifiers, stats);
  }

  protected static final Character WITCH_DOCTOR_CHAR()
  {
    String domain = "Witch Doctor";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = false;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Character(domain, modifiers, stats);
  }

  protected static final Character WIZARD_CHAR()
  {
    String domain = "Wizard";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Character(domain, modifiers, stats);
  }


  // Variations of the available NPC classes
  protected static final NonPlayer ALCHEMIST_NPC()
  {
    String domain = "Alchemist";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false; // HP
    modifiers[1] = true; // ATK
    modifiers[2] = true; // DEF
    modifiers[3] = false; // SPD

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new NonPlayer(domain, modifiers, stats);
  }

  protected static final NonPlayer ENCHANTER_NPC()
  {
    String domain = "Enchanter";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new NonPlayer(domain, modifiers, stats);
  }

  protected static final NonPlayer SHAMAN_NPC()
  {
    String domain = "Shaman";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = false;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new NonPlayer(domain, modifiers, stats);
  }

  protected static final NonPlayer SORCERER_NPC()
  {
    String domain = "Sorcerer";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new NonPlayer(domain, modifiers, stats);
  }

  protected static final NonPlayer WITCH_DOCTOR_NPC()
  {
    String domain = "Witch Doctor";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = false;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new NonPlayer(domain, modifiers, stats);
  }

  protected static final NonPlayer WIZARD_NPC()
  {
    String domain = "Wizard";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new NonPlayer(domain, modifiers, stats);
  }


  // Variations of the available Player classes
  protected static final Player ALCHEMIST_PC()
  {
    String domain = "Alchemist";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false; // HP
    modifiers[1] = true; // ATK
    modifiers[2] = true; // DEF
    modifiers[3] = false; // SPD

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Player(domain, modifiers, stats);
  }

  protected static final Player ENCHANTER_PC()
  {
    String domain = "Enchanter";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Player(domain, modifiers, stats);
  }

  protected static final Player SHAMAN_PC()
  {
    String domain = "Shaman";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = false;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Player(domain, modifiers, stats);
  }

  protected static final Player SORCERER_PC()
  {
    String domain = "Sorcerer";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = false;
    modifiers[2] = false;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Player(domain, modifiers, stats);
  }

  protected static final Player WITCH_DOCTOR_PC()
  {
    String domain = "Witch Doctor";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = true;
    modifiers[1] = true;
    modifiers[2] = false;
    modifiers[3] = false;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Player(domain, modifiers, stats);
  }

  protected static final Player WIZARD_PC()
  {
    String domain = "Wizard";

    boolean[] modifiers = new boolean[4];
    modifiers[0] = false;
    modifiers[1] = false;
    modifiers[2] = true;
    modifiers[3] = true;

    Map<String, Integer> stats = Character.setStats(modifiers);

    return new Player(domain, modifiers, stats);
  }
}
