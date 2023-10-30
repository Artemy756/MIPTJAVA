package Task;

import java.util.*;
import java.util.concurrent.*;

public class Task {
  public static Map<String, Integer> score = new ConcurrentHashMap<>();
  private static List<Integer> usednumbers = Collections.synchronizedList(new ArrayList<>());

  public static class Player implements Runnable {
    private final CountDownLatch latch;
    private final String name;
    private int pScore;
    private List<Integer> pNumbers = Collections.synchronizedList(new ArrayList<>());

    Random r = new Random();

    public Player(CountDownLatch latch, String name, int pScore) {
      this.latch = latch;
      this.name = name;
      this.pScore = pScore;
    }

    @Override
    public void run() {
      while (latch.getCount() > 0) {
        int number = r.nextInt(101);
        if (!pNumbers.contains(number)) {
          pNumbers.add(number);
        }
        if (!usednumbers.contains(number)) {
          pScore++;
          usednumbers.add(number);
          score.put(name, pScore);
        }
        if (pNumbers.size() == 100) {
          latch.countDown();
        }
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }

  public static class Judge implements Runnable {
    private final CountDownLatch latch;

    public Judge(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void run() {
      try {
        latch.await();
        String winner = "";
        int maxpoint = 0;
        for (String s : score.keySet()) {
          if (score.get(s) > maxpoint) {
            winner = s;
            maxpoint = score.get(s);
          }
        }
        System.out.println(score.toString());
        System.out.println(winner + " " + maxpoint);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void main(String[] args) {
    var executor = Executors.newCachedThreadPool();
    var latch = new CountDownLatch(1);
    executor.submit(new Player(latch, "player1", 0));
    executor.submit(new Player(latch, "player2", 0));
    executor.submit(new Player(latch, "player3", 0));
    executor.submit(new Judge(latch));
    executor.shutdown();
  }
}
