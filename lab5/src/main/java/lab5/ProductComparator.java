package lab5;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2){
        if(Math.abs(p1.getPrice() - p2.getPrice()) < 0.00001) return 0;
        else if(p1.getPrice() > p2.getPrice()) return -1;
        else return 1;
    }
}