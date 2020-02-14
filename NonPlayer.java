import java.util.*;

public class NonPlayer extends Character
{
  // Gives a randomly generated sequence of dialouge that varies with the NPC domain
  public void giveDialogue()
  {
    int chooseLine = (int)(Math.random() * 3);

    switch (chooseLine)
    {
      case 0:
        System.out.println("Hi, I'm " + getName() +
                           ", pleased to make your acquaintance!");
        break;
      case 1:
        System.out.println("I'm currently a Rank " + rank +
                           " " + domain.substring(0, 1).toUpperCase() +
                           domain.substring(1) + ", but my studies are far from over.");
        break;
      case 2:
        System.out.println("I'm so glad I chose to study among other " +
                           domain.substring(0, 1).toUpperCase() +
                           domain.substring(1) + "s; I really feel like I'm in my element!");
        break;
    }
  }

  // Allows rapid and accurate level scaling of NPCs by repeated calling of the levelUp
  // function in the Character class
  public void increaseToLvl(int level)
  {
    if (level > this.level)
    {
      int iterations = level - this.level;
      for (int i = 0; i < iterations; i++)
      {
        increaseLevel();
      }
    }
  }


  NonPlayer()
  {
    level = 1;
    rank = 0;
    modifiers = 0;
    effects = 0;
  }

  NonPlayer(String domain, int modifiers, int effects, Map<String, Integer> stats)
  {
    level = 1;
    rank = 0;

    this.domain = domain;
    this.modifiers = modifiers;
    this.effects = effects;
    this.stats = stats;
  }
}
