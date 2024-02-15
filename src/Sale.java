import java.util.ArrayList;

public class Sale {
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
        System.out.println("Total " + total());
    }

    public double pay(double amount) {
        assert payment == null : "Can not make two payment for a sale";
        payment = new PaymentInCash(amount);
        return payment.change(total());
    }
}
