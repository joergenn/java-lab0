package lab0;

import lab1.Employee;
import lab1.Product;
import lab1.Supplier;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Lab1Test {
    Employee employee1 = new Employee.EmployeeBuilder("Oleg")
            .setSalary(2100.0)
            .setAddress("Holovna, 195")
            .setPhoneNumber("0990000000")
            .setIsInsuranced(true)
            .build();
    Employee employee2 = new Employee.EmployeeBuilder("John")
            .setSalary(3200.80)
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

    Supplier supplier3 = new Supplier.SupplierBuilder("Supplier #1")
            .setAddress("Universitetska,20")
            .setContactPerson(employee1)
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

    @Test(dataProvider = "employeeEqualsProvider")
    public void employeeEqualsTest(Employee e1, Employee e2) {
        assertEquals(e1, e2);
    }

    @DataProvider
    public Object[][] employeeEqualsProvider() {
        return new Object[][]{{employee1, employee3}};
    }

    @Test(dataProvider = "employeeNotEqualsProvider")
    public void employeeNotEqualsTest(Employee e1, Employee e2) {
        assertNotEquals(e1, e2);
    }

    @DataProvider
    public Object[][] employeeNotEqualsProvider() {
        return new Object[][]{{employee1, employee2}};
    }

    @Test(dataProvider = "employeeToStringProvider")
    public void employeeToStringTest(Employee e1, String s) {
        assertEquals(e1.toString(), s);
    }

    @DataProvider
    public Object[][] employeeToStringProvider() {
        return new Object[][]{{employee1, "Oleg | 2100.0 | Holovna, 195 | 0990000000 | true"}};
    }

    @Test(dataProvider = "productEqualsProvider")
    public void productEqualsTest(Product p1, Product p2) {
        assertEquals(p1, p2);
    }

    @DataProvider
    public Object[][] productEqualsProvider() {
        return new Object[][]{{product1, product3}};
    }

    @Test(dataProvider = "productNotEqualsProvider")
    public void productNotEqualsTest(Product p1, Product p2) {
        assertNotEquals(p1, p2);
    }

    @DataProvider
    public Object[][] productNotEqualsProvider() {
        return new Object[][]{{product1, product2}};
    }

    @Test(dataProvider = "productToStringProvider")
    public void productToStringTest(Product p1, String s) {
        assertEquals(p1.toString(), s);
    }

    @DataProvider
    public Object[][] productToStringProvider() {
        return new Object[][]{{product1, "Wiskas | 1 | Wiskas | 30.99 | Cat food | Supplier:\n" +
                "Supplier #1 | Universitetska,20 | Contact person: \n" +
                "Oleg | 2100.0 | Holovna, 195 | 0990000000 | true"}};
    }

    @Test(dataProvider = "supplierEqualsProvider")
    public void supplierEqualsTest(Supplier s1, Supplier s2) {
        assertEquals(s1, s2);
    }

    @DataProvider
    public Object[][] supplierEqualsProvider() {
        return new Object[][]{{supplier1, supplier3}};
    }

    @Test(dataProvider = "supplierNotEqualsProvider")
    public void supplierNotEqualsTest(Supplier s1, Supplier s2) {
        assertNotEquals(s1, s2);
    }

    @DataProvider
    public Object[][] supplierNotEqualsProvider() {
        return new Object[][]{{supplier1, supplier2}};
    }

    @Test(dataProvider = "supplierToStringProvider")
    public void supplierToStringTest(Supplier s1, String s) {
        assertEquals(s1.toString(), s);
    }

    @DataProvider
    public Object[][] supplierToStringProvider() {
        return new Object[][]{{supplier1, "Supplier #1 | Universitetska,20 | Contact person: \n" +
                "Oleg | 2100.0 | Holovna, 195 | 0990000000 | true"}};
    }
}
