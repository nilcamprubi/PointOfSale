package pos_creditcard;

public class PaymentInCash extends Payment {
  double amountHanded;
  Change change;

  public PaymentInCash(Cash cashBox, Cash moneyHanded, double amountToPay, String variantChangeMaker) {
    super(amountToPay);
    this.amountHanded = moneyHanded.getTotalAmount();
    assert amountHanded >= amountToPay;
    cashBox.merge(moneyHanded);
    change = change(moneyHanded.getTotalAmount()-amountToPay, cashBox, variantChangeMaker);
    print();
  }

  private Change change(double amount, Cash cashBox, String variantChangeMaker) {
    Change change;

    if (variantChangeMaker.equals("random")) {
      change = new ChangeRandom(amount, cashBox);
    } else if (variantChangeMaker.equals("greedy")) {
      change = new ChangeGreedy(amount, cashBox);
    } else {
      change = null;
      System.out.println("No valid variant of change maker has been set.");
    }
    return change;
  }

  public Cash getChange() {
    return change.getValue();
  }

  @Override
  public void print() {
    System.out.printf("\nMoney handed:" + amountHanded + "\n");
    System.out.printf("Added payment to cash box:" + amountHanded + "\n");
    System.out.printf("\nTotal to pay %.2f, change to give %.2f\n", amountToPay, change.getValue().getTotalAmount());
    System.out.println("\nThe change is:");
    change.getValue().print();
  }
}
