public class Screen
{
  public static final int MAP_WIDTH = 64;
  public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;
  
  public static final byte BIT_MIRROR_X = 0x01;
  public static final byte BIT_MIRROR_Y = 0x02;
  
  public int[] pixels;
  
  public int xOffset = 0;
  public int yOffset = 0;
  
  public int width;
  public int height;
  
  public SpriteSheet sheetTiles;
  public SpriteSheet sheetFont;
  public SpriteSheet sheetPlayer;
  
  public Screen(int width, int height, SpriteSheet sheetTiles, SpriteSheet sheetPlayer)
  {
    this.width = width;
    this.height = height;
    
    this.sheetTiles = sheetTiles;
    //this.sheetFont = sheetFont;
    this.sheetPlayer = sheetPlayer;
    
    pixels = new int[width * height];
  }
  
  public void render(int sheetCode, int xPos, int yPos, int tile, int mirrorDir, int scale)
  {
    SpriteSheet sheet;
    
    switch (sheetCode)
    {
      case 0:
        sheet = sheetTiles;
        break;
      case 1:
        sheet = sheetPlayer;
        break;
      default:
        sheet = sheetTiles;
    }
    
    xPos -= xOffset;
    yPos -= yOffset;
    
    boolean mirrorX = (mirrorDir & BIT_MIRROR_X) > 0;
    boolean mirrorY = (mirrorDir & BIT_MIRROR_Y) > 0;
    
    int scaleMap = scale - 1;
    int xTile = tile % 32;
    int yTile = tile / 32;
    int tileOffset = (xTile << 3) + (yTile << 3) * sheet.width;
    
    for (int y = 0; y < 8; y++)
    {
      int ySheet = y;
      if (mirrorY)
         ySheet = 7 - y;
         
      int yPixel = y + yPos + (y * scaleMap) - ((scaleMap << 3) / 2);
      
      for (int x = 0; x < 8; x++)
      {
        int xSheet = x;
        if (mirrorX)
          xSheet = 7 - x;
          
        int xPixel = x + xPos + (x * scaleMap) - ((scaleMap << 3) / 2);   
        int col = sheet.pixels[xSheet + ySheet * sheet.width + tileOffset];
        
        if (Colors.get(col) != 0)
        {
          for (int yScale = 0; yScale < scale; yScale++)
          {
            if (yPixel + yScale < 0 || yPixel + yScale >= height)
              continue;
              
            for (int xScale = 0; xScale < scale; xScale++)
            {
              if (xPixel + xScale < 0 || xPixel + xScale >= width)
                continue;
              pixels[(xPixel + xScale) + (yPixel + yScale) * width] = col;
            }
          }
        }
      }
    }
    
  }
  
  public void setOffset(int xOffset, int yOffset)
  {
    this.xOffset = xOffset;
    this.yOffset = yOffset;
  }
  
}