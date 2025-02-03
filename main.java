

public class main {
  public static void main(String[] args) throws InterruptedException {
    
    RendererEngine engine = new RendererEngine(new BufferFrame());
    engine.setMode("color");

    int totalRows = 10;
    int totalCols = 40;
    int frames = 60;

    FrameManager frameManager = new FrameManager();
    frameManager.refreshRate = 1000;


    int centerY = totalRows / 2;
    int centerX = totalCols / 2;
    int radius = Math.min(totalRows, totalCols) / 2;


    char[] colors = {Pixel.NEGRO, Pixel.BLANCO, Pixel.CYAN, Pixel.MAGENTA};

    for (int frame = 0; frame < frames; frame++) {

      engine = new RendererEngine(new BufferFrame());
      engine.setMode("color");

   
      char currentColor = colors[frame % colors.length];

      for (int y = 0; y < totalRows; y++) {
        for (int x = 0; x < totalCols; x++) {
          Instruction instr = new Instruction();
          Pixel p = new Pixel();

       
          int distanceSquared = (y - centerY) * (y - centerY) + (x - centerX) * (x - centerX);
          char pixelChar = (distanceSquared <= radius * radius) ? currentColor : ' ';

          p.AsciiArray = String.valueOf(pixelChar);
          instr.Color = '#';
          boolean isExtended = (x >= 20);
          int posX = isExtended ? x - 20 : x;
          instr.CreateInstruction(p, posX, y, isExtended);
          engine.ReceiveInstruction(instr);
        }
      }

      engine.DrawFrame();

      Frame bufferedFrame = engine.SendFrame();
      if (bufferedFrame != null) {
        frameManager.Send(bufferedFrame);
        clearScreen();
        new Renderer().Show(bufferedFrame);
      }

      Thread.sleep(frameManager.refreshRate);
    }
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}