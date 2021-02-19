public class BaseTile extends Tile 
{
  protected int tileId;

  public BaseTile(int id, int x, int y, int levelColor)
  {
    super(id, false, false, levelColor);
    this.tileId = x + y;
  }
  
  public void render(Screen screen, Level level, int x, int y)
  {
    screen.render(0, x, y, tileId, 0x00, 1);
  }
}