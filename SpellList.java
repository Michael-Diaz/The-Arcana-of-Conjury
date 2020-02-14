import java.util.*;

public class SpellList
{
  static final int TARGET_PLR = 0b100;
  static final int TARGET_ALY = 0b010;
  static final int TARGET_EMY = 0b001;
  static final int INTENT_OFF = 0b100;
  static final int INTENT_DEF = 0b010;
  static final int INTENT_PAR = 0b001;

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

  protected static final Spell BEES_TEST_SPELL()
  {
    String name = "Bees";
    String details = ("\tSummons a shitton of angry bees.\n" +
                      "\tLike, holy crap that's a lot of bees.\n" +
                      "\tRun.");
    String origin = "Sorcerer";

    int targets = 0;
    targets = targets | TARGET_ALY;
    targets = targets | TARGET_EMY;
    int intent = 0;
    intent = intent | INTENT_OFF;

    int effects = 0;
    effects = effects | ACC_DBUFF;
    effects = effects | STAT_VIR;
    effects = effects | STAT_PAR;

    Map<String, Integer> costs = new TreeMap<>();
    costs.put("hp_cost", 0);
    costs.put("mp_cost_alchemist", 5);
    costs.put("mp_cost_enchanter", 10);
    costs.put("mp_cost_shaman", 2);
    costs.put("mp_cost_sorcerer", 4);
    costs.put("mp_cost_witch_doctor", 3);
    costs.put("mp_cost_wizard_space", 0);
    costs.put("mp_cost_wizard_air", 7);
    costs.put("mp_cost_wizard_water", 0);
    costs.put("mp_cost_wizard_land", 3);

    Map<String, Integer> stats = new TreeMap<>();
    stats.put("acc", 95);
    stats.put("pwr_dmg", 5);
    stats.put("pwr_prot", 0);

    return new Spell(name, origin, details, targets, intent, effects, costs, stats);
  }
}
