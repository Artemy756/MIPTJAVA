import java.io.*;
import java.util.*;
import java.util.stream.*;


public class OperationwhithFile {
  public static List<List<Character>> fileReadLine(BufferedReader reader) throws IOException {
    var line = reader.readLine();
    List<List<Character>> list = new ArrayList<>();
    while (line != null) {
      List<Character> l = line.chars()
              .mapToObj(e -> (char) e)
              .collect(Collectors.toList());
      list.add(l);
      line = reader.readLine();
    }
    return list;
  }


  public static void fileWrite(BufferedWriter output, List<Character> list) {
    String s = list.stream()
            .map(Objects::toString)
            .collect(Collectors.joining());
    try (output) {
      output.write(s);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}

