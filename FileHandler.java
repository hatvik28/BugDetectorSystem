import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

  public void readFile(String filePath) {
    try {
      String content = new String(Files.readAllBytes(Path.of(filePath)));
      System.out.println(content);
    } catch (IOException e) {

    }
  }

  public static void main(String[] args) {
    FileHandler handler = new FileHandler();
    handler.readFile("input.txt");
  }
}
