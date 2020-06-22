package main.springConfigWithJavaCode.springConfigJavaCodeNoXml;

import org.springframework.stereotype.Component;

@Component
public class Robot {

    private String name = "RoBoot";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
