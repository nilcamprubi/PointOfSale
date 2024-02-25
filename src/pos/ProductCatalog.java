package pos;

import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<ProductSpecification> productSpecifications = new ArrayList<>();

    public ProductCatalog() {
      // void
    }

    public void addProductSpecification(String name, double price) {
        productSpecifications.add(new ProductSpecification(name, price));
    }

    public ProductSpecification searchByName(String name) {
        for (ProductSpecification ps : productSpecifications) {
            if (ps.getName().equals(name)) {
                return ps;
            }
        }
        System.out.println(name + " not found");
        return null;
    }

    // this is for the user interface, to make the name of the product images to read
    public ArrayList<String> getProductNames() {
        ArrayList<String> names = new ArrayList<>();
        for (ProductSpecification ps : productSpecifications) {
            names.add(ps.getName());
        }
        return names;
    }
}
