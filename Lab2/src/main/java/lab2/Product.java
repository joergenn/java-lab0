package lab2;

public class Product {
    private int barcode;
    private String name;
    private double price;
    private String category;
    private Supplier supplier;

    /**
     * Product constructor
     */
    public Product(int barcode, String name, double price, String category, Supplier supplier){
        this.barcode= barcode;
        this.name = name;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
    }

    public Product(){
    }
    /**
     * Overrided toString method
     * @return string describing class entity
     */
    @Override
    public String toString(){
        return name + " | " + barcode + " | " + name + " | " + price + " | " + category + "\n" + supplier.toString();
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
