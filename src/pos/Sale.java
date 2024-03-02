package pos;

import java.util.ArrayList;

public class Sale {
  boolean isPaid = false;
  private int id;
  private ArrayList<SaleLineItem> saleLineItems = new ArrayList<>();
  private PaymentInCash payment;

  public Sale(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void addLineItem(ProductSpecification productSpecification, int quantity) {
    for (SaleLineItem item : saleLineItems) {
      if (item.productSpecification == productSpecification) { // same object
        item.incrementQuantity();
        return;
      }
    }
    saleLineItems.add(new SaleLineItem(productSpecification, quantity));
  }

  public double total() {
    double total = 0.;
    for (SaleLineItem saleLineItem : saleLineItems) {
      total += saleLineItem.subtotal();
    }
    return total;
  }

  public void printBill() {
    System.out.println("Sale " + id);
    for (SaleLineItem saleLineItem : saleLineItems) {
      saleLineItem.print();
    }
    System.out.printf("Total %.2f\n", total());
  }

  public void pay(double amount) {
    assert !isPaid : "sale " + id + " has already been payed";
    payment = new PaymentInCash(amount);
    isPaid = true;
  }

  public void printChange() {
    assert payment != null : "No payment for sale " + id;
    System.out.printf("\nAmount paid : %.2f\nChange : %.2f\n", payment.getAmount(), payment.change(total()));
  }

  public boolean isPaid() {
    return isPaid;
  }
}
