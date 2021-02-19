public class Colors
{
  public static int get(int aRGB)
  {
    int r = (aRGB >> 16) & 0xFF;
    int g = (aRGB >> 8) & 0xFF;
    int b = aRGB & 0xFF;
    
    return (r * 256 * 256) + (g * 256) + b;
  }
}