package lab2test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import lab2.Employee;
import lab2.Product;
import lab2.Supplier;
import lab2.JsonSerializer;
import lab2.XmlSerializer;
import lab2.TxtSerializer;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class Lab2Test {
    public boolean checkFiles(String fileName1, String fileName2) throws FileNotFoundException {
        File file1 = new File("target/" + fileName1);
        Scanner in1 = new Scanner(file1);
        File file2 = new File("target/" + fileName2);
        Scanner in2 = new Scanner(file2);
        String json1 = in1.useDelimiter("\\Z").next();
        String json2 = in2.useDelimiter("\\Z").next();
        return json1.equals(json2);
    }

    Employee employee = new Employee("Oleg", 2300.0, "Holovna, 195", "0990000000", true);
    Employee notEqualEmployee = new Employee("Andriy", 3300.0, "Holovna, 195", "0990000001", true);
    Supplier supplier = new Supplier("Supplier #1", "Universitetska, 20", employee);
    Supplier notEqualSupplier = new Supplier("Supplier #2", "Universitetska, 70", employee);
    Product product = new Product(1, "Wiskas", 30.99, "Cat food", supplier);
    Product notEqualProduct = new Product(2, "Pedigree", 190.0, "Dog food", supplier);
    Employee employee1 = new Employee("Oleg", 2301.0, "Holovna, 195", "0990000000", true);
    Employee employee2 = new Employee("Oleg", 2302.0, "Holovna, 195", "0990000000", true);

    JsonSerializer json = new JsonSerializer();
    XmlSerializer xml = new XmlSerializer();
    TxtSerializer txt = new TxtSerializer();

    @Test(dataProvider = "jsonEqualsTestProvider")
    public void jsonEqualsTest(Object instance, String fileName) throws IOException {
        json.writeObject(instance, "test.json");
        assertEquals(checkFiles(fileName, "test.json"), true);
    }

    @DataProvider
    public Object[][] jsonEqualsTestProvider() {
        return new Object[][]{{employee, "emp.json"}, {supplier, "spl.json"}};
    }

    @Test(dataProvider = "jsonNotEqualsTestProvider")
    public void jsonNotEqualsTest(Object instance, String fileName) throws IOException {
        json.writeObject(instance, "test.json");
        assertEquals(checkFiles(fileName, "test.json"), false);
    }

    @DataProvider
    public Object[][] jsonNotEqualsTestProvider() {
        return new Object[][]{{notEqualEmployee, "emp.json"}, {notEqualProduct, "prd.json"}};
    }

    @Test(dataProvider = "xmlEqualsTestProvider")
    public void xmlEqualsTest(Object instance, String fileName) throws IOException {
        xml.writeObject(instance, "test.xml");
        assertEquals(checkFiles(fileName, "test.xml"), true);
    }

    @DataProvider
    public Object[][] xmlEqualsTestProvider() {
        return new Object[][]{{employee, "emp.xml"}, {supplier, "spl.xml"}};
    }

    @Test(dataProvider = "xmlNotEqualsTestProvider")
    public void xmlNotEqualsTest(Object instance, String fileName) throws IOException {
        xml.writeObject(instance, "test.xml");
        assertEquals(checkFiles(fileName, "test.xml"), false);
    }

    @DataProvider
    public Object[][] xmlNotEqualsTestProvider() {
        return new Object[][]{{notEqualEmployee, "emp.xml"}, {notEqualProduct, "prd.xml"}};
    }

    @Test(dataProvider = "txtEqualsTestProvider")
    public void xmlEqualsTest(Employee instance, String fileName) throws IOException, IllegalAccessException {
        txt.writeObject(instance, "test.txt");
        assertEquals(checkFiles(fileName, "test.txt"), true);
    }

    @DataProvider
    public Object[][] txtEqualsTestProvider() {
        return new Object[][]{{employee, "emp.txt"}};
    }

    @Test(dataProvider = "txtNotEqualsTestProvider")
    public void txtNotEqualsTest(Employee instance, String fileName) throws IOException, IllegalAccessException {
        txt.writeObject(instance, "test.txt");
        assertEquals(checkFiles(fileName, "test.txt"), false);
    }

    @DataProvider
    public Object[][] txtNotEqualsTestProvider() {
        return new Object[][]{{notEqualEmployee, "emp.txt"}};
    }

    @Test(dataProvider = "jsonListEqualsTestProvider")
    public void jsonListEqualsTest(String fileName, Object... instances) throws IOException {
        List<Object> list = new ArrayList<>();
        for(Object o : instances){
            list.add(o);
        }
        json.writeList(list, "test.json");
        assertEquals(checkFiles(fileName, "test.json"), true);
    }

    @DataProvider
    public Object[][] jsonListEqualsTestProvider() {
        return new Object[][]{{"list_emp.json", employee, employee1, employee2}};
    }

    @Test(dataProvider = "jsonListNotEqualsTestProvider")
    public void jsonListNotEqualsTest(String fileName, Object... instances) throws IOException {
        List<Object> list = new ArrayList<>();
        for(Object o : instances){
            list.add(o);
        }
        json.writeList(list, "test.json");
        assertEquals(checkFiles(fileName, "test.json"), false);
    }

    @DataProvider
    public Object[][] jsonListNotEqualsTestProvider() {
        return new Object[][]{{"list_emp.json", employee, employee1, notEqualEmployee}};
    }

    @Test(dataProvider = "jsonDeserializedEqualityTestProvider")
    public void jsonDeserializedEqualityTest(Object object, String fileName) throws IOException, IllegalAccessException {
        Class<?> objectClass = object.getClass();
        SoftAssert softAssert = new SoftAssert();
        Object testEmployee = json.readObject(fileName, objectClass);
        for(Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            softAssert.assertEquals(field.get(object), field.get(testEmployee), field.getName() + " attributes do not match");
        }
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] jsonDeserializedEqualityTestProvider() {
        return new Object[][]{{employee, "emp.json"}, {product, "prd.json"}};
    }

    @Test(dataProvider = "xmlDeserializedEqualityTestProvider")
    public void xmlDeserializedEqualityTest(Object object, String fileName) throws IOException, IllegalAccessException {
        Class<?> objectClass = object.getClass();
        SoftAssert softAssert = new SoftAssert();
        Object testEmployee = xml.readObject(fileName, objectClass);
        for(Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            softAssert.assertEquals(field.get(object), field.get(testEmployee), field.getName() + " attributes do not match");
        }
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] xmlDeserializedEqualityTestProvider() {
        return new Object[][]{{employee, "emp.xml"}, {product, "prd.xml"}};
    }

    @Test(dataProvider = "txtDeserializedEqualityTestProvider")
    public void txtDeserializedEqualityTest(Employee object, String fileName) throws IOException, IllegalAccessException {
        SoftAssert softAssert = new SoftAssert();
        Employee testEmployee = txt.readObject(fileName);
        for(Field field : Employee.class.getDeclaredFields()) {
            field.setAccessible(true);
            softAssert.assertEquals(field.get(object), field.get(testEmployee), field.getName() + " attributes do not match");
        }
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] txtDeserializedEqualityTestProvider() {
        return new Object[][]{{employee, "emp.txt"}};
    }

    @Test(dataProvider = "txtDeserializedListEqualsTestProvider")
    public void txtDeserializedListEqualsTest(String fileName, Employee... instances) throws IOException, IllegalAccessException {
        List<Employee> list = new ArrayList<>();
        for(Employee o : instances){
            list.add(o);
        }
        List<Employee> list2 = txt.readList(fileName);
        SoftAssert softAssert = new SoftAssert();
        assertEquals(list.size(), list2.size(), "size of lists do not match");
        for (int i = 0; i < list.size(); i++) {
            for(Field field : Employee.class.getDeclaredFields()) {
                field.setAccessible(true);
                softAssert.assertEquals(field.get(list.get(i)), field.get(list2.get(i)), field.getName() + " attributes do not match in employees #" + (i+1));
            }
        }
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] txtDeserializedListEqualsTestProvider() {
        return new Object[][]{{"list_emp.txt", employee, employee1, employee2}};
    }
}


