package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class User {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String firstName;

    @NotEmpty
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
