public class SpellList {
   public void nullSpells() {
      //The order of spell characteristics is Name, Category, Subcategory, Type, Branch, Health Cost, Mana Cost, Accuracy, Damage, Protection
      Spell Null = new Spell("Empty", "None", "None", "None", "None", 0, 0, 0, 0, 0);    
   }

   public void alchemistSpells() {
      Spell FireSpell01 = new Spell("Fireball", "Attack", "None", "Fire", "Alchemist", 0, -5, 95, -20, 0);
      Spell FireSpell02 = new Spell("Wall of Fire", "Defend", "None", "Fire", "Alchemist", 0, -7, 100, 0, 35);
      Spell FireSpell03 = new Spell("Ignite", "Attack", "None", "Fire", "Alchemist", 0, -1, 67, -5, 0);
      Spell FireSpell04 = new Spell("Explosion", "Attack", "None", "Fire", "Alchemist", 0, -12, 50, -45, 0);
      Spell FireSpell05 = new Spell("Heat Wave", "Attack", "None", "Fire", "Alchemist", 0, -10, 80, -30, 0);
      Spell FireSpell06 = new Spell("Conflagration", "Attack", "None", "Fire", "Alchemist", 0, -15, 20, -75, 0);
      Spell FireSpell07 = new Spell("Illuminate", "Status", "AttackNerf", "fire", "Alchemist", 0, -3, 90, 0, 0);
      Spell FireSpell08 = new Spell("Combust", "Attack", "None", "Fire", "Alchemist", 0, -9, 33, -60, 0);
      Spell FireSpell09 = new Spell("Inflame", "Status", "AttackBuff", "Fire", "Alchemist", -5, -1, 100, 0, 0);
      Spell FireSpell10 = new Spell("Rebirth", "Status", "Heal", "Fire", "Alchemist", -50, -20, 95, 150, 0);
      Spell FireSpell11 = new Spell("Cauterize", "Status", "Heal", "Fire", "Alchemist", -5, -5, 100, 25, 0);
      Spell FireSpell12 = new Spell("Vaporize", "Status", "DefenseNerf", "Fire", "Alchemist", 0, -7, 75, 0, 0);
      
      Spell WaterSpell01 = new Spell("Freeze", "Status", "SpeedNerf", "Water", "Alchemist", 0, -3, 33, 0, 0);
      Spell WaterSpell02 = new Spell("Icicle", "Attack", "None", "Water", "Alchemist", 0, -7, 80, -30, 0);
      Spell WaterSpell03 = new Spell("Revitalizing Waters", "Status", "Heal", "Water", "Alchemist", 0, -12, 90, 40, 0);
      Spell WaterSpell04 = new Spell("Maelstrom", "Attack", "None", "Water", "Alchemist", 0, -10, 50, -30, 0);
      /* Spell WaterSpell05;
      Spell WaterSpell06;
      Spell WaterSpell07;
      Spell WaterSpell08;
      Spell WaterSpell09;
      Spell WaterSpell10;
      Spell WaterSpell11;
      Spell WaterSpell12;
      
      Spell EarthSpell01;
      Spell EarthSpell02;
      Spell EarthSpell03;
      Spell EarthSpell04;
      Spell EarthSpell05;
      Spell EarthSpell06;
      Spell EarthSpell07;
      Spell EarthSpell08;
      Spell EarthSpell09;
      Spell EarthSpell10;
      Spell EarthSpell11;
      Spell EarthSpell12; */
      
      Spell AirSpell01 = new Spell("Aeration", "Status", "SpeedBuff", "Air", "Alchemist", 0, 3, 100, 0, 0);
      /* Spell AirSpell02;
      Spell AirSpell03;
      Spell AirSpell04;
      Spell AirSpell05;
      Spell AirSpell06;
      Spell AirSpell07;
      Spell AirSpell08;
      Spell AirSpell09;
      Spell AirSpell10;
      Spell AirSpell11;
      Spell AirSpell12;
      
      Spell AetherSpell01;
      Spell AetherSpell02;
      Spell AetherSpell03;
      Spell AetherSpell04;
      Spell AetherSpell05;
      Spell AetherSpell06;
      Spell AetherSpell07;
      Spell AetherSpell08;
      Spell AetherSpell09;
      Spell AetherSpell10;
      Spell AetherSpell11;
      Spell AetherSpell12; */
   }
}