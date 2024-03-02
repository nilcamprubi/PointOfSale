package pos;

public class Main {
  public static void main(String[] args) {
    PointOfSale pointOfSale = new PointOfSale();
    // Some customers arrive, sit at a table, the waiter comes and makes a new sale.
    // Then takes the order : 4 Moritz and 1 Coca-cola
    int idSale = pointOfSale.makeNewSale();
    pointOfSale.addLineItemToSale(idSale, "Moritz", 4);
    pointOfSale.addLineItemToSale(idSale, "Coca-cola", 1);
    // later 2 more Coca-colas
    pointOfSale.addLineItemToSale(idSale, "Coca-cola", 2);
    // ask for the bill and the waiter prints the ticket:
    //Sale 423234
    //Moritz 4 x 1.9 = 7.6
    //Coca-cola 1 x 1.2 = 1.2
    //Coca-cola 2 x 1.2 = 2.4
    //Total 11.2
    pointOfSale.printBillOfSale(idSale);
    double handedAmount = 20.;
    pointOfSale.payOneSale(idSale, handedAmount);
    pointOfSale.printChangeOfSale(idSale);
  }
}