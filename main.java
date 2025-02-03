import java.util.Random;

public class main {
  public static void main(String[] args) throws InterruptedException {
    RendererEngine engine = new RendererEngine();
    engine.setMode("color");

    int totalRows = 10;
    int totalCols = 40;
    int frames = 60;
    Random random = new Random();

    FrameManager frameManager = new FrameManager();
    frameManager.refreshRate = 30;

    for (int frame = 0; frame < frames; frame++) {
      engine = new RendererEngine();
      engine.setMode("color");

      for (int y = 0; y < totalRows; y++) {
        for (int x = 0; x < totalCols; x++) {
          Instruction instr = new Instruction();
          Pixel p = new Pixel();
          char pixelChar = 'n';
          int rand = random.nextInt(4);
          switch (rand) {
            case 0:
              pixelChar = Pixel.NEGRO;
              break;
            case 1:
              pixelChar = Pixel.BLANCO;
              break;
            case 2:
              pixelChar = Pixel.CYAN;
              break;
            case 3:
              pixelChar = Pixel.MAGENTA;
              break;
          }
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
        frameManager.bufferFrame(bufferedFrame);
        clearScreen();
        frameManager.displayBufferedFrame();
      }

      Thread.sleep(frameManager.refreshRate);
    }
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
