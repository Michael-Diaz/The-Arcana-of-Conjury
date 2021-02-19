import java.util.*;
public class Spell {
   private String name;
   private String category; //Attack, Defend, Status or Parry
   private String statusCat; //atkBuff, defBuff, spdBuff, atkNerf, defNerf, spdNerf, heal, none
   private String type; //See bottom
   private String branch; //What type of magic user typically uses this spell
   private String shade; //Light v dark
   public String spellName() {
      return name;
   }
   public String spellCategory() {
      return category;
   }
   //Only necessary for spells under the status category
   public String spellSubCategory() {
      return statusCat;
   }

   private int costHP;
   private int costSP;
   private int acc;
   private int dmg;
   private int prot;
   public int spellCostHP() {
      return costHP;
   }
   public int spellCostSP() {
      return costSP;
   }
   public int spellAccuracy() {
      return acc;
   }
   public int spellDamagePotential() {
      return dmg;
   }
   public int spellProtectPotential() {
      return prot;
   }

   public Spell(String spellName, String spellCategory, String spellSubCategory, String spellType, String spellBranch, int bloodCost, int manaCost, int accuracy, int damage, int protection) {
      name = spellName;
      category = spellCategory;
      statusCat = spellSubCategory;
      type = spellType;
      branch = spellBranch;

      if(branch == "Alchemist" || branch == "Wizard" || branch == "Shaman") {
         shade = "Light";
      } else if(branch == "Sorcerer" || branch == "Enchanter" || branch == "Witch Doctor") {
                shade = "Dark";
             } else {
                  shade = "None";
               }
      costHP = bloodCost;
      costSP = manaCost;
      acc = accuracy;
      dmg = damage;
      prot = protection;
   }

   public void showSpellStats() {
      System.out.println(name + ":");
      System.out.println(type + " spell, " + branch + " branch of " + shade + " magic.");
      System.out.println("\nHealth Points required to use: " + costHP);
      System.out.println("Skill Points required to use: " + costSP + "\n");
      switch(category) {
         case "Attack":
            System.out.println("Can be used to Attack & Parry");
            break;
         case "Defend":
            System.out.println("Can be used to Defend & Parry");
            break;
         case "Status":
            System.out.print("Can be used to inflict Status Effects");
            switch(statusCat) {
               case "AttackBuff":
                  System.out.println(" (Increase your Attack)");
                  break;
               case "DefenseBuff":
                  System.out.println(" (Increase your Defense)");
                  break;
               case "SpeedBuff":
                  System.out.println(" (Increase your Speed)");
                  break;
               case "AttackNerf":
                  System.out.println(" (Decrease your opponent's Attack)");
                  break;
               case "DefenseNerf":
                  System.out.println(" (Decrease your opponent's Defense)");
                  break;
               case "SpeedNerf":
                  System.out.println(" (Decrease your opponent's Speed)");
                  break;
               case "Heal":
                  System.out.println(" (Heal yourself)");
                  break;
            }
            break;
      }
      System.out.println("Damage(-) / Heal(+): " + dmg);
      System.out.println("Protection: " + prot);
      System.out.println("Accuracy: " + acc + "%");
   }
}

//Alchemist Spell types; fire, water, earth, air, aether(energy flow)
//Wizard Spell types; sky, earth, sea, celestial
//Shaman Spell types; hex(status), curse(dmg), charm, bless, jinx(debuff), chant
//Witch Doctor Spell types; shadow, spirit, occult, blood
//Enchanter Spell types; extrasensory, illusion, influence, augment, diminish, extract
//Summoner Spell types; conjure, life, decompose, synthesize, commune
