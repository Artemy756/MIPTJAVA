import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    var reader = new BufferedReader(new FileReader("C:\\Users\\Mi\\IdeaProjects\\MIPTJAVA\\src\\main\\java\\Stream\\input.txt"));
    var writer = new BufferedWriter(new FileWriter("C:\\Users\\Mi\\IdeaProjects\\MIPTJAVA\\src\\main\\java\\Stream\\output.txt"));
    final int shift = 2;
    Cipher.zeser(shift, reader, writer);
  }
}
