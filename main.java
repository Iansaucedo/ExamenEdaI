public class main {
  public static void main(String[] args) {
    RendererEngine engine = new RendererEngine();
    engine.setMode("color");

    // Define the message to fill the viewport
    String message = "c";
    int totalRows = 10;
    int totalCols = 40; // 20 columns for frame1 and 20 columns for frame2

    for (int y = 0; y < totalRows; y++) {
      for (int x = 0; x < totalCols; x++) {
        Instruction instr = new Instruction();
        Pixel p = new Pixel();
        // Choose a character from the message based on the current pixel index
        char pixelChar = message.charAt((y * totalCols + x) % message.length());

        // Set the AsciiArray based on the pixelChar
        switch (pixelChar) {
          case 'n':
            p.AsciiArray = String.valueOf(Pixel.NEGRO);
            break;
          case 'b':
            p.AsciiArray = String.valueOf(Pixel.BLANCO);
            break;
          case 'c':
            p.AsciiArray = String.valueOf(Pixel.CYAN);
            break;
          case 'm':
            p.AsciiArray = String.valueOf(Pixel.MAGENTA);
            break;
          default:
            p.AsciiArray = String.valueOf(pixelChar);
            break;
        }

        instr.Color = '#'; // using BLANCO as base color
        // Determine the frame: if x < 20, use frame1; else use frame2 (SizeExtension
        // true)
        boolean isExtended = (x >= 20);
        int posX = isExtended ? x - 20 : x;
        instr.createinstruction(p, posX, y, isExtended);
        engine.RecieveInstruction(instr);
      }
    }

    // RendererEngine creates the frame using the instructions and sends it to the
    // buffer
    engine.Drawframe();

    // FrameManager fetches the frame from the buffer and displays it
    FrameManager frameManager = new FrameManager();
    Frame bufferedFrame = engine.getBufferedFrame();
    frameManager.bufferFrame(bufferedFrame);
    frameManager.displayBufferedFrame();
  }
}
