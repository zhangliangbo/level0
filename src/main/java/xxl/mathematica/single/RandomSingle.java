package xxl.mathematica.single;

import java.util.Random;

public class RandomSingle {

  public static Random instance() {
    return Holder.random;
  }

  private static class Holder {
    private static Random random = new Random();
  }

}
