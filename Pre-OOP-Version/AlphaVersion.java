import java.util.Scanner;
public class AlphaVersion {
   static Scanner userInput = new Scanner(System.in);
   
   static PlayerCharacter Tester = new PlayerCharacter(0, 1, 150, 150, 50, 50, 20, 20, 20, 20, 10, 10);
   static NPC Rival = new NPC();
   
   static Spell Null = new Spell("Empty", "None", "None", "None", "None", 0, 0, 0, 0, 0);
   
   static TheArcanaOfConjury game = new TheArcanaOfConjury();
   
   public static void main(String[] args) {
      //game.createAndShowGUI();
      greeting();
      startup();
      beginning();
   }
   
   public static void greeting() { 
      System.out.println("Welcome to the Alpha Version of 'The Arcana of Conjury,' a turn-based combat magic RPG!");
      System.out.println("This is a barebones version I have developed in order to make sure that the game's core functions are working properly.");
      System.out.println("Thank you for testing and be sure to let me know if anything seems off!");
      System.out.println("\t~Michael [Micle] Diaz");
      System.out.println("\n. . . \n");
   }
   
   public static void startup() {
      for(int i = 0; i < 5; i++) {
         Tester.wand[i] = Null;
      }
   }
   
   //initialize every spell, then assign each one to subsequent arrays by type, NOT domain
   static Spell FireSpell01 = new Spell("Fireball", "Attack", "None", "Fire", "Alchemist", 0, -5, 95, -20, 0);
   static Spell FireSpell02 = new Spell("Wall of Fire", "Defend", "None", "Fire", "Alchemist", 0, -7, 100, 0, 35);
   static Spell FireSpell03 = new Spell("Ignite", "Attack", "None", "Fire", "Alchemist", 0, -1, 67, -5, 0);
   static Spell FireSpell04 = new Spell("Explosion", "Attack", "None", "Fire", "Alchemist", 0, -12, 50, -45, 0);
   static Spell FireSpell05 = new Spell("Heat Wave", "Attack", "None", "Fire", "Alchemist", 0, -10, 80, -30, 0);
   static Spell FireSpell06 = new Spell("Conflagration", "Attack", "None", "Fire", "Alchemist", 0, -15, 20, -75, 0);
   static Spell FireSpell07 = new Spell("Illuminate", "Status", "AttackNerf", "fire", "Alchemist", 0, -3, 90, 0, 0);
   static Spell FireSpell08 = new Spell("Combust", "Attack", "None", "Fire", "Alchemist", 0, -9, 33, -60, 0);
   static Spell FireSpell09 = new Spell("Inflame", "Status", "AttackBuff", "Fire", "Alchemist", -5, -1, 100, 0, 0);
   static Spell FireSpell10 = new Spell("Rebirth", "Status", "Heal", "Fire", "Alchemist", -50, -20, 95, 150, 0);
   static Spell FireSpell11 = new Spell("Cauterize", "Status", "Heal", "Fire", "Alchemist", -5, -5, 100, 25, 0);
   static Spell FireSpell12 = new Spell("Vaporize", "Status", "DefenseNerf", "Fire", "Alchemist", 0, -7, 75, 0, 0);
   //This is just a small test
   
   static String name;
   static String confirmation;
   public static void beginning() {
      System.out.println("Welcome to the Introductory Academy of Magick!");
      System.out.println("I am the head of this institution, Persephone Wintercrest; what is your name, young one?");
      name = userInput.nextLine();
      Tester.setName(name);
      System.out.println("You said your name was " + Tester.getName() + "? [Yes, No]");
      confirmation = userInput.nextLine(); 
      confirmation = confirmation.toUpperCase();
      switch(confirmation) {
         case "Y":
         case "YES":
            break;
         case "N":
         case "NO":
            reAskName();
            break;
         default:
            System.out.println("I'm sorry, dear, did you say something?");
            reAskName();
      }
      System.out.println("Ah, my apologies; my ears appear to be failing me in my old age, haha!"); 
      System.out.println("But regardless- " + Tester.getName() + "- what a lovely name! \n");
      System.out.println("Everyone at this institute specializes in some form of Magick, " + Tester.getName() + ":");
      System.out.println("The Alchemists utilize their own life energy to shape the 4 elements in the natural world,");
      System.out.println("The Wizards draw from the life force derived from their surroundings to warp reality to an extent,");
      System.out.println("The Shamans speak an ancient yet powerful language to influence those who are exposed to it,");
      System.out.println("The Witch Doctors dance on the boundries between this world and the occult, making pacts to enforce their ideals");
      System.out.println("The Enchanters tap into the minds of others in order to twist and distort their perceptions");
      System.out.println("And the Summoners toy with the line seperating life and death, creating and destorying on a whim. \n");
      choosePath();
   }
   
   public static void reAskName() {
      System.out.println("Oh, my apologies, could you say your name again for me?");
      name = userInput.nextLine();
      Tester.setName(name);
      System.out.println("So your name is " + Tester.getName() + "? [Yes, No]");
      confirmation = userInput.nextLine();
      confirmation = confirmation.toUpperCase();
      switch(confirmation) {
         case "Y":
         case "YES":
            break;
         case "N":
         case "NO":
           reAskName();
           break;
         default:
            System.out.println("I'm sorry, dear, did you say something?");
            reAskName();
      }
   }
   
   
   public static void choosePath() {
      System.out.println("Which branch of Magick are you here to study, young " + Tester.getName() + "? [Alchemist, Wizard, Shaman, Witch Doctor, Enchanter, Summoner]");
      String magicChoice = userInput.nextLine();
      magicChoice = magicChoice.toUpperCase();
      switch(magicChoice) {
         case "ALCHEMIST":
            Tester.setDomain("Alchemist");
            System.out.println("An Alchemist? ...How intriguing!");
            System.out.println("I'll refer you to our head Alchemist, {alch p/h} to train you at once!");
            System.out.println("Worry not, young " + Tester.getName() + ", they're our best and brightest!");
            System.out.println("\n. . . \n");
            alchemistPath();
            break;
         case "WIZARD":
            Tester.setDomain("Wizard");
            System.out.println("A Wizard? ...How intriguing!");
            System.out.println("I'll refer you to our head Wizard, {wiz p/h} to train you at once!");
            System.out.println("Worry not, young " + Tester.getName() + ", they're our best and brightest!");
            System.out.println("\n. . . \n");
            wizardPath();
            break;
         case "SHAMAN":
            Tester.setDomain("Shaman");
            System.out.println("A Shaman? ...How intriguing!");
            System.out.println("I'll refer you to our head Shaman, {sham p/h} to train you at once!");
            System.out.println("Worry not, young " + Tester.getName() + ", they're our best and brightest!");
            System.out.println("\n. . . \n");
            shamanPath();
            break;
         case "WITCH DOCTOR":
            Tester.setDomain("Witch Doctor");
            System.out.println("A Witch Doctor? ...How intriguing!");
            System.out.println("I'll refer you to our head Witch Doctor, {witch p/h} to train you at once!");
            System.out.println("Worry not, young " + Tester.getName() + ", they're our best and brightest!");
            System.out.println("\n. . . \n");
            witchDoctorPath();
            break;
         case "ENCHANTER":
            Tester.setDomain("Enchanter");
            System.out.println("An Enchanter? ...How intriguing!");
            System.out.println("I'll refer you to our head Enchanter, Ishani Maya to train you at once!");
            System.out.println("Worry not, young " + Tester.getName() + ", they're our best and brightest!");
            System.out.println("\n. . . \n");
            enchanterPath();
            break;
         case "SUMMONER":
            Tester.setDomain("Summoner");
            System.out.println("A Witch Doctor? ...How intriguing!");
            System.out.println("I'll refer you to our head Summoner, {summ p/h} to train you at once!");
            System.out.println("Worry not, young " + Tester.getName() + ", they're our best and brightest!");
            System.out.println("\n. . . \n");
            summonerPath();
            break;
         default:
            System.out.println("I'm sorry, I couldn't quite get that- could you repeat what you said, dear?\n");
            choosePath();
      }
   }
   
   static boolean beginExhibition = false;
   
   public static void alchemistPath() {
      Rival.setName("{rival alch p/h}");
      Rival.setHP(150);
      Rival.setTempHP(150);
      Rival.setAtk(20);
      Rival.setTempAtk(20);
      Rival.setDef(20);
      Rival.setTempDef(20);
      Rival.setSpd(10);
      Rival.setTempSpd(10);
      Rival.learnSpell(FireSpell01);
      Rival.learnSpell(FireSpell05);
      Rival.learnSpell(FireSpell03);
      Rival.learnSpell(FireSpell08);
      Rival.learnSpell(FireSpell06);
      Rival.wand[0] = FireSpell01;
      Rival.wand[1] = FireSpell05;
      Rival.wand[2] = FireSpell03;
      Rival.wand[3] = FireSpell08;
      Rival.wand[4] = FireSpell06;
      
      System.out.println("Oh, hello. You must be " + Tester.getName() + "- according to Headmistress Wintercrest I will be tutoring you.");
      System.out.println("Take a seat, and I will gladly instruct you in the ways of an Alchemist; \n");
      System.out.println("It is typically agreed that in the natural world is composed of four natural elements: Air, Earth, Fire, and Water. \n");
      System.out.println("However, there is a fifth element that is hinted at throughout various cultures. We Alchemists call it the Aether. \n");
      
      
      //System.out.println("Rest of backstory for Respective class, etc., etc.");
      //System.out.println("Something about letting the student learn from the grand spellbook of the teaching, equip them then talk to the teacher again");
      
      Tester.learnSpell(FireSpell01);
      Tester.learnSpell(FireSpell02);
      Tester.learnSpell(FireSpell03);
      Tester.learnSpell(FireSpell04);
      Tester.learnSpell(FireSpell05);
      Tester.learnSpell(FireSpell06);
      Tester.learnSpell(FireSpell07);
      Tester.learnSpell(FireSpell08);
      Tester.learnSpell(FireSpell09);
      Tester.learnSpell(FireSpell10);
      Tester.learnSpell(FireSpell11);
      Tester.learnSpell(FireSpell12);
 
      preFightPrep();
      
      System.out.println("\n. . .\n");
      
      beginFight();
      
   }
   
   public static void wizardPath() {
      Rival.setName("{rival wiz p/h}");
      System.out.println(Tester.getName() + ", welcome! I was told that I'd have the honor of training you by Headmistress Wintercrest herself!");
      System.out.println("Let me give you an overview of the practices of a Wizard and what we truly are; \n");
   }
   
   public static void shamanPath() {
      Rival.setName("{rival sham p/h}");
      System.out.println("shamanTest");
   }
   
   public static void witchDoctorPath() {
      Rival.setName("{rival witch p/h}");
      System.out.println("Ah, welcome, " + Tester.getName() + ". Headmistress Wintercrest notified me of your admittance under my wing.");
      System.out.println("So you wish to learn to become a fully-fledged Witch Doctor, do you? very well- listen closely; \n");
      System.out.println("Contary to popular belief, the practice of a Witch Doctor is not as taboo as the rest of the world makes us out to be. \n");
      System.out.println("");
   }
   
   public static void enchanterPath() {
      Rival.setName("{rival ench p/h}");
      System.out.println("Oh, " + Tester.getName() + ", come in, come in! I overheard Headmistress Wintercrest's conversation with you!");
      System.out.println("Your desire to become and Enchanter is quite obvious, so allow me to give an introduction; \n");
      System.out.println("The mind truly is an incredible thing in itself- after all, it houses the enirety of our being from birth to death. \n");
      System.out.println();
      
   }
   
   public static void summonerPath() {
      Rival.setName("{rival summ p/h}");
      System.out.println("summonerTest");
   }
   
   
   public static void preFightPrep() {
      while(!beginExhibition) {
            System.out.println("\nWhat action will you take? [Learn, Equip, Speak, Fight]");
            String option = userInput.nextLine();
            option = option.toUpperCase();
            switch(option) {
               case "LEARN":
                  learnOption();
                  break;
               case "EQUIP":
                  equipOption();
                  break;
               case "SPEAK":
                  speakOption();
                  break;
               case "FIGHT":
                  boolean pass = true;
                  for(int i = 0; i < 5; i++) { 
                     if(Tester.wand[i].spellName().equals("Empty")) {
                        pass = false;
                     }
                  }
                  if(pass) {
                     beginExhibition = true;
                  } else {
                        System.out.println("Make sure all your wand slots are filled before sparring!");
                        preFightPrep();
                    }
                  break;
               default:
                  System.out.println("Unknown command. Enter in a command given by the following prompt:");
            }
      }
   }
         
   public static void learnOption() {
      Tester.displayLearnedSpells();
      System.out.println("Which spell would you like to learn more about, or would you rather return to the other options? [(Spell name), Return]");
      String select = userInput.nextLine();
      String tempSelect = select;
      select = select.toUpperCase();
      switch(select) {
         case "RETURN":
            break;
         default:
            select = select.toLowerCase();
            boolean notFound = true;
            for(int i = 0; i < Tester.spellbook.size(); i++) {
               if(select.equals(Tester.spellbook.get(i).spellName().toLowerCase())) {
                  Tester.spellbook.get(i).showSpellStats();
                  notFound = false;
               }
            }
            if(notFound) {
               System.out.println("There is no spell by the name of " + tempSelect + " in your spellbook!");
            }
      }
   }
   
   public static void equipOption() {
      Tester.displayLearnedSpells();
      System.out.println("Which spell would you like to equip to your wand, or would you rather return to the other options? [(Spell name), Return]");
      Spell tempSpell = Null;
      String select = userInput.nextLine();
      String tempSelect = select;
      select = select.toUpperCase();
      switch(select) {
         case "RETURN":
            break;
         default:
            select = select.toLowerCase();
            boolean notFound = true;
            for(int i = 0; i < Tester.spellbook.size(); i++) {
               if(select.equals(Tester.spellbook.get(i).spellName().toLowerCase())) {
                  tempSpell = Tester.spellbook.get(i);
                  notFound = false;
               }
            }
            if(notFound) {
               System.out.println("There is no spell by the name of " + tempSelect + " in your spellbook!");
               break;
            }
            Tester.displayEquippedSpells();
            System.out.println("Which slot would you like to equip " + tempSpell.spellName() + " to, or would you rather return to the other options? [(1 - 5), Return]");
            int slotOption;
            select = userInput.nextLine();
            select = select.toUpperCase();
            switch(select) {
               case "RETURN":
                  break;
               default:
                  slotOption = Integer.parseInt(select);
                  if(slotOption < 1 || slotOption > 5) {
                     System.out.println("You can only equip " + tempSpell.spellName() + " to slots 1 through 5!");
                     break;
                  }
                  Tester.equipSpell(tempSpell, slotOption);
            }
      }

   }
   
   public static void speakOption() {
      int phraseSelection = (int)(Math.random() * 3 + 1);
      switch(Tester.getDomain()) {
         case "Alchemist":
            switch(phraseSelection) {
               case 1:
                  System.out.println("\n. . . \n");
                  System.out.println("alchemistTest1");
                  System.out.println("\n. . . ");
                  break;
               case 2:
                  System.out.println("\n. . . \n");
                  System.out.println("alchemistTest2");
                  System.out.println("\n. . . ");
                  break;
               case 3:
                  System.out.println("\n. . . \n");
                  System.out.println("alchemistTest3");
                  System.out.println("\n. . . ");
                  break;
            }
            break;
         case "Wizard":
            switch(phraseSelection) {
               case 1:
                  System.out.println("\n. . . \n");
                  System.out.println("wizardTest1");
                  System.out.println("\n. . . ");
                  break;
               case 2:
                  System.out.println("\n. . . \n");
                  System.out.println("wizardTest2");
                  System.out.println("\n. . . ");
                  break;
               case 3:
                  System.out.println("\n. . . \n");
                  System.out.println("wizardTest3");
                  System.out.println("\n. . . ");
                  break;
            }
            break;
         case "Shaman":
            switch(phraseSelection) {
               case 1:
                  System.out.println("\n. . . \n");
                  System.out.println("shamanTest1");
                  System.out.println("\n. . . ");
                  break;
               case 2:
                  System.out.println("\n. . . \n");
                  System.out.println("shamanTest2");
                  System.out.println("\n. . . ");
                  break;
               case 3:
                  System.out.println("\n. . . \n");
                  System.out.println("shamanTest3");
                  System.out.println("\n. . . ");
                  break;
            }
            break;
         case "Witch Doctor":
            switch(phraseSelection) {
               case 1:
                  System.out.println("\n. . . \n");
                  System.out.println("witchDocTest1");
                  System.out.println("\n. . . ");
                  break;
               case 2:
                  System.out.println("\n. . . \n");
                  System.out.println("witchDocTest2");
                  System.out.println("\n. . . ");
                  break;
               case 3:
                  System.out.println("\n. . . \n");
                  System.out.println("witchDocTest3");
                  System.out.println("\n. . . ");
                  break;
            }
            break;
         case "Enchanter":
            switch(phraseSelection) {
               case 1:
                  System.out.println("\n. . . \n");
                  System.out.println("enchanterTest1");
                  System.out.println("\n. . . ");
                  break;
               case 2:
                  System.out.println("\n. . . \n");
                  System.out.println("enchanterTest2");
                  System.out.println("\n. . . ");
                  break;
               case 3:
                  System.out.println("\n. . . \n");
                  System.out.println("enchanterTest3");
                  System.out.println("\n. . . ");
                  break;
            }
            break;
         case "Summoner":
            switch(phraseSelection) {
               case 1:
                  System.out.println("\n. . . \n");
                  System.out.println("summonerTest1");
                  System.out.println("\n. . . ");
                  break;
               case 2:
                  System.out.println("\n. . . \n");
                  System.out.println("summonerTest2");
                  System.out.println("\n. . . ");
                  break;
               case 3:
                  System.out.println("\n. . . \n");
                  System.out.println("summonerTest3");
                  System.out.println("\n. . . ");
                  break;
            }
            break;
      }
   }
   
   public static void beginFight() {
      CombatSystem CS = new CombatSystem();
      System.out.println(Rival.getName() + " challenges you to a duel!");
      while(Tester.getTempHP() > 0 && Rival.getTempHP() > 0) {
         CS.prompt(Tester, Rival);
      }
   }
   
}