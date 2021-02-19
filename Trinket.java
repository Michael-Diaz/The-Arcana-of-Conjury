public class Trinket
{
  private String name;
  private String descriptor;

  static final int RTY_ANOMALOUS= 0b10000;
  static final int RTY_ABERRANT = 0b01000;
  static final int RTY_ABNORMAL = 0b00100;
  static final int RTY_ATYPICAL = 0b00010;
  static final int RTY_AVERGAE = 0b00001;

  protected int sellPrice;
  protected int buyPrice;
}
