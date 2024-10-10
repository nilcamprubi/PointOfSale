package pos_creditcard;

import java.util.Random;

public class ChangeRandom implements Change{
  Cash value = new Cash(0);

  public ChangeRandom(double amount, Cash cashBox) {
    System.out.println("Make change with random change maker.");
    Random rand = new Random();

    while(value.getTotalAmount() < amount) {
      int randomNumber = rand.nextInt(11);
      double denomination = value.getDenomination(randomNumber);

      if(cashBox.getCash().get(denomination) > 0 && value.getTotalAmount()+denomination <= amount) {
        value.getCash().put(denomination, value.getCash().get(denomination)+1);
        cashBox.getCash().put(denomination, cashBox.getCash().get(denomination)-1);
      }
    }
  }

  public Cash getValue() {
    return value;
  }
}
