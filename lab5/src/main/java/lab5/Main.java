package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lab5.Supplier.*;

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

        Supplier supplier2 = new Supplier.SupplierBuilder("Cat Food Supplier")
                .setAddress("Nezalezhnosti, 147")
                .build();

        Supplier supplier3 = new Supplier.SupplierBuilder("Dog Food Supplier")
                .setAddress("Universitetska,20")
                .setContactPerson(employee1)
                .build();

        Supplier supplier4 = new Supplier.SupplierBuilder("HABFSHSDF")
                .setAddress("Nezalezhnosti, 147")
                .build();

        Supplier supplier5 = new Supplier.SupplierBuilder("Supplier #1")
                .setAddress("Universitetska,20")
                .setContactPerson(employee1)
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

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        System.out.println(products);

        supplier5.setProducts(products);


    }
}