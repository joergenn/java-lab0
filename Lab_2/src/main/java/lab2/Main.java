package lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException {
        Employee employee = new Employee("Oleg", 2300.0, "Holovna, 195", "0990000000", true);
        Employee employee1 = new Employee("Oleg", 2301.0, "Holovna, 195", "0990000000", true);
        Employee employee2 = new Employee("Oleg", 2302.0, "Holovna, 195", "0990000000", true);
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        list.add(employee2);

        Supplier supplier = new Supplier("Supplier #1", "Universitetska, 20", employee);
        Product product = new Product(1, "Wiskas", 30.99, "Cat food", supplier);

        JsonSerializer json = new JsonSerializer();
        XmlSerializer xml = new XmlSerializer();
        TxtSerializer txt = new TxtSerializer();

        json.writeList(list, "list_emp.json");
        List<Employee> employeeJsonList = json.readList("list_emp.json", Employee.class);
        System.out.println(employeeJsonList);

        json.writeObject(employee, "emp.json");
        Employee employeeJson = (Employee) json.readObject("emp.json", Employee.class);
        System.out.println(employeeJson);
        xml.writeObject(employee, "emp.xml");
        Employee employeeXml = (Employee) xml.readObject("emp.xml", Employee.class);
        System.out.println(employeeXml);

        json.writeObject(supplier, "spl.json");
        Supplier supplierJson = (Supplier) json.readObject("spl.json", Supplier.class);
        System.out.println(supplierJson);
        xml.writeObject(supplier, "spl.xml");
        Supplier supplierXml = (Supplier) xml.readObject("spl.xml", Supplier.class);
        System.out.println(supplierXml);

        json.writeObject(product, "prd.json");
        Product productJson = (Product) json.readObject("prd.json", Product.class);
        System.out.println(productJson);
        xml.writeObject(product, "prd.xml");
        Product productXml = (Product) xml.readObject("prd.xml", Product.class);
        System.out.println(productXml);

        txt.writeObject(employee, "emp.txt");
        Employee employeeTxt = txt.readObject("emp.txt");
        System.out.println(employeeTxt);
        txt.writeList(list, "list_emp.txt");
        List<Employee> employeeTxtList = txt.readList("list_emp.txt");
        System.out.println(employeeTxtList);
    }
}
