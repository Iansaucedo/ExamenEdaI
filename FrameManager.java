import java.util.Queue;
import java.util.LinkedList;

public class FrameManager {
  private Object frame;
  private Queue<Object> bufferFrameQueue = new LinkedList<>();
  public int refreshRate;

  public void Fetch(Object frame) {
    this.frame = frame;
    System.out.println("Fetched frame: " + frame);
  }

  public void Send(Object frame) { // Renamed from send(Object frame)
    System.out.println("Sending frame: " + frame);
  }

  public void Receive(Object frame) { // Renamed from recieve(Object frame)
    this.frame = frame;
    System.out.println("Received frame: " + frame);
  }

  public void bufferFrame(Object frame) {
    bufferFrameQueue.add(frame);
    System.out.println("Buffered frame: " + frame);
  }

  public void displayBufferedFrame() {
    if (!bufferFrameQueue.isEmpty()) {
      Frame bufferedFrame = (Frame) bufferFrameQueue.poll();
      Renderer renderer = new Renderer();
      renderer.Show(bufferedFrame);
    } else {
      System.out.println("No frame in buffer to display.");
    }
  }
}
