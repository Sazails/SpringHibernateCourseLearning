package main.springMVC.Model;

import main.springMVC.Validation.UserTag;

import javax.validation.constraints.*;

public class Customer {

    @NotNull(message = "required")
    @Size(min = 2, max = 16, message = "required")
    private String firstName;

    @NotNull(message = "required")
    @Size(min = 2, max = 16, message = "required")
    private String lastName;

    @NotNull(message = "required")
    @Min(value = 14, message = "must be larger than or equal to 14")
    @Max(value = 100, message ="must be less or equal to 100")
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "5 digits or characters")
    private String postalCode;

    @UserTag(value = "ID_", message = "must start with ID_")
    private String customerTag;

    public String getCustomerTag() {
        return customerTag;
    }

    public void setCustomerTag(String customerTag) {
        this.customerTag = customerTag;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

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
