package lab3;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2){
        return Double.compare(p2.getPrice(), p1.getPrice());
//        if(Math.abs(p1.getPrice() - p2.getPrice()) < 0.00001) return 0;
//        else if(p1.getPrice() > p2.getPrice()) return -1;
//        else return 1;
    }
}
