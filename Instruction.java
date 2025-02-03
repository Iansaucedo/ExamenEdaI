public class Instruction {
  public char Color; // primitive for base color
  public boolean SizeExtension; // primitive for size extension flag
  public int posX, posY; // primitive position coordinates
  public char pixelChar; // character to introduce inside the frame

  public boolean HasColor() {
    return Color != 0; // assumes default 0 means no color set
  }

  // Modified createinstruction to use primitives for position, size extension
  // and pass the pixel character to be rendered in the frame.
  public void createinstruction(Pixel p, int x, int y, boolean isExtended) {
    String ascii = p.getpixel();
    char c = (ascii != null && !ascii.isEmpty()) ? ascii.charAt(0) : ' ';
    this.pixelChar = c;
    this.posX = x;
    this.posY = y;
    this.SizeExtension = isExtended;

  }

  public void SendInstruction() {
    System.out.println("Sending instruction");
  }
  // ...existing code...
}
