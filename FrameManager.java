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

  public void send(Object frame) {
    bufferFrameQueue.add(frame);
    System.out.println("Buffered frame: " + frame);
  }

  public void recieve(Object frame) {
    this.frame = frame;
    System.out.println("Received frame: " + frame);
  }

}
