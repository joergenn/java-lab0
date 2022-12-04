package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SupplierService {
    private Supplier s;

    SupplierService(Supplier s){
        this.s = s;
    }

    public List<Product> getProductsWithPriceLessThan(double price){
        return s.getProducts().stream()
                .filter(product -> product.getPrice() < price)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Product> getProductsWithPriceLessThanFor(double price){
        List<Product> products = new ArrayList<>();
        for(Product p : s.getProducts()){
            if (p.getPrice() < price) products.add(p);
        }
        Collections.sort(products);
        return products;
    }

    public List<Product> getProductsWithQuantityLessThan(int quantity){
        return s.getProducts().stream()
                .filter(product -> product.getQuantity() < quantity)
                .sorted(new ProductPriceComparator())
                .collect(Collectors.toList());
    }

    public List<Product> getProductsWithQuantityLessThanFor(int quantity){
        List<Product> products = new ArrayList<>();
        for(Product p : s.getProducts()){
            if (p.getQuantity() <quantity) products.add(p);
        }
        Collections.sort(products, new ProductPriceComparator());
        return products;
    }

    public double getSumOfPricesIncreasedByRatio(double ratio){
        return getSumOfPrices() * ratio;
    }

    public double getSumOfPricesIncreasedByRatioFor(double ratio){
        return getSumOfPricesFor() * ratio;
    }

    public int getQuantityOfProductsMoreExpensiveThan(double price){
        return s.getProducts().stream()
                .filter(product -> product.getPrice() > price)
                .map(Product::getQuantity)
                .reduce(0, (total, quantity) -> total + quantity);
    }

    public int getQuantityOfProductsMoreExpensiveThanFor(double price){
        int quantity = 0;
        for (Product p: s.getProducts()) {
            if(p.getPrice() > price){
                quantity += p.getQuantity();
            }
        }
        return quantity;
    }

    //todo move to separate class, add java-doc

    /**
     * @param barcode
     * @return Product instance if found, else - null
     */
    public Product getProductByBarcode(int barcode){
        return s.getProducts().stream()
                .filter(product -> product.getBarcode() == barcode)
                .findFirst()
                .orElse(null);
    }

    /**
     * @param barcode
     * @return Product instance if found, else - null
     */
    public Product getProductByBarcodeFor(int barcode){
        for(Product p : s.getProducts()){
            if(p.getBarcode() == barcode){
                return p;
            }
        }
        return null;
    }
    public double getSumOfPrices(){
        return s.getProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (total, price) -> total + price);
    }

    public double getSumOfPricesFor(){
        double sum = 0.0;
        for (Product p: s.getProducts()) {
            sum += p.getPrice();
        }
        return sum;
    }
}
