import java.util.*;
import java.lang.*;
public class CombatSystem {
   static Scanner userInput = new Scanner(System.in);
   static Spell reaction;
   static int selection;
   static int choice;
   //Prevents players from using invalid spells IMPLEMENT THIS
   static boolean[] available = new boolean[5];
   
   public void prompt(PlayerCharacter player, NPC enemy) {
      //Player chooses their action
      do {
         System.out.println("\nType '1' to use an Attack Spell");
         System.out.println("Type '2' to use a Guard Spell");
         System.out.println("Type '3' to use a Status Spell");
         System.out.println("Type '4' to Parry with a Spell");
         selection = userInput.nextInt();
         if(selection < 1 || selection > 4) {
            System.out.println("Unknown command. Enter in a command given by the following prompt:");
         }
      } while(selection < 1 || selection > 4);
      
      //Player chooses from a selection of spells based on action
      spellChoice(player, enemy);
      
      while(available[choice - 1] == false) {
         System.out.println("Unknown command. Enter in a command given by the following prompt:");
         spellChoice(player, enemy);
      }
      
      //Begins combat phase based on previous options
      //Restores some SP at the end of each turn
      switch(selection) {
         case 1:
            attackSpell(player, enemy, player.wand[choice - 1]);
            restoreSP(player, enemy);
            break;
          case 2:
            defendSpell(player, enemy, player.wand[choice - 1]);
            restoreSP(player, enemy);
            break;
         case 3:
            statusSpell(player, enemy, player.wand[choice - 1]);
            restoreSP(player, enemy);
            break;
         case 4:
            parrySpell(player, enemy, player.wand[choice - 1]);
            restoreSP(player, enemy);
            break;
      }
     
   }
   
   public void spellChoice(PlayerCharacter player, NPC enemy) {
      switch(selection) {
         case 1:
            System.out.println("\nChoose a spell from below [(1 - 5)]");
            for(int slot = 0; slot < 5; slot++) {
               if((player.wand[slot].spellCategory() == "Attack") && (player.wand[slot].spellCostSP() <= player.getTempSP()) && (player.wand[slot].spellCostHP() < player.getTempHP())) {
                  System.out.println((slot + 1) + ". " + player.wand[slot].spellName());
                  available[slot] = true;
               } else {
                  System.out.println((slot + 1) + ". -----");
                  available[slot] = false;
               }
            }
            break;
         case 2:
            System.out.println("\nChoose a spell from below [(1 - 5)]");
            for(int slot = 0; slot < 5; slot++) {
               if((player.wand[slot].spellCategory() == "Defend") && (player.wand[slot].spellCostSP() <= player.getTempSP()) && (player.wand[slot].spellCostHP() < player.getTempHP())) {
                  System.out.println((slot + 1) + ". " + player.wand[slot].spellName());
                  available[slot] = true;
               } else {
                  System.out.println((slot + 1) + ". -----");
                  available[slot] = false;
               }
            }
            break;
         case 3:
            System.out.println("\nChoose a spell from below [(1 - 5)]");
            for(int slot = 0; slot < 5; slot++) {
               if((player.wand[slot].spellCategory() == "Status") && (player.wand[slot].spellCostSP() <= player.getTempSP()) && (player.wand[slot].spellCostHP() < player.getTempHP())) {
                  System.out.println((slot + 1) + ". " + player.wand[slot].spellName());
                  available[slot] = true;
               } else {
                  System.out.println((slot + 1) + ". -----");
                  available[slot] = false;
               }
            }
            break;
         case 4:
            System.out.println("\nChoose a spell from below [(1 - 5)]");
            for(int slot = 0; slot < 5; slot++) {
               if((player.wand[slot].spellCategory() == "Attack" || player.wand[slot].spellCategory() == "Defend") && (player.wand[slot].spellCostSP() <= player.getTempSP()) && (player.wand[slot].spellCostHP() < player.getTempHP())) {
                  System.out.println((slot + 1) + ". " + player.wand[slot].spellName());
                  available[slot] = true;
               } else {
                  System.out.println((slot + 1) + ". -----");
                  available[slot] = false;
               }
            }
            break;
      }
      choice = userInput.nextInt();
   }
   
   public void attackSpell(PlayerCharacter player, NPC enemy, Spell action) {
      //Randomly chooses a spell from the enemy's inventory to use
      enemyAI(enemy);
      
      //Checks who moves first
      if(player.getTempSpd() > enemy.getTempSpd()) {
         //Player attacks first
         System.out.println("\n" + player.getName() + " used " + action.spellName() + " on " + enemy.getName() + "!");
         
         //HP & SP Costs of spells deducted
         player.setTempSP(player.getTempSP() + action.spellCostSP());
         if(player.getTempSP() <= 0) {
            player.setTempSP(0);
         }
         player.setTempHP(player.getTempHP() + action.spellCostHP());
         player.showHP();
         player.showSP();
         
         if(accuracyCheck(action)) {
            //Player attacks first, spell succeeds
            System.out.println("\n" + enemy.getName() + " was struck by " + player.getName() + "'s " + action.spellName() + "!");
            enemy.setTempHP(enemy.getTempHP() + (action.spellDamagePotential() - (player.getAtk() / 5)) + (enemy.getDef() / 10));
            enemy.showHP();
         } else {
            //Player attacks first, spell fails
            System.out.println("\n" + enemy.getName() + " dodged " + player.getName() + "'s " + action.spellName() + "!");
           }
         if(enemy.getTempHP() < 1) {
            //Enemy dies
            enemy.setTempHP(0);
            System.out.println(enemy.getName() + " has been slain!");
         } else {
            //Enemy attacks second
            System.out.println("\n" + enemy.getName() + " retaliated with " + reaction.spellName() + "!");
            
            if(accuracyCheck(reaction)) {
               //Enemy attacks second, attack succeeds
               System.out.println("\nYou couldn't avoid " + enemy.getName() + "'s " + reaction.spellName() + "!");
               player.setTempHP(player.getTempHP() + (reaction.spellDamagePotential() - (enemy.getAtk() / 5)) + (player.getDef() / 10));
               player.showHP();
            } else {
               //Enemy attacks second, attack fails
               System.out.println("\nYou managed to dodge " + enemy.getName() + "'s " + reaction.spellName() + "!");
              }
            if(player.getTempHP() < 1) {
               //Player dies
               player.setTempHP(0);
               System.out.println("Oh no! You have been slain by " + enemy.getName() + "...");
            }
           }
      } else {
          //Enemy attacks first
          System.out.println("\n" + enemy.getName() + " attacked you with " + reaction.spellName() + "!");
          
          if(accuracyCheck(reaction)) {
            //Enemy attacks first, attack succeeds
            System.out.println("\nYou couldn't avoid " + enemy.getName() + "'s " + reaction.spellName() + "!");
            player.setTempHP(player.getTempHP() + (reaction.spellDamagePotential() - (enemy.getAtk() / 5)) + (player.getDef() / 10));
            player.showHP();
          } else {
               //Enemy attacks first, attack fails
               System.out.println("\nYou managed to dodge " + enemy.getName() + "'s " + reaction.spellName() + "!");
            }
          if(player.getTempHP() < 1) {
             //Player dies
             player.setTempHP(0);
             System.out.println("Oh no! You have been slain by " + enemy.getName() + "...");
          } else {
               //Player attacks second
               System.out.println("\n" + player.getName() + " used " + action.spellName() + " on " + enemy.getName() + "!");
               
               //HP & SP Costs of spells deducted
               player.setTempSP(player.getTempSP() + action.spellCostSP());
               if(player.getTempSP() <= 0) {
                  player.setTempSP(0);
               }
               player.setTempHP(player.getTempHP() + action.spellCostHP());
               player.showHP();
               player.showSP();
         
               if(accuracyCheck(action)) {
                  //Player attacks second, attack succeeds
                  System.out.println("\n" + enemy.getName() + " was struck by " + player.getName() + "'s " + action.spellName() + "!");
                  enemy.setTempHP(enemy.getTempHP() + (action.spellDamagePotential() - (player.getAtk() / 5)) + (enemy.getDef() / 10));
                  enemy.showHP();
               } else {
                  //Player attacks second, attack fails
                  System.out.println("\n" + enemy.getName() + " dodged " + player.getName() + "'s " + action.spellName() + "!");
                 }
               if(enemy.getTempHP() < 1) {
                  //Enemy dies
                  enemy.setTempHP(0);
                  System.out.println(enemy.getName() + " has been slain!");
               }
            }
        }
   }
   
   public void defendSpell(PlayerCharacter player, NPC enemy, Spell action) {
      //Pierce is the negative attack power, prot is the positive defense power
      //Variance variable prevents adding HP when pierce < prot
      int pierce;
      int prot;
      int variance;
      
      //Randomly chooses a spell from the enemy's inventory to use
      enemyAI(enemy);
      
      //Enemy always will attack first when defending
      if(accuracyCheck(reaction)) {
         //Enemy attack succeeds
           
         if(accuracyCheck(action)) {
           //Player defense succeeds
           
           //Calculate reduced damage after defending
           pierce = reaction.spellDamagePotential() - (enemy.getAtk() / 5);
           prot = (player.getDef() / 10) + action.spellProtectPotential();
           variance = prot + pierce;
           if(variance > 0) {
              variance = 0;
           }
           //Player defense succeeds
           System.out.println("\n" + player.getName() + " shielded using " + action.spellName() + " in an attempt to lessen the damage!");
           //HP & SP Costs of spells deducted
           player.setTempSP(player.getTempSP() + action.spellCostSP());
           if(player.getTempSP() <= 0) {
              player.setTempSP(0);
           }
           player.setTempHP(player.getTempHP() + action.spellCostHP());
           player.showHP();
           player.showSP();
           
           System.out.println("\n" + enemy.getName() + " attacked you with " + reaction.spellName() + "!");
           if(variance == 0) {
              System.out.println("Your defense was so strong that " + enemy.getName() + "'s " + reaction.spellName() + " did no damage!");
           }
           player.setTempHP(player.getTempHP() + variance);
           player.showHP();
         } else {
            //Player defense fails
            System.out.println("\n" + player.getName() + " attempted to shield using " + action.spellName() + ", but it failed!");
            //HP & SP Costs of spells deducted
            player.setTempSP(player.getTempSP() + action.spellCostSP());
            if(player.getTempSP() <= 0) {
               player.setTempSP(0);
            }
            player.setTempHP(player.getTempHP() + action.spellCostHP());
            player.showHP();
            player.showSP();
            
            System.out.println("\n" + enemy.getName() + " attacked you with " + reaction.spellName() + "!");
            player.setTempHP(player.getTempHP() + (reaction.spellDamagePotential() - (enemy.getAtk() / 5)) + (player.getDef() / 10));
            player.showHP();
           }
         if(player.getTempHP() < 1) {
            //Player dies
            player.setTempHP(0);
            System.out.println("Oh no! You have been slain by " + enemy.getName() + "...");
         }
      } else {
         //Enemy attack fails
         
         //No costs are deducted for defending here
         System.out.println("\nYou managed to avoid " + enemy.getName() + "'s " + reaction.spellName() + " without having to defend!");
        }
   }
   
   public void statusSpell(PlayerCharacter player, NPC enemy, Spell action) { 
      //Randomly chooses a spell from the enemy's inventory to use
      enemyAI(enemy);
   
      if(player.getSpd() > enemy.getSpd()) {
         //Player casts first
         
         System.out.println("\n" + player.getName() + " used " + action.spellName() + " to change the tide of battle!");
         //HP & SP Costs of spells deducted
         player.setTempSP(player.getTempSP() + action.spellCostSP());
         if(player.getTempSP() <= 0) {
            player.setTempSP(0);
         }
         player.setTempHP(player.getTempHP() + action.spellCostHP());
         player.showHP();
         player.showSP();
         
         if(accuracyCheck(action)) {
            //Player casts first, casting succeeds
            switch(action.spellSubCategory()) {
               case "AttackBuff":
                  System.out.println("\n" + player.getName() + " increased their attack!");
                  player.setTempAtk((int)(player.getTempAtk() * 1.2));
                  break;
               case "DefenseBuff":
                  System.out.println("\n" + player.getName() + " increased their defense!");
                  player.setTempDef((int)(player.getTempDef() * 1.2));
                  break;
               case "SpeedBuff":
                  System.out.println("\n" + player.getName() + " increased their speed!");
                  player.setTempSpd((int)(player.getTempSpd() * 1.5));
                  break;
               case "AttackNerf":
                  System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s attack!");
                  enemy.setTempAtk((int)(enemy.getTempAtk() * 0.8));
                  break;
               case "DefenseNerf":
                  System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s defense!");
                  enemy.setTempDef((int)(enemy.getTempDef() * 0.8));
                  break;
               case "SpeedNerf":
                  System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s speed!");
                  enemy.setTempSpd((int)(enemy.getTempSpd() * 0.75));
                  break;
               case "Heal":
                  System.out.println("\n" + player.getName() + " is healed for " + action.spellDamagePotential() + " HP!");
                  player.setTempHP(player.getTempHP() + action.spellDamagePotential());
                  //Prevents overheals
                  if(player.getTempHP() > player.getHP()) {
                     player.setTempHP(player.getHP());
                  }
                  player.showHP();
                  break;
            }
         } else {
            //Player casts first, casting fails
            System.out.println("... but it failed in casting!");
           }
         //Enemy attacks second
         System.out.println("\n" + enemy.getName() + " attacked you with " + reaction.spellName() + "!");
         
         if(accuracyCheck(reaction)) {
            //Enemy attacks second, attack succeeds
            System.out.println("\nYou couldn't avoid " + enemy.getName() + "'s " + reaction.spellName() + "!");
            player.setTempHP(player.getTempHP() + (reaction.spellDamagePotential() - (enemy.getAtk() / 5)) + (player.getDef() / 10));
            player.showHP();
            if(player.getTempHP() < 1) {
               //Player dies
               player.setTempHP(0);
               System.out.println("Oh no! You have been slain by " + enemy.getName() + "...");
            }   
         } else {
            //Enemy attacks second, attack fails
            System.out.println("\nYou managed to dodge " + enemy.getName() + "'s " + reaction.spellName() + "!");
           }
      } else { 
         //Enemy attacks first
         System.out.println("\n" + enemy.getName() + " attacked you with " + reaction.spellName() + "!");
         
         if(accuracyCheck(reaction)) {
            //Enemy attacks first, attack succeeds
            System.out.println("\nYou couldn't avoid " + enemy.getName() + "'s " + reaction.spellName() + "!");
            player.setTempHP(player.getTempHP() + (reaction.spellDamagePotential() - (enemy.getAtk() / 5)) + (player.getDef() / 10));
            player.showHP();
            if(player.getTempHP() < 1) {
               //Player dies
               player.setTempHP(0);
               System.out.println("Oh no! You have been slain by " + enemy.getName() + "...");
            }
            
            //Player casts second
            System.out.println("\n" + player.getName() + " used " + action.spellName() + " to change the tide of battle!");
            //HP & SP Costs of spells deducted
            player.setTempSP(player.getTempSP() + action.spellCostSP());
            if(player.getTempSP() <= 0) {
               player.setTempSP(0);
            }
            player.setTempHP(player.getTempHP() + action.spellCostHP());
            player.showHP();
            player.showSP();
            
            if(accuracyCheck(action)) {
               //Player casts second, casting succeeds
               switch(action.spellSubCategory()) {
                  case "AttackBuff":
                     System.out.println("\n" + player.getName() + " increased their attack!");
                     player.setTempAtk((int)(player.getTempAtk() * 1.2));
                     break;
                  case "DefenseBuff":
                     System.out.println("\n" + player.getName() + " increased their defense!");
                     player.setTempDef((int)(player.getTempDef() * 1.2));
                     break;
                  case "SpeedBuff":
                     System.out.println("\n" + player.getName() + " increased their speed!");
                     player.setTempSpd((int)(player.getTempSpd() * 1.5));
                     break;
                  case "AttackNerf":
                     System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s attack!");
                     enemy.setTempAtk((int)(enemy.getTempAtk() * 0.8));
                     break;
                  case "DefenseNerf":
                     System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s defense!");
                     enemy.setTempDef((int)(enemy.getTempDef() * 0.8));
                     break;
                  case "SpeedNerf":
                     System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s speed!");
                     enemy.setTempSpd((int)(enemy.getTempSpd() * 0.75));
                     break;
                  case "Heal":
                     System.out.println("\n" + player.getName() + " is healed for " + action.spellDamagePotential() + " HP!");
                     player.setTempHP(player.getTempHP() + action.spellDamagePotential());
                     //Prevents overheals
                     if(player.getTempHP() > player.getHP()) {
                        player.setTempHP(player.getHP());
                     }
                     player.showHP();
                     break;
               }
               } else {
                  //Player casts second, casting fails
                  System.out.println("... but it failed in casting!");
                 }
         } else {
            //Enemy attacks first, attack fails
            System.out.println("\nYou managed to dodge " + enemy.getName() + "'s " + reaction.spellName() + "!");
            
            //Player casts second
            System.out.println("\n" + player.getName() + " used " + action.spellName() + " to change the tide of battle!");
            //HP & SP Costs of spells deducted
            player.setTempSP(player.getTempSP() + action.spellCostSP());
            if(player.getTempSP() <= 0) {
               player.setTempSP(0);
            }
            player.setTempHP(player.getTempHP() + action.spellCostHP());
            player.showHP();
            player.showSP();
         
            if(accuracyCheck(action)) {
               //Player casts second, casting succeeds
               switch(action.spellSubCategory()) {
                  case "AttackBuff":
                     System.out.println("\n" + player.getName() + " increased their attack!");
                     player.setTempAtk((int)(player.getTempAtk() * 1.2));
                     break;
                  case "DefenseBuff":
                     System.out.println("\n" + player.getName() + " increased their defense!");
                     player.setTempDef((int)(player.getTempDef() * 1.2));
                     break;
                  case "SpeedBuff":
                     System.out.println("\n" + player.getName() + " increased their speed!");
                     player.setTempSpd((int)(player.getTempSpd() * 1.5));
                     break;
                  case "AttackNerf":
                     System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s attack!");
                     enemy.setTempAtk((int)(enemy.getTempAtk() * 0.8));
                     break;
                  case "DefenseNerf":
                     System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s defense!");
                     enemy.setTempDef((int)(enemy.getTempDef() * 0.8));
                     break;
                  case "SpeedNerf":
                     System.out.println("\n" + player.getName() + " decreased " + enemy.getName() + "'s speed!");
                     enemy.setTempSpd((int)(enemy.getTempSpd() * 0.75));
                     break;
                  case "Heal":
                     System.out.println("\n" + player.getName() + " is healed for " + action.spellDamagePotential() + " HP!");
                     player.setTempHP(player.getTempHP() + action.spellDamagePotential());
                     //Prevents overheals
                     if(player.getTempHP() > player.getHP()) {
                        player.setTempHP(player.getHP());
                     }
                     player.showHP();
                     break;
               }
            } else {
               //Player casts second, casting fails
               System.out.println("... but it failed in casting!");
              }
           }
        }
   }
   
   public void parrySpell(PlayerCharacter player, NPC enemy, Spell action) {
      //Randomly chooses a spell from the enemy's inventory to use
      enemyAI(enemy);
      
      //Calculates a sum of both spell's and both player's offensive and defensive capabilities
      //The higher value is reduced from the opposing player's HP
      int playerPower = player.getTempDef() + player.getTempAtk() + action.spellProtectPotential() - action.spellDamagePotential();
      boolean playerSuccess = accuracyCheck(action);
      System.out.println("\n" + player.getName() + "'s Power: " + playerPower);
      if(playerSuccess) {
         System.out.println(player.getName() + "'s Casting: Pass");
      } else {
         System.out.println(player.getName() + "'s Casting: Fail");
        }
      
      int enemyPower = enemy.getTempDef() + enemy.getTempAtk() + reaction.spellProtectPotential() - reaction.spellDamagePotential();
      boolean enemySuccess = accuracyCheck(reaction);
      System.out.println(enemy.getName() + "'s Power: " + enemyPower);
      if(enemySuccess) {
         System.out.println(enemy.getName() + "'s Casting: Pass");
      } else {
         System.out.println(enemy.getName() + "'s Casting: Fail");
        }
      
      //Whoever goes first is irrelevant
      System.out.println("\n" + player.getName() + " attempted to counter " + enemy.getName() + "'s spell by using " + action.spellName() + "!");
      //HP & SP Costs of spells deducted
      player.setTempSP(player.getTempSP() + action.spellCostSP());
      if(player.getTempSP() <= 0) {
         player.setTempSP(0);
      }
      player.setTempHP(player.getTempHP() + action.spellCostHP());
      player.showHP();
      player.showSP();
      
      if(playerSuccess) {
         if(!(enemySuccess)) {
            //Player succeeds, enemy fails
            System.out.println("\n" + player.getName() + " successfully countered " + enemy.getName() + "!");
            enemy.setTempHP(enemy.getTempHP() - playerPower);
            enemy.showHP();
            if(enemy.getTempHP() < 1) {
               //Enemy dies
               enemy.setTempHP(0);
               System.out.println(enemy.getName() + " has been slain!");
            }
         } else if(playerPower > enemyPower) {
                   //Both succeed, but player's value is higher
                   System.out.println("\n" + player.getName() + " successfully countered " + enemy.getName() + "!");
                   enemy.setTempHP(enemy.getTempHP() - playerPower);
                   enemy.showHP();
                   if(enemy.getTempHP() < 1) {
                      //Enemy dies
                      enemy.setTempHP(0);
                      System.out.println(enemy.getName() + " has been slain!");
                   }
                } else { 
                     //Both succeed, but enemy's value is higher
                     System.out.println("\nYour counter was unsuccessfull! " + enemy.getName() + "'s spell struck your weak point dealing " + enemyPower + " points of damage!");
                     player.setTempHP(player.getTempHP() - enemyPower);
                     player.showHP();
                     if(player.getTempHP() < 1) {
                        //Player dies
                        player.setTempHP(0);
                        System.out.println("Oh no! You have been slain by " + enemy.getName() + "...");
                     }
                  }
      } else {
         //Player's counter fails, enemy instantly succeeds
         System.out.println("\nThe counter failed entirely! " + enemy.getName() + "'s spell struck your weak point dealing " + enemyPower + " points of damage!");
         player.setTempHP(player.getTempHP() - enemyPower);
         player.showHP();
         if(player.getTempHP() < 1) {
            //Player dies
            player.setTempHP(0);
            System.out.println("Oh no! You have been slain by " + enemy.getName() + "...");
         }
        }
   }
   
   
   public void enemyAI(NPC artificialIntelligence) {
      //Determines the enemy's spell action
      int enemyChoice = (int)(Math.random() * 5);
      reaction = artificialIntelligence.wand[enemyChoice];
   }
   
   public boolean accuracyCheck(Spell check) {
      //random check of spell's accuracy to determine whether or not a spell succeeds
      int accCheck = (int)(Math.random() * 101 + 1);
      if(check.spellAccuracy() >= accCheck) {
         return true;
      } else {
         return false;
        }
   }
   
   public void restoreSP(PlayerCharacter player, NPC enemy) {
      //Restores SP only if the battle is still ongoing
      if(player.getTempHP() >= 1 && enemy.getTempHP() >= 1) {
         //1/10th of the player's max SP is restored each turn
         int restore = player.getSP() / 10;
         player.setTempSP(player.getTempSP() + restore);
         if(player.getTempSP() > player.getSP()) {
            player.setTempSP(player.getSP());
         }
         System.out.println("\n" + player.getName() + "'s SP has been restored by " + restore + " points!");
         player.showSP();
      }
   }
   
}  