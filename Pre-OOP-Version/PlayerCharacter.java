import java.util.*;
import java.lang.*;
public class PlayerCharacter extends NPC {
      
   private int exp = 0;
   private int expLvlUp = 10;
   public void addExp(int expGain) {
      exp = exp + expGain;
   }
   public int getExp() {
      return exp;
   }
   public int getExpLvlUp() {
      return expLvlUp;
   }
   public void showExpLeft() {
      System.out.print(exp + "/" + expLvlUp);
   }
   public void increaseLvl() {
      this.setLvl(this.getLvl() + 1);
      expLvlUp = expLvlUp + (int)(10 * Math.pow(2.7182818284, .3 * (lvl)));
   }

   public PlayerCharacter(int xp, int level, int hP, int tempHealth, int sP, int tempSkill, int attack, int tempAttack, int defense, int tempDefense, int speed, int tempSpeed) {
      exp = xp;
      lvl = level;
      healthPoints = hP;
      tempHP = tempHealth;
      skillPoints = sP;
      tempSP = tempSkill;
      atk = attack;
      tempAtk = tempAttack;
      def = defense;
      tempDef = tempDefense;
      spd = speed;
      tempSpd = tempSpeed;
   }

   public void displayLearnedSpells() {
      System.out.println("Learned Spells:\n");
      for(int page = 0; page < spellbook.size(); page++) {
         System.out.println((page + 1) + ". " + spellbook.get(page).spellName());
      }
      System.out.println("");
   }
   public void displayEquippedSpells() {
      System.out.println("Equipped Spells:\n");
      for(int slot = 0; slot < 5; slot++) {
         System.out.println((slot + 1) + ". " + wand[slot].spellName());
      }
      System.out.println("");
   }
   
}