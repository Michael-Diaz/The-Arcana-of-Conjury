public class Gamer extends Mob
{
  private InputHandler input;
  private int scale = 1;

  public Gamer(Level level, int x, int y, InputHandler input)
  {
    super(level, "Player", x, y, 1);
    this.input = input;
  }
  
  public void tick()
  {
    int xa = 0, ya = 0;
    
    if (input.up.isPressed())
       ya--;
    if (input.down.isPressed())
       ya++;
    if (input.left.isPressed())
       xa--;
    if (input.right.isPressed())
       xa++;
       
    if (xa != 0 || ya != 0)
    {
      move(xa, ya);
      isMoving = true;
    }
    else
      isMoving = false;
  }
  
  public void render(Screen screen)
  {
    int xTile = 0;
    int yTile = 0;
    
    int walkingSpeed = 4;
    
    int flip = (numSteps >> walkingSpeed) & 1;
    
    if (movingDir == 0)
      xTile += 2;
    else if (movingDir > 1)
    {
      flip = (movingDir - 1) % 2;
    }
    
    int modifier = 8 * scale;
    int xOffset = x - modifier / 2;
    int yOffset = y - modifier / 2 - 4;
    
    screen.render(1, xOffset + (modifier * flip), yOffset, xTile + yTile * 32, flip, scale);
    screen.render(1, xOffset + modifier - (modifier * flip), yOffset, (xTile + 1) + yTile * 32, flip, scale);
    screen.render(1, xOffset + (modifier * flip), yOffset + modifier, xTile + (yTile + 1) * 32, flip, scale);
    screen.render(1, xOffset + modifier - (modifier * flip), yOffset + modifier, (xTile + 1) + (yTile + 1) * 32, flip, scale);
    screen.render(1, xOffset + (modifier * flip), yOffset + modifier * 2, xTile + (yTile + 2) * 32, flip, scale);
    screen.render(1, xOffset + modifier - (modifier * flip), yOffset + modifier * 2, (xTile + 1) + (yTile + 2) * 32, flip, scale);
    screen.render(1, xOffset + (modifier * flip), yOffset + modifier * 3, xTile + (yTile + 3) * 32, flip, scale);
    screen.render(1, xOffset + modifier - (modifier * flip), yOffset + modifier * 3, (xTile + 1) + (yTile + 3) * 32, flip, scale);
  }
  
  public boolean hasCollided(int xa, int ya)
  {
    int xMin = 0;
    int xMax = 7;
    int yMin = 19;
    int yMax = 23;
    
    for (int x = xMin; x < xMax; x++)
    {
      if (isSolidTile(xa, ya, x, yMin))
        return true;
    }
    for (int x = xMin; x < xMax; x++)
    {
      if (isSolidTile(xa, ya, x, yMax))
        return true;
    }
    for (int y = yMin; y < yMax; y++)
    {
      if (isSolidTile(xa, ya, xMin, y))
        return true;
    }
    for (int y = yMin; y < yMax; y++)
    {
      if (isSolidTile(xa, ya, xMax, y))
        return true;
    }
    
    return false;
  }
}