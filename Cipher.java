import java.io.*;
import java.util.*;

public class Cipher {
  public static void zeser(int shift, BufferedReader reader, BufferedWriter writer) throws IOException {
    List<List<Character>> list = OperationwhithFile.fileReadLine(reader);

    for (List<Character> j : list) {
      var res = j.stream().map(i -> (char) ((((int) i) + shift - 1072) % 32 + 1072)).toList();
      OperationwhithFile.fileWrite(writer, res);
    }
  }
}

