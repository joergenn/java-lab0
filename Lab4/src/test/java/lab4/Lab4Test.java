package lab4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab4Test {
    Employee.EmployeeBuilder empBuilder = new Employee.EmployeeBuilder("Oleg")
            .setSalary(6100.0)
            .setAddress("Holovna, 195")
            .setPhoneNumber("380950000000")
            .setIsInsuranced(true);

    Employee employee1 = empBuilder.build();


    @DataProvider
    public Object[][] employeeProvider(){
        return new Object[][]{ {new Employee.EmployeeBuilder("Oleg")
                .setSalary(6100.0)
                .setAddress("Holovna, 195")
                .setPhoneNumber("380950000000")
                .setIsInsuranced(true)}
        };
    }

    @DataProvider
    public Object[][] supplierProvider(){
        return new Object[][]{ {new Supplier.SupplierBuilder("Supplier")
                .setAddress("Universitetska,20")
                .setContactPerson(employee1)}
        };
    }

    @DataProvider
    public Object[][] productProvider(){
        return new Object[][]{ {new Product.ProductBuilder(10, "Wiskas")
                .setCategory("Cat food")
                .setQuantity(12410)
                .setPrice(10)}
        };
    }

    @Test(dataProvider = "employeeProvider", expectedExceptions = IllegalArgumentException.class )
    public void testEmployeeBuilderSalary(Employee.EmployeeBuilder employeeBuilder) {
        employeeBuilder.setSalary(100).build();
    }

    @Test(dataProvider = "employeeProvider", expectedExceptions = IllegalArgumentException.class )
    public void testEmployeeBuilderName(Employee.EmployeeBuilder employeeBuilder) {
        employeeBuilder.setName("sjvwe").build();
    }

    @Test(dataProvider = "employeeProvider", expectedExceptions = IllegalArgumentException.class )
    public void testEmployeeBuilderAddress(Employee.EmployeeBuilder employeeBuilder) {
        employeeBuilder.setAddress("").build();
    }

    @Test(dataProvider = "employeeProvider", expectedExceptions = IllegalArgumentException.class )
    public void testEmployeeBuilderPhoneNumber(Employee.EmployeeBuilder employeeBuilder) {
        employeeBuilder.setPhoneNumber("380951000000000").build();
    }

    @Test(dataProvider = "supplierProvider", expectedExceptions = IllegalArgumentException.class )
    public void testSupplierBuilderName(Supplier.SupplierBuilder supplierBuilder) {
        supplierBuilder.setName("s").build();
    }

    @Test(dataProvider = "supplierProvider", expectedExceptions = IllegalArgumentException.class )
    public void testSupplierBuilderContactPerson(Supplier.SupplierBuilder supplierBuilder) {
        supplierBuilder.setContactPerson(null).build();
    }

    @Test(dataProvider = "supplierProvider", expectedExceptions = IllegalArgumentException.class )
    public void testSupplierBuilderAddress(Supplier.SupplierBuilder supplierBuilder) {
        supplierBuilder.setAddress("").build();
    }

    @Test(dataProvider = "productProvider", expectedExceptions = IllegalArgumentException.class )
    public void testProductBuilderBarcode(Product.ProductBuilder productBuilder) {
        productBuilder.setBarcode(-1).build();
    }

    @Test(dataProvider = "productProvider", expectedExceptions = IllegalArgumentException.class )
    public void testProductBuilderName(Product.ProductBuilder productBuilder) {
        productBuilder.setName("").build();
    }

    @Test(dataProvider = "productProvider", expectedExceptions = IllegalArgumentException.class )
    public void testProductBuilderPrice(Product.ProductBuilder productBuilder) {
        productBuilder.setPrice(-1).build();
    }

    @Test(dataProvider = "productProvider", expectedExceptions = IllegalArgumentException.class )
    public void testProductBuilderCategory(Product.ProductBuilder productBuilder) {
        productBuilder.setCategory("").build();
    }

    @Test(dataProvider = "productProvider", expectedExceptions = IllegalArgumentException.class )
    public void testProductBuilderQuantity(Product.ProductBuilder productBuilder) {
        productBuilder.setQuantity(-1).build();
    }

}

