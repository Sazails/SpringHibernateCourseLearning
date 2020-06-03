package main.springConfigWithJavaCode.injectValuesFromPropertiesFile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Value("${email}")
    private String email;

    @Value("${name}")
    private String name;

    @Value("${role}")
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void sayHello(){
        System.out.println("Hello");
    }
}
