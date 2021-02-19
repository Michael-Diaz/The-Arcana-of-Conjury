public class BaseSolidTile extends BaseTile
{
  public BaseSolidTile(int id, int x, int y, int levelColor)
  {
    super(id, x, y, levelColor);
    this.solid = true;
  }
}