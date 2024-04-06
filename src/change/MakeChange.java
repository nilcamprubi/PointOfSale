// https://users.cs.fiu.edu/~weiss/dsj3/code/MakeChange.java

package change;

public final class MakeChange {
  // Dynamic programming algorithm to solve change making problem.
  // As a result, the coinsUsed array is filled with the
  // minimum number of coins/notes=denominations needed for change from 0 -> maxChange
  // and lastDenom contains one of the denominations needed to make the change.
  public static void makeChange(int[] denom, int differentDenoms,
                                int maxChange, int[] denomsUsed, int[] lastDenom) {
    denomsUsed[0] = 0;
    lastDenom[0] = 1;

    for (int cents = 1; cents <= maxChange; cents++) {
      int minDenoms = cents;
      int newDenom = 1;

      for (int j = 0; j < differentDenoms; j++) {
        if (denom[j] > cents)   // Cannot use coin j
          continue;
        if (denomsUsed[cents - denom[j]] + 1 < minDenoms) {
          minDenoms = denomsUsed[cents - denom[j]] + 1;
          newDenom = denom[j];
        }
      }

      denomsUsed[cents] = minDenoms;
      lastDenom[cents] = newDenom;
    }
  }

  // Simple test program
  public static void main(String[] args) {
    // The coins/notes and the total amount of change

    int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000}; // { 1, 5, 10, 21, 25 };
    int numDenominations = denominations.length;
    int change = 0;

    if (args.length == 0) {
      System.out.println("Supply a monetary amount on the command line");
      System.exit(0);
    }

    try {
      change = (int) (100*Double.parseDouble(args[0]));
    } catch (NumberFormatException e) {
      System.out.println(e);
      System.exit(0);
    }

    int[] used = new int[change + 1];
    int[] last = new int[change + 1];

    makeChange(denominations, numDenominations, change, used, last);

    System.out.println("Change is " + change / 100.);
    System.out.println("Best is " + used[change] + " coins / notes");

    for (int i = change; i > 0; ) {
      double c = last[i] / 100.;
      if (last[i] / 100. < 5.) {
        System.out.print("coin ");
      } else {
        System.out.print("note ");
      }
      if (last[i] / 100. < 1.0) {
        System.out.println(last[i] + " cents");
      } else {
        System.out.println((int) c + " Eur");
      }

      i -= last[i];
    }
  }
}
