public class Renderer {
  private Object frame;

  // Modified Show method: assigns the frame and prints the combined frame
  public void Show(Object frame) {
    this.frame = frame;
    System.out.println("Showing frame:");
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
      System.out.println("Frame is not of type Frame");
    }
  }

}
