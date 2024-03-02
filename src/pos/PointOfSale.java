package pos;

import java.util.ArrayList;


public class PointOfSale {
  private ProductCatalog productCatalog;
  private ArrayList<Sale> sales;
  private int idLastSale = 0;

  public PointOfSale() {
    productCatalog = new ProductCatalog();
    fillCatalog();
    sales = new ArrayList<>();
  }

  private void fillCatalog() {
    productCatalog.addProductSpecification("Coca-cola", 1.20);
    productCatalog.addProductSpecification("Nestea", 1.50);
    productCatalog.addProductSpecification("Moritz", 1.90);
    productCatalog.addProductSpecification("Aigua de Ribes", 1.10);
    productCatalog.addProductSpecification("Olives Espinaler", 1.90);
    productCatalog.addProductSpecification("Patates Lays", 2.05);
    productCatalog.addProductSpecification("Trina", 1.35);
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

  public void printBillOfSale(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printBill();
  }

  public void payOneSale(int saleId, double amount) {
    Sale sale = searchSaleById(saleId);
    sale.pay(amount);
  }

  public void printChangeOfSale(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printChange();
  }

  public boolean isSalePaid(int id) {
    return searchSaleById(id).isPaid();
  }

  // this is for the user interface
  public ArrayList<String> getProductNames() {
    return productCatalog.getProductNames();
  }
}

