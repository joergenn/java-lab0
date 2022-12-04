package lab3;

import static lab3.Supplier.*;

//import static lab3.Supplier.getSumOfPrices;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab3Test {
    public boolean checkList(List<Product> l1, List<Product> l2){
        if(l1.size() != l2.size()) return false;
        int i = 0;
        while (i < l1.size()){
            if(!l1.get(i).equals(l2.get(i))) return false;
            i++;
        }
        return true;
    }

    Employee employee1 = new Employee.EmployeeBuilder("Oleg")
            .setSalary(2100.0)
            .setAddress("Holovna, 195")
            .setPhoneNumber("0990000000")
            .setIsInsuranced(true)
            .build();

    Product product1 = new Product.ProductBuilder(1, "Wiskas")
            .setPrice(70.99)
            .setCategory("Cat food")
            .setQuantity(10)
            .build();

    Product product2 = new Product.ProductBuilder(2, "Pedigree")
            .setPrice(360.00)
            .setCategory("Dog food")
            .setQuantity(15)
            .build();

    Product product3 = new Product.ProductBuilder(3, "Wiskas")
            .setPrice(30.99)
            .setCategory("Cat food")
            .setQuantity(40)
            .build();

    Product product4 = new Product.ProductBuilder(4, "Wiskas")
            .setPrice(130.99)
            .setCategory("Cat food")
            .setQuantity(22)
            .build();

    List<Product> products = Arrays.asList(product1, product2, product3, product4);

    Supplier supplier5 = new Supplier.SupplierBuilder("Supplier #1")
            .setAddress("Universitetska,20")
            .setContactPerson(employee1)
            .setProducts(products)
            .build();

    SupplierService service = new SupplierService(supplier5);

    @Test(dataProvider = "productCompareProvider")
    public void productCompareTest(Product p1, Product p2, int res){
        assertEquals(p1.compareTo(p2), res);
    }

    @DataProvider
    public Object[][] productCompareProvider() {
        return new Object[][]{{product1, product2, -1},{product1, product3, 1},{product1, product1, 0}};
    }

    @Test(dataProvider = "getProductsWithPriceLessThanProvider")
    public void getProductsWithPriceLessThanTest(double price, List<Product> l){
        assertEquals(checkList(service.getProductsWithPriceLessThan(price), l), true);
    }

    @DataProvider
    public Object[][] getProductsWithPriceLessThanProvider() {
        return new Object[][]{{100.0, Arrays.asList(product3, product1)}};
    }

    @Test(dataProvider = "getProductsWithPriceLessThanForProvider")
    public void getProductsWithPriceLessThanForTest(double price, List<Product> l){
        assertEquals(checkList(service.getProductsWithPriceLessThanFor(price), l), true);
    }

    @DataProvider
    public Object[][] getProductsWithPriceLessThanForProvider() {
        return new Object[][]{{100.0, Arrays.asList(product3, product1)}};
    }

    @Test(dataProvider = "getProductsWithQuantityLessThanProvider")
    public void getProductsWithQuantityLessThanTest(int quantity, List<Product> l){
        assertEquals(checkList(service.getProductsWithQuantityLessThan(quantity), l), true);
    }

    @DataProvider
    public Object[][] getProductsWithQuantityLessThanProvider() {
        return new Object[][]{{20, Arrays.asList(product2, product1)}};
    }

    @Test(dataProvider = "getProductsWithQuantityLessThanForProvider")
    public void getProductsWithQuantityLessThanForTest(int quantity, List<Product> l){
        assertEquals(checkList(service.getProductsWithQuantityLessThanFor(quantity), l), true);
    }

    @DataProvider
    public Object[][] getProductsWithQuantityLessThanForProvider() {
        return new Object[][]{{20, Arrays.asList(product2, product1)}};
    }

    @Test(dataProvider = "getSumOfPricesProvider")
    public void getSumOfPricesTest(double sum){
        assertEquals(service.getSumOfPrices(), sum);
    }

    @DataProvider
    public Object[][] getSumOfPricesProvider() {
        return new Object[][]{{592.97}};
    }

    @Test(dataProvider = "getSumOfPricesForProvider")
    public void getSumOfPricesForTest(double sum){
        assertEquals(service.getSumOfPricesFor(), sum);
    }

    @DataProvider
    public Object[][] getSumOfPricesForProvider() {
        return new Object[][]{{592.97}};
    }

    @Test(dataProvider = "getProductByBarcodeProvider")
    public void getProductByBarcodeTest(int barcode, Product p){
        assertEquals(service.getProductByBarcode(barcode).equals(p), true);
    }

    @DataProvider
    public Object[][] getProductByBarcodeProvider() {
        return new Object[][]{{1, product1}, {4, product4}};
    }

    @Test(dataProvider = "getProductByBarcodeForProvider")
    public void getProductByBarcodeForTest(int barcode, Product p){
        assertEquals(service.getProductByBarcodeFor(barcode).equals(p), true);
    }

    @DataProvider
    public Object[][] getProductByBarcodeForProvider() {
        return new Object[][]{{2, product2}, {3, product3}};
    }

    @Test(dataProvider = "getQuantityOfProductsMoreExpensiveThanProvider")
    public void getQuantityOfProductsMoreExpensiveThanTest( double price, int quantity){
        assertEquals(service.getQuantityOfProductsMoreExpensiveThan(price), quantity);
    }

    @DataProvider
    public Object[][] getQuantityOfProductsMoreExpensiveThanProvider() {
        return new Object[][]{{100.0, 37}};
    }

    @Test(dataProvider = "getQuantityOfProductsMoreExpensiveThanForProvider")
    public void getQuantityOfProductsMoreExpensiveThanForTest(double price, int quantity){
        assertEquals(service.getQuantityOfProductsMoreExpensiveThanFor(price), quantity);
    }

    @DataProvider
    public Object[][] getQuantityOfProductsMoreExpensiveThanForProvider() {
        return new Object[][]{{100.0, 37}};
    }

    @Test(dataProvider = "getSumOfPricesIncreasedByRatioProvider")
    public void getSumOfPricesIncreasedByRatioTest(double ratio, double sum){
        assertEquals(service.getSumOfPricesIncreasedByRatio(ratio), sum);
    }

    @DataProvider
    public Object[][] getSumOfPricesIncreasedByRatioProvider() {
        return new Object[][]{{1.5, 889.455}};
    }

    @Test(dataProvider = "getSumOfPricesIncreasedByRatioForProvider")
    public void getSumOfPricesIncreasedByRatioForTest(double ratio, double sum){
        assertEquals(service.getSumOfPricesIncreasedByRatioFor(ratio), sum);
    }

    @DataProvider
    public Object[][] getSumOfPricesIncreasedByRatioForProvider() {
        return new Object[][]{{1.5, 889.455}};
    }

}

