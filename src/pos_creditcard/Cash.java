package pos_creditcard;
import java.util.HashMap;

public class Cash {
        static HashMap<Double, Integer> cash;
        private static final double[] denominations = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0};

        public Cash(int option) {
              cash = new HashMap<>();

              if (option == 1) {
                    for(double denomination : denominations) {
                          if(denomination < 5) {
                                cash.put(denomination, 5);
                          }
                          else {
                                cash.put(denomination, 2);
                          }
                    }
                    System.out.println("Cash box initially loaded with:");
                    this.print();
              } else {
                    for(double denomination : denominations) {
                          cash.put(denomination, 0);
                    }
              }
        }

        // Cash initialized with the denominations in the array of doubles and the quantities of the array of integers.
        public Cash(double[] denomination, int[] quantity) {
          cash = new HashMap<>();

          for (int i = 0; i < denomination.length; i++) {
            cash.put(denomination[i], quantity[i]);
          }
        }

        public double getDenomination(int position) {
              return denominations[position];
        }

        public HashMap<Double, Integer> getCash() {
                return cash;
          }

        public void merge(Cash money) {
              for (double denomination : denominations) {
                    cash.put(denomination, cash.getOrDefault(denomination, 0)+money.getCash().getOrDefault(denomination, 0));
              }
        }

        public void subtract(Cash money) {
              for (double denomination : denominations) {
                    cash.put(denomination, cash.getOrDefault(denomination, 0)-money.getCash().getOrDefault(denomination, 0));
              }
        }

        public double getTotalAmount() {
              double amount = 0;
              for (double denomination : denominations) {
                    if (cash.getOrDefault(denomination, 0) > 0) {
                          amount += denomination*cash.getOrDefault(denomination, 0);
                    }
              }
              return amount;
        }

        public static void print() {
              for (double denomination : denominations) {
                    int quantity = cash.get(denomination);
                    System.out.printf("%d of %.2f\n", quantity, denomination);
              }
        }
}
