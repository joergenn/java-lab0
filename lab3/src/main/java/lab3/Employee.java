package lab3;

import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private String address;
    private String phoneNumber;
    private boolean isInsuranced;

    /**
     * Employee constructor
     * @param builder
     */
    private Employee(EmployeeBuilder builder){
        this.name = builder.name;
        this.salary = builder.salary;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.isInsuranced = builder.isInsuranced;
    }

    /**
     * Overrided toString method
     * @return string describing class entity
     */
    @Override
    public String toString(){
        return name + " | " + salary + " | " + address + " | " + phoneNumber + " | " + isInsuranced;
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
        Employee employee = (Employee) obj;
        return (employee.name.equals(this.name) &&
                employee.address.equals(this.address) &&
                employee.phoneNumber.equals(this.phoneNumber)
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
        hash = 7 * hash + Objects.hashCode(this.phoneNumber);
        return hash;
    }

    /**
     * Builder pattern
     */
    public static class EmployeeBuilder{
        /**
         * @param name is mandatory, others are optional
         */
        private String name;

        private double salary = 0.0;
        private String address = " ";
        private String phoneNumber = " ";
        private boolean isInsuranced = false;

        /**
         * Builder constructor with required parameters
         * @param name
         */
        public EmployeeBuilder(String name){
            this.name = name;
        }

        /**
         * Builder salary setter
         * @param salary
         * @return object
         */
        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        /**
         * Builder address setter
         * @param address
         * @return object
         */
        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Builder phoneNumber setter
         * @param phoneNumber
         * @return object
         */
        public EmployeeBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Builder isInsuranced setter
         * @param isInsuranced
         * @return object
         */
        public EmployeeBuilder setIsInsuranced(boolean isInsuranced) {
            this.isInsuranced = isInsuranced;
            return this;
        }

        /**
         * Builder build method
         * @return instance of Employee class
         */
        public Employee build(){
            return new Employee(this);
        }

    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * salary getter
     */
    public double getSalary(){
        return salary;
    }

    /**
     * address getter
     */
    public String getAddress(){
        return address;
    }

    /**
     * phoneNumber getter
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * isInsuranced getter
     */
    public boolean getIsInsuranced(){
        return isInsuranced;
    }

    /**
     * name setter
     */
    public void setName(String name) { this.name = name; }

    /**
     * salary setter
     */
    public void setSalary(double salary) { this.salary = salary; }

    /**
     * phoneNumber setter
     */
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    /**
     * address setter
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * isInsuranced setter
     */
    public void setIsInsuranced(boolean isInsuranced) { this.isInsuranced = isInsuranced; }
}