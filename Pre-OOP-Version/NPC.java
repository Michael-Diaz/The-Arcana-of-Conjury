import java.util.*;
public class NPC {
   String name;
   String domain;
   String rank;
   public void setName(String playerName) {
      name = playerName;
   }   
   public String getName() {
      return name;
   }
   public void setDomain(String playerDomain) {
      domain = playerDomain;
   }
   public String getDomain() {
      return domain;
   }
   public void setRank(String playerRank) {
      rank = playerRank;
   }
   public String getRank() {
      return rank;
   }
   
   int healthPoints;  
   int tempHP;        
   int skillPoints;    
   int tempSP;         
   public void setHP(int health) {
      healthPoints = health;
   }
   public int getHP() {
      return healthPoints;
   }
   public void setTempHP(int newHealth) {
      tempHP = newHealth;
   }
   public int getTempHP() {
      return tempHP;
   }
   public void showHP() {
      System.out.println(name + "'s HP: " + tempHP + "/" + healthPoints);
   }
   public void setSP(int skill) {
      skillPoints = skill;
   }
   public int getSP() {
      return skillPoints;
   }
   public void setTempSP(int newSkill) {
      tempSP = newSkill;
   }
   public int getTempSP() {
      return tempSP;
   }
   public void showSP() {
      System.out.println(name + "'s SP: " + tempSP + "/" + skillPoints);
   }
   
   int atk;
   int tempAtk;
   int def;
   int tempDef;
   int spd;
   int tempSpd;
   public void setAtk(int attack) {
      atk = attack;
   }
   public int getAtk() {
      return atk;
   }
   public void setTempAtk(int newAttack) {
      tempAtk = newAttack;
   }
   public int getTempAtk() {
      return tempAtk;
   }
   public void setDef(int defense) {
      def = defense;
   }
   public int getDef() {
      return def;
   }
   public void setTempDef(int newDefense) {
      tempDef = newDefense;
   }
   public int getTempDef() {
      return tempDef;
   }
   public void setSpd(int speed) {
      spd = speed;
   }
   public int getSpd() {
      return spd;
   }
   public void setTempSpd(int newSpeed) {
      tempSpd = newSpeed;
   }
   public int getTempSpd() {
      return tempSpd;
   }
   
   int lvl;
   public void setLvl(int level) {
      lvl = level;
   }
   public int getLvl() {
      return lvl;
   }
  
   Spell[] wand = new Spell[5];
   ArrayList<Spell> spellbook = new ArrayList<Spell>();
   public void equipSpell(Spell replaceSpell, int slotNumber) {
      boolean found = false;
      boolean duplicate = false;
      //Checks to see if a spell is learned in order to add it to the equipped spells
      for(int check = 0; check < spellbook.size(); check++) {
         if(replaceSpell == spellbook.get(check)) {
            found = true;
         }
      }
      if(found) {
         for(int search = 0; search < wand.length; search++) {
            if(replaceSpell == wand[search]) {
               duplicate = true;
            }
         }
         if(!duplicate) {
            wand[slotNumber - 1] = replaceSpell;
            System.out.println("Equipped " + replaceSpell.spellName() + " to Slot " + slotNumber + "!");
         } else {
               System.out.println("You already have that spell equipped!");
           }
      }
   }
   public void learnSpell(Spell newSpell) {
      //Makes sure you can't learn the same spell multiple times
      boolean duplicate = false;
      for(int check = 0; check < spellbook.size(); check++) {
         if(newSpell == spellbook.get(check)) {
            duplicate = true;
            break;
         }
      }
      if(!duplicate) {
         spellbook.add(newSpell);
      } else {
           System.out.println("You already know that spell!");
        }
   }
   
}