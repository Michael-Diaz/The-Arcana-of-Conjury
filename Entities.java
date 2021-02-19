import java.util.*;

public class Entities
{
  static final int HP_MOD = 0b1000;
  static final int ATK_MOD = 0b0100;
  static final int DEF_MOD = 0b0010;
  static final int SPD_MOD = 0b0001;
  
  // Variations of the available Character classes
  protected static final Character ALCHEMIST_CHAR()
  {
    String domain = "Alchemist";

    int modifiers = 0;
    modifiers = modifiers | ATK_MOD;
    modifiers = modifiers | DEF_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Character(domain, modifiers, effects, stats);
  }

  protected static final Character ENCHANTER_CHAR()
  {
    String domain = "Enchanter";

    int modifiers = 0;
    modifiers = modifiers | ATK_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Character(domain, modifiers, effects, stats);
  }

  protected static final Character SHAMAN_CHAR()
  {
    String domain = "Shaman";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | DEF_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Character(domain, modifiers, effects, stats);
  }

  protected static final Character SORCERER_CHAR()
  {
    String domain = "Sorcerer";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Character(domain, modifiers, effects, stats);
  }

  protected static final Character WITCH_DOCTOR_CHAR()
  {
    String domain = "Witch Doctor";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | ATK_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Character(domain, modifiers, effects, stats);
  }

  protected static final Character WIZARD_CHAR()
  {
    String domain = "Wizard";

    int modifiers = 0;
    modifiers = modifiers | DEF_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Character(domain, modifiers, effects, stats);
  }


  // Variations of the available NPC classes
  protected static final NonPlayer ALCHEMIST_NPC()
  {
    String domain = "Alchemist";

    int modifiers = 0;
    modifiers = modifiers | ATK_MOD;
    modifiers = modifiers | DEF_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new NonPlayer(domain, modifiers, effects, stats);
  }

  protected static final NonPlayer ENCHANTER_NPC()
  {
    String domain = "Enchanter";

    int modifiers = 0;
    modifiers = modifiers | ATK_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new NonPlayer(domain, modifiers, effects, stats);
  }

  protected static final NonPlayer SHAMAN_NPC()
  {
    String domain = "Shaman";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | DEF_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new NonPlayer(domain, modifiers, effects, stats);
  }

  protected static final NonPlayer SORCERER_NPC()
  {
    String domain = "Sorcerer";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new NonPlayer(domain, modifiers, effects, stats);
  }

  protected static final NonPlayer WITCH_DOCTOR_NPC()
  {
    String domain = "Witch Doctor";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | ATK_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new NonPlayer(domain, modifiers, effects, stats);
  }

  protected static final NonPlayer WIZARD_NPC()
  {
    String domain = "Wizard";

    int modifiers = 0;
    modifiers = modifiers | DEF_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new NonPlayer(domain, modifiers, effects, stats);
  }


  // Variations of the available Player classes
  protected static final Player ALCHEMIST_PC()
  {
    String domain = "Alchemist";

    int modifiers = 0;
    modifiers = modifiers | ATK_MOD;
    modifiers = modifiers | DEF_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Player(domain, modifiers, effects, stats);
  }

  protected static final Player ENCHANTER_PC()
  {
    String domain = "Enchanter";

    int modifiers = 0;
    modifiers = modifiers | ATK_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Player(domain, modifiers, effects, stats);
  }

  protected static final Player SHAMAN_PC()
  {
    String domain = "Shaman";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | DEF_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Player(domain, modifiers, effects, stats);
  }

  protected static final Player SORCERER_PC()
  {
    String domain = "Sorcerer";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Player(domain, modifiers, effects, stats);
  }

  protected static final Player WITCH_DOCTOR_PC()
  {
    String domain = "Witch Doctor";

    int modifiers = 0;
    modifiers = modifiers | HP_MOD;
    modifiers = modifiers | ATK_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Player(domain, modifiers, effects, stats);
  }

  protected static final Player WIZARD_PC()
  {
    String domain = "Wizard";

    int modifiers = 0;
    modifiers = modifiers | DEF_MOD;
    modifiers = modifiers | SPD_MOD;

    Map<String, Integer> stats = Character.setStats(modifiers);

    int effects = 0;

    return new Player(domain, modifiers, effects, stats);
  }
}
