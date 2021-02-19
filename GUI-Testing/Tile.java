public abstract class Tile
{
  public static final Tile[] tiles = new Tile[256];
  
  public static final Tile VOID = new BaseSolidTile(0, 0, 0, 0xFF000000);
  public static final Tile STONE = new BaseSolidTile(1, 1, 0, 0xFF883300);
  public static final Tile GRASS = new BaseTile(2, 2, 0, 0xFF00DD00);
  public static final Tile FLOOR1 = new BaseTile(3, 3, 0, 0xFFDD0000);
  public static final Tile FLOOR2 = new BaseTile(4, 4, 0, 0xFFEE6600);
  
  protected byte id;
  protected boolean solid;
  protected boolean emitter;
  private int levelColor;
  
  public Tile(int id, boolean isSolid, boolean isEmitter, int levelColor)
  {
    this.id = (byte) id;
    if (tiles[id] != null)
      throw new RuntimeException("Duplicate tile id on " + id);
    this.solid = isSolid;
    this.emitter = isEmitter;
    this.levelColor = levelColor;
    tiles[id] = this; 
  }
  
  public byte getId()
  {
    return id;
  }
  
  public boolean isSolid()
  {
    return solid;
  }
  
  public boolean isEmitter()
  {
    return emitter;
  }
  
  public int getLevelColor()
  {
    return levelColor;
  }
  
  public abstract void render(Screen screen, Level level, int x, int y);
}