package lab1;

import java.util.Objects;

public class Product {
    private final int barcode;
    private String name;
    private double price;
    private String category;
    private Supplier supplier;

    /**
     * Product constructor
     * @param builder
     */
    private Product(ProductBuilder builder){
        this.barcode= builder.barcode;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
        this.supplier = builder.supplier;
    }

    /**
     * Overrided toString method
     * @return string describing class entity
     */
    @Override
    public String toString(){
        return name + " | " + barcode + " | " + name + " | " + price + " | " + category + " | Supplier:\n" + supplier.toString();
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
        Product product = (Product) obj;
        return (product.barcode == this.barcode);
    }

    /**
     * Overrided hashCode method
     * @return hash
     */
    @Override
    public int hashCode(){
        return 31 * 7 + this.barcode;
    }

    /**
     * Builder pattern
     */
    public static class ProductBuilder{
        /**
         * params name, barcode are mandatory, others are optional
         */
        private final int barcode;
        private String name;

        private double price = 0.0;
        private String category = "NULL";
        private Supplier supplier = new Supplier.SupplierBuilder("none").build();

        /**
         * Builder constructor with required parameters
         * params name, barcode
         */
        public ProductBuilder(int barcode, String name){
            this.barcode= barcode;
            this.name = name;
        }

        /**
         * Builder price setter
         * @param price
         * @return object
         */
        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        /**
         * Builder category setter
         * @param category
         * @return object
         */
        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        /**
         * Builder supplier setter
         * @param supplier
         * @return object
         */
        public ProductBuilder setSupplier(Supplier supplier) {
            this.supplier = supplier;
            return this;
        }

        /**
         * Builder build method
         * @return instance of Employee class
         */
        public Product build(){
            return new Product(this);
        }

    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * price getter
     */
    public double getPrice(){
        return price;
    }

    /**
     * barcode getter
     */
    public int getBarcode(){
        return barcode;
    }

    /**
     * category getter
     */
    public String getCategory(){
        return category;
    }

    /**
     * supplier getter
     */
    public Supplier getSupplier(){
        return supplier;
    }

    /**
     * name setter
     */
    public void setName(String name) { this.name = name; }

    /**
     * category setter
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * price setter
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * supplier setter
     */
    public void setSupplier(Supplier supplier){
        this.supplier = supplier;
    }

}
