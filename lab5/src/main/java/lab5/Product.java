package lab5;

public class Product implements Comparable<Product>{
    private final int barcode;
    private String name;
    private double price;
    private String category;
    private int quantity;

    /**
     * Product constructor
     * @param builder
     */
    private Product(ProductBuilder builder){
        this.barcode= builder.barcode;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
        this.quantity = builder.quantity;
    }

    /**
     * Overrided toString method
     * @return string describing class entity
     */
    @Override
    public String toString(){
        return barcode + " | " + name + " | " + quantity + " | " + price + " | " + category;
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

    @Override
    public int compareTo(Product p) {
        if(Math.abs(this.price - p.price) < 0.00001) return 0;
        else if(this.price > p.price) return 1;
        else return -1;
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
        private int quantity = 0;

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
         * Builder quantity setter
         * @param quantity
         * @return object
         */
        public ProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
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
     *  quantity getter
     */
    public int getQuantity(){
        return quantity;
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
     * quantity setter
     */
    public void setQuantity(int quantity) { this.quantity = quantity; }

}