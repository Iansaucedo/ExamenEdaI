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

  public void Drawframe() {
    if (mode != null && !instructionsList.isEmpty()) {
      Frame frameObj = new Frame();

      for (Instruction instr : instructionsList) {
        int frameNumber = instr.SizeExtension ? 2 : 1;
        frameObj.updatePixel(frameNumber, instr.posX, instr.posY, instr.pixelChar);
      }

      // Send the frame to the buffer
      bufferFrame.addFrame(frameObj);
      System.out.println("Frame sent to buffer");
    } else {
      System.out.println("RendererEngine mode or instructions not set");
    }
  }

  public void sendFrame() {
    System.out.println("Sending frame: " + frame);
  }

  public void SelecetRenderMode() {
    System.out.println("Selected render mode: " + mode);
  }

  public void RecieveInstruction(Object instruction) {
    if (instruction instanceof Instruction) {
      instructionsList.add((Instruction) instruction);
    }
  }

  public void bufferFrame(Object frame) {
    bufferFrameQueue.add(frame);
    System.out.println("Buffered frame: " + frame);
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public Frame getBufferedFrame() {
    return bufferFrame.getFrame();
  }
}
