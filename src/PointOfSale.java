import java.util.ArrayList;
import java.util.Random;

public class PointOfSale {
    private ProductCatalog productCatalog;
    private ArrayList<Sale> sales;
    //private int idLastSale = 0;
    Random randomIdSaleGenerator = new Random();

    public PointOfSale() {
        productCatalog = new ProductCatalog();
        fillCatalog();
        sales = new ArrayList<>();
    }

    private void fillCatalog() {
        productCatalog.addProductSpecification("Cocacola", 1.20);
        productCatalog.addProductSpecification("Nestea", 1.50);
        productCatalog.addProductSpecification("Moritz", 1.90);
    }

    public int makeNewSale() {
        //idLastSale++;
        //Sale newSale = new Sale(idLastSale);
        int idNewSale = randomIdSaleGenerator.nextInt(); // 2^32 = 4,294,967,296 possible values
        Sale newSale = new Sale(idNewSale);
        sales.add(newSale);
        return idNewSale;
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
}

