package lab2;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private String name;
    private double salary;
    private String address;
    private String phoneNumber;
    private boolean isInsuranced;

    /**
     * Employee constructor
     */
    public Employee(String name, double salary, String address, String phoneNumber, boolean isInsuranced){
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isInsuranced = isInsuranced;
    }

    public Employee(){

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
