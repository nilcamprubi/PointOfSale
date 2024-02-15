public class SaleLineItem {
    ProductSpecification productSpecification;
    int quantity;
    public SaleLineItem(ProductSpecification productSpecification, int quantity) {
        this.productSpecification = productSpecification;
        this.quantity = quantity;
    }
    public double subtotal() {
        return quantity * productSpecification.getPrice();
    }
    public void print() {
        System.out.println(productSpecification.getName()
                + " " + quantity
                + " x " + productSpecification.getPrice()
                + " = " + subtotal());
    }
}
