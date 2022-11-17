package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Supplier{
    private String name;
    private String address;
    private Employee contactPerson;

    /**
     * Supplier constructor
     */
    public Supplier(String name, String address, Employee contactPerson){
        this.name = name;
        this.address = address;
        this.contactPerson = contactPerson;
    }

    public Supplier(){

    }

    /**
     * Overrided toString method
     * @return string describing class entity
     */
    @Override
    public String toString(){
        return name + " | " + address + "\n" + contactPerson;
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

}
