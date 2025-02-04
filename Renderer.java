public class Renderer {
  private Object frame;

  public void Show(Object frame) {
    this.frame = frame;

    if (frame instanceof Frame) {
      Frame f = (Frame) frame;
      char[][] combined = f.combineFrames();
      for (int y = 0; y < combined.length; y++) {
        for (int x = 0; x < combined[y].length; x++) {
          System.out.print(combined[y][x]);
        }
        System.out.println();
        
      }

    } else {
      System.out.println("Critical Error: Invalid frame type.");
    }
  }
}
