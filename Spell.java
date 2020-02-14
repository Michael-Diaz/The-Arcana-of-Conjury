import java.util.*;

public class Spell
{
  private String name;
  private String origin;
  private String details;

  // targets
    /*
      Player
      Ally
      Enemy
    */
  // intent
    /*
      Offense
      Defense
      Parry (Only available when the target is an enemy)
    */
  static final int TARGET_PLR = 0b100;
  static final int TARGET_ALY = 0b010;
  static final int TARGET_EMY = 0b001;
  static final int INTENT_OFF = 0b100;
  static final int INTENT_DEF = 0b010;
  static final int INTENT_PAR = 0b001;

  protected int targets;
  protected int intent;

  // effects (can have multiple)
    /*
      Attack: Buff / Debuff
      Defend: Buff / Debuff
      Speed: Buff / Debuff
      Accuracy: Buff/ Debuff
      Status: Virulence (Poison),
              Paroxysm (Paralysis),
              Somnolence (Sleep),
              Tumult (Confusion)
      Healing: HP / MP
      Nothing
    */
  // Make some kind of method that can be run from the combative class
  static final int ATK_BUFF = 0b10000000000000;
  static final int ATK_DBUFF = 0b01000000000000;
  static final int DEF_BUFF = 0b00100000000000;
  static final int DEF_DBUFF = 0b00010000000000;
  static final int SPD_BUFF = 0b00001000000000;
  static final int SPD_DBUFF = 0b00000100000000;
  static final int ACC_BUFF = 0b00000010000000;
  static final int ACC_DBUFF = 0b00000001000000;
  static final int STAT_VIR = 0b00000000100000;
  static final int STAT_PAR = 0b00000000010000;
  static final int STAT_SOM = 0b00000000001000;
  static final int STAT_TUM = 0b00000000000100;
  static final int HEAL_HP = 0b00000000000010;
  static final int HEAL_MP = 0b00000000000001;

  protected int effects;

  // stats
    /*
      Cost (Will vary based on the type of Magicker the player is)
        Alchemists: Life Force, regens at a constant rate
                    When 0, and the player chooses to cast a spell, they will take proportional damage
        Enchanters: Focus, builds progressively each turn the player isn't harmed,
                    Damage resets the multiplier
        Shamans: Wisps, a random amount are gained every turn, multipliers of the values can be used to power up a spell
        Sorcerers: Vitae, the inherent life essence in an object
                   Can also be used to heal the player only
        Witch Doctors: Blood Meter, damage of any kind will fill up the blood meter by a percentage of a limit
        Wizards: Essentia, potent magick that can be extracted from objects
                 Different essentia types in different values will be used in combination for a spell

      Accuracy
      Damage Power: A ratio to multiply the player's attack stat by
      Protection Power: A ratio to multiply the player's defense stat by
    */
  protected Map<String, Integer> costs = new TreeMap<>();
  protected Map<String, Integer> stats = new TreeMap<>();

  protected void printSpellInfo()
  {
    System.out.println("====================================================");
    System.out.println("\t\t   Spell Details:");
    System.out.println("====================================================");

    System.out.println("Name: " + name);
    System.out.println("Description:\n" + details + "\n");

    System.out.println("Imagined by a(n) " + origin + ".");

    System.out.println("Health Cost: " + costs.get("hp_cost"));
    System.out.println("Mana Cost: " +
                        "\n\tAlchemist: Life Force equal to or above " + costs.get("mp_cost_alchemist") +
                        "\n\tEnchanter: Focus at " + costs.get("mp_cost_enchanter") + "%" +
                        "\n\tShaman: \n\t\t" + costs.get("mp_cost_shaman") * 1 + " wisps for supplication" +
                                    "\n\t\t" + costs.get("mp_cost_shaman") * 2 + " wisps for invocation" +
                                    "\n\t\t" + costs.get("mp_cost_shaman") * 3 + " wisps for evocation" +
                        "\n\tSorcerer: At least " + costs.get("mp_cost_sorcerer") + " Vitae" +
                        "\n\tWitch Doctor: Blood Count of " + costs.get("mp_cost_witch_doctor") + ", or more" +
                        "\n\tWizard: \n\t\t" + costs.get("mp_cost_wizard_space") + " or greater Spatium Aether" +
                                    "\n\t\t" + costs.get("mp_cost_wizard_air") + " or greater Aer Aether" +
                                    "\n\t\t" + costs.get("mp_cost_wizard_water") + " or greater Aqua Aether" +
                                    "\n\t\t" + costs.get("mp_cost_wizard_land") + " or greater Terra Aether");

    System.out.println("Accuracy: " + stats.get("acc"));
    System.out.println("Damaging Power: "  + stats.get("pwr_dmg"));
    System.out.println("Protective Power: " + stats.get("pwr_prot"));

    System.out.println("====================================================\n");
  }


  Spell()
  {
    name = "???";
    origin = "Unknown";
    details = "Nothing is known about this spell, it is shrouded in mystery.";

    targets = 0;
    intent = 0;
    effects = 0;
  }

  Spell(String name, String origin, String details,
        int targets, int intent, int effects,
        Map<String, Integer> costs, Map<String, Integer> stats)
  {
    this.name = name;
    this.origin = origin;
    this.details = details;

    this.targets = targets;
    this.intent = intent;

    this.effects = effects;

    this.costs = costs;
    this.stats = stats;
  }
}
