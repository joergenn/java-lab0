package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Supplier implements Comparable<Supplier>{
    private String name;
    private String address;
    private Employee contactPerson;
    private List<Product> products;

    Supplier(){

    }

    /**
     * Supplier constructor
     * @param builder
     */
    private Supplier(SupplierBuilder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.contactPerson = builder.contactPerson;
        this.products = builder.products;
    }

    /**
     * Overrided toString method
     * @return string describing class entity
     */
    @Override
    public String toString(){
        return name + " | " + address + " | Contact person: \n" + contactPerson;
    }

    /**
     * Overrided equals method
     * @param obj
     * @return boolean value
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Supplier supplier = (Supplier) obj;
        return (supplier.name.equals(this.name) &&
                supplier.address.equals(this.address) &&
                supplier.contactPerson.equals(this.contactPerson)
        );
    }

    /**
     * Overrided hashCode method
     * @return hash
     */
    @Override
    public int hashCode(){
        int hash = 31;
        hash = 7 * hash + Objects.hashCode(this.name);
        hash = 7 * hash + Objects.hashCode(this.address);
        hash = 7 * hash + Objects.hashCode(this.contactPerson);
        return hash;
    }

    @Override
    public int compareTo(Supplier s) {
        return this.name.toLowerCase().compareTo(s.name.toLowerCase());
    }

    /**
     * Builder pattern
     */
    public static class SupplierBuilder{
        /**
         * @param name is mandatory, others are optional
         */
        private String name;

        private String address = "none";
        private Employee contactPerson = new Employee.EmployeeBuilder("none").build();
        private List<Product> products = new ArrayList<>();

        /**
         * Builder constructor with required parameters
         * @param name
         */
        public SupplierBuilder(String name){
            this.name = name;
        }

        /**
         * Builder contact person setter
         * @param contactPerson
         * @return object
         */
        public SupplierBuilder setContactPerson(Employee contactPerson) {
            this.contactPerson= contactPerson;
            return this;
        }

        /**
         * Builder address setter
         * @param address
         * @return object
         */
        public SupplierBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Builder products setter
         * @param products
         * @return object
         */
        public SupplierBuilder setProducts(List<Product> products){
            this.products.addAll(products);
            return this;
        }

        /**
         * Builder product setter
         * @param product
         * @return object
         */
        public SupplierBuilder setProduct(Product product){
            this.products.add(product);
            return this;
        }

        /**
         * Builder build method
         * @return instance of Supplier class
         */
        public Supplier build(){
            return new Supplier(this);
        }

    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * contactPerson getter
     */
    public Employee getContactPerson() { return contactPerson; }

    /**
     * address getter
     */
    public String getAddress() { return address; }

    /**
     * products getter
     */
    public List<Product> getProducts(){
        return products;
    }

    /**
     * name setter
     */
    public void setName(String name) { this.name = name; }

    /**
     * address setter
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * contactPerson setter
     */
    public void setContactPerson(Employee contactPerson) { this.contactPerson = contactPerson; }

    /**
     * product setter
     */
    public void setProducts(List<Product> products) { this.products = products; }

    public static List<Product> getProductsWithPriceLessThan(Supplier s, double price){
        return s.getProducts().stream()
                .filter(product -> product.getPrice() < price)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Product> getProductsWithPriceLessThanFor(Supplier s, double price){
        List<Product> products = new ArrayList<>();
        for(Product p : s.getProducts()){
            if (p.getPrice() < price) products.add(p);
        }
        Collections.sort(products);
        return products;
    }

    public static List<Product> getProductsWithQuantityLessThan(Supplier s, int quantity){
        return s.getProducts().stream()
                .filter(product -> product.getQuantity() < quantity)
                .sorted(new ProductComparator())
                .collect(Collectors.toList());
    }

    public static List<Product> getProductsWithQuantityLessThanFor(Supplier s, int quantity){
        List<Product> products = new ArrayList<>();
        for(Product p : s.getProducts()){
            if (p.getQuantity() <quantity) products.add(p);
        }
        Collections.sort(products, new ProductComparator());
        return products;
    }

    public static double getSumOfPricesIncreasedByRatio(Supplier s, double ratio){
        return s.getProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (total, price) -> total + price) * ratio;

    }

    public static double getSumOfPricesIncreasedByRatioFor(Supplier s, double ratio){
        double sumOfPrice = 0.0;
        for (Product p : s.getProducts()){
            sumOfPrice += p.getPrice();
        }
        return sumOfPrice *= ratio;
    }

    public static int getQuantityOfProductsMoreExpensiveThan(Supplier s, double price){
        return s.getProducts().stream()
                .filter(product -> product.getPrice() > price)
                .map(Product::getQuantity)
                .reduce(0, (total, quantity) -> total + quantity);
    }

    public static int getQuantityOfProductsMoreExpensiveThanFor(Supplier s, double price){
        int quantity = 0;
        for (Product p: s.getProducts()) {
            if(p.getPrice() > price){
                quantity += p.getQuantity();
            }
        }
        return quantity;
    }

    public static Product getProductByBarcode(Supplier s, int barcode){
        return s.getProducts().stream()
                .filter(product -> product.getBarcode() == barcode)
                .findFirst()
                .orElse(null);
    }

    public static Product getProductByBarcodeFor(Supplier s, int barcode){
        for(Product p : s.getProducts()){
            if(p.getBarcode() == barcode){
                return p;
            }
        }
        return null;
    }
    public static double getSumOfPrices(Supplier s){
        return s.getProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (total, price) -> total + price);
    }

    public static double getSumOfPricesFor(Supplier s){
        double sum = 0.0;
        for (Product p: s.getProducts()) {
            sum += p.getPrice();
        }
        return sum;
    }
}