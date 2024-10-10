package pos_creditcard;

import java.util.ArrayList;


public class PointOfSale {
  private ProductCatalog productCatalog;
  private ArrayList<Sale> sales;
  private int idLastSale = 0;
  private final String FILE_NAME = "src/pos/catalog.txt";
  private Cash cash; // Pass 1 to initialize with default values, pass anything else to
                                                    // initialize it empty.

  public PointOfSale() {
    productCatalog = new ProductCatalog(FILE_NAME);
    sales = new ArrayList<>();
    cash = new Cash(1);
  }

  public int makeNewSale() {
    idLastSale++;
    Sale newSale = new Sale(idLastSale);
    sales.add(newSale);
    return idLastSale;
  }

  public void addLineItemToSale(int idSale, String productName, int quantity) {
    ProductSpecification productSpecification = productCatalog.searchByName(productName);
    Sale sale = searchSaleById(idSale);
    sale.addLineItem(productSpecification, quantity);
  }

  private Sale searchSaleById(int id) {
    for (Sale s : sales) {
      if (s.getId() == id) {
        return s;
      }
    }
    return null;
  }

  public void printReceiptOfSale(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printReceipt();
  }

  public void payOneSaleCash(int saleId, Cash moneyHanded) {
    Sale sale = searchSaleById(saleId);
    String variantChangeMaker = "random"; // greedy or random
    Cash change = sale.payCash(cash, moneyHanded, variantChangeMaker);

    //if (canMakeChange(change.getTotalAmount(), moneyHanded.getTotalAmount())) {
      System.out.println("\nAfter payment and giving change the cash box has:");
      cash.print();
  }

  /*
  public boolean canMakeChange(double change, double moneyHanded) {
    if(change <= Cash.getTotalAmount()+moneyHanded) {
      return true;
    }
    else {
      return false;
    }
  }
  */

  public void payOneSaleCreditCard(int saleId, String ccnumber) {
    Sale sale = searchSaleById(saleId);
    sale.payCreditCard(ccnumber);
  }

  public void printPayment(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printPayment();
  }

  public boolean isSalePaid(int id) {
    return searchSaleById(id).isPaid();
  }

  // this is for the user interface
  public ArrayList<String> getProductNames() {
    return productCatalog.getProductNames();
  }
}

