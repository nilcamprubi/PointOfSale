package pos_creditcard;

public class ChangeGreedy implements Change{
  Cash value = new Cash(0);

  public ChangeGreedy(double amount, Cash cashBox) {
    System.out.println("Make change with greedy change maker.");
    int greedyPosition = 10;

    while(value.getTotalAmount() < amount) {
      double denomination = value.getDenomination(greedyPosition);

      if (cashBox.getCash().get(denomination) > 0 && value.getTotalAmount()+denomination <= amount) {
        value.getCash().put(denomination, value.getCash().get(denomination)+1);
        cashBox.getCash().put(denomination, cashBox.getCash().get(denomination)-1);
      }
      else {
        greedyPosition--;
      }
    }
  }

  public Cash getValue() {
    return value;
  }
}
