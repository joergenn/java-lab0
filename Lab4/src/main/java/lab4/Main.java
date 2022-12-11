package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lab4.Supplier.*;

public class Main {
    public static void main(String[] args) {
        Employee.EmployeeBuilder employeeBuilder = new Employee.EmployeeBuilder("Oleg")
                .setSalary(6100.0)
                .setAddress("Holovna, 195")
                .setPhoneNumber("380950000000")
                .setIsInsuranced(true);

        Employee employee1 = employeeBuilder.build();
        System.out.println(employee1);

        Supplier.SupplierBuilder supplierBuilder = new Supplier.SupplierBuilder("fdbeang")
                .setAddress("Universitetska,20");
//                .setContactPerson(employee1);

        Supplier supplier1 = supplierBuilder.build();
        System.out.println(supplier1);

        Product.ProductBuilder productBuilder = new Product.ProductBuilder(10, "j")
                .setCategory("gsdfg")
                .setQuantity(12410)
                .setPrice(10);

        Product p = productBuilder.build();

    }
}