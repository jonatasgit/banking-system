package banking;

import java.util.Objects;

/**
 * The concrete Account holder of Person type.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int idNumber;

    public Person(String firstName, String lastName, int idNumber) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.idNumber = idNumber;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        return this.getIdNumber()== ((Person) obj).getIdNumber()
                && this.getFirstName() == ((Person) obj).getFirstName()
                && this.getLastName() == ((Person) obj).getLastName();
    }
}
