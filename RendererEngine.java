import java.util.Queue;
import java.util.LinkedList;

public class RendererEngine {
  private Object frame;
  private String mode;
  private LinkedList<Instruction> instructionsList = new LinkedList<>();
  private Queue<Object> bufferFrameQueue = new LinkedList<>();
  private BufferFrame bufferFrame = new BufferFrame();

  public void Node(Object frame) {
    this.frame = frame;
  }

  public void DrawFrame() { // Renamed from Drawframe()
    if (mode != null && !instructionsList.isEmpty()) {
      Frame frameObj = new Frame();

      for (Instruction instr : instructionsList) {
        int frameNumber = instr.SizeExtension ? 2 : 1;
        frameObj.updatePixel(frameNumber, instr.posX, instr.posY, instr.pixelChar);
      }

      bufferFrame.addFrame(frameObj);

    } else {
      System.out.println("Error: RendererEngine mode or instructions not set");
    }
  }

  public Frame SendFrame() { // Renamed from sendFrame()
    if (!bufferFrame.isEmpty()) {
      return bufferFrame.getFrame();
    } else {
      System.out.println("No frame in buffer to send.");
      return null;
    }
  }

  // Added method
  public void SelectRenderMode() {
    if (mode != null) {
      System.out.println("Render mode selected: " + mode);
    } else {
      System.out.println("No render mode set.");
    }
  }

  public void ReceiveInstruction(Object instruction) { // Renamed from RecieveInstruction()
    if (instruction instanceof Instruction) {
      instructionsList.add((Instruction) instruction);
    }
  }

  public void setMode(String mode) {
    this.mode = mode;
  }
}
