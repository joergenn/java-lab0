package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lab3.Supplier.getProductsWithPriceLessThan;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee.EmployeeBuilder("Oleg")
                .setSalary(2100.0)
                .setAddress("Holovna, 195")
                .setPhoneNumber("0990000000")
                .setIsInsuranced(true)
                .build();
        Employee employee2 = new Employee.EmployeeBuilder("John")
                .setSalary(3200.80)
//                .setAddress("Holovna, 194")
//                .setPhoneNumber("0991000001")
//                .setIsInsuranced(false)
                .build();
        Employee employee3 = new Employee.EmployeeBuilder("Oleg")
                .setSalary(2100.0)
                .setAddress("Holovna, 195")
                .setPhoneNumber("0990000000")
                .setIsInsuranced(true)
                .build();

        Supplier supplier1 = new Supplier.SupplierBuilder("Supplier #1")
                .setAddress("Universitetska,20")
                .setContactPerson(employee1)
                .build();

        Supplier supplier2 = new Supplier.SupplierBuilder("bnufibeadfb")
                .setAddress("Nezalezhnosti, 147")
                .build();

        Supplier supplier3 = new Supplier.SupplierBuilder("hdsfhdsfh")
                .setAddress("Universitetska,20")
                .setContactPerson(employee1)
                .build();

        Supplier supplier4 = new Supplier.SupplierBuilder("HABFSHSDF")
                .setAddress("Nezalezhnosti, 147")
                .build();

        Product product1 = new Product.ProductBuilder(1, "Wiskas")
                .setPrice(70.99)
                .setCategory("Cat food")
                .setSupplier(supplier1)
                .build();

        Product product2 = new Product.ProductBuilder(2, "Pedigree")
                .setPrice(360.00)
                .setCategory("Dog food")
                .build();

        Product product3 = new Product.ProductBuilder(1, "Wiskas")
                .setPrice(30.99)
                .setCategory("Cat food")
                .build();

        Product product4 = new Product.ProductBuilder(1, "Wiskas")
                .setPrice(130.99)
                .setCategory("Cat food")
                .build();

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        for(Product product : products){
            System.out.println(product);
        }
        Collections.sort(products);
        for(Product product : products){
            System.out.println(product);
        }

        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(supplier1);
        suppliers.add(supplier2);
        suppliers.add(supplier3);
        suppliers.add(supplier4);
        for(Supplier s : suppliers){
            System.out.println(s);
        }
        Collections.sort(suppliers);
        for(Supplier s : suppliers){
            System.out.println(s);
        }

        Supplier supplier5 = new Supplier.SupplierBuilder("Supplier #1")
                .setAddress("Universitetska,20")
                .setContactPerson(employee1)
                .setProducts(products)
                .build();
        List<Product> prds = new ArrayList<>();
        prds = getProductsWithPriceLessThan(supplier5, 100);
        for(Product p : prds){
            System.out.println(p);
        }
//        System.out.println(getProductsWithPriceLessThan(supplier5, 100));

//        System.out.println(employee2);
//        System.out.println(employee1);
//        System.out.println(employee1.equals(employee2));
//        System.out.println(employee1.equals(employee3));
//
//        System.out.println(product1);
//        System.out.println(product2);
//        System.out.println(product1.equals(product2));
//        System.out.println(product1.equals(product3));
//
//        System.out.println(supplier1);
//        System.out.println(supplier2);
//        System.out.println(supplier1.equals(supplier2));
//        System.out.println(supplier1.equals(supplier3));
    }
}