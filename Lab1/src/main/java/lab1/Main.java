package lab1;

import java.util.ArrayList;
import java.util.List;

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

        Supplier supplier2 = new Supplier.SupplierBuilder("Supplier #2")
                .setAddress("Nezalezhnosti, 147")
                .build();

        Product product1 = new Product.ProductBuilder(1, "Wiskas")
                .setPrice(30.99)
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

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product3);

        Supplier supplier3 = new Supplier.SupplierBuilder("Supplier #1")
                .setAddress("Universitetska,20")
                .setContactPerson(employee1)
                .setProducts(products)
                .setProduct(product2)
                .build();

        System.out.println(employee2);
        System.out.println(employee1);
        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.equals(employee3));

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product1.equals(product2));
        System.out.println(product1.equals(product3));

        System.out.println(supplier1);
        System.out.println(supplier2);
        System.out.println(supplier1.equals(supplier2));
        System.out.println(supplier1.equals(supplier3));
    }
}
