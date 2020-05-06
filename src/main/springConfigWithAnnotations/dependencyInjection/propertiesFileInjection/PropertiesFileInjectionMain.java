package main.springConfigWithAnnotations.dependencyInjection.propertiesFileInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesFileInjectionMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/dependencyInjection/propertiesFileInjection/applicationContext.xml");

        Data data = context.getBean("data", Data.class);

        System.out.println("Email: " + data.getEmail());
        System.out.println("Username: " + data.getUsername());

        context.close();
    }
}
