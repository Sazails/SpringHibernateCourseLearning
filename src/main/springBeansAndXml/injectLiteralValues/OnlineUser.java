package main.springBeansAndXml.injectLiteralValues;

import main.springBeansAndXml.beansBasics.IEntity;

public class OnlineUser implements IEntity {
    private String email = null;
    private String username = null;

    public OnlineUser(){}

    public OnlineUser(String email, String username){
        this.email = email;
        this.username = username;
    }

    public void updateUser(String email, String username){
        setEmail(email);
        setUsername(username);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void sayHello() {
        System.out.println(username + ": " + "hello");
    }

    @Override
    public String toString() {
        return "OnlineUser[" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ']';
    }
}
