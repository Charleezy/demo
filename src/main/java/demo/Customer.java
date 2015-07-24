package demo;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public long getID(){
        return this.id;
    }

    public void setFirstName(String nFirstName) {
        this.firstName = nFirstName;
    }

    public void setLastName(String nLastName) {
        this.lastName = nLastName;
    }

    public void setID(long nID){
        this.id = nID;
    }

}