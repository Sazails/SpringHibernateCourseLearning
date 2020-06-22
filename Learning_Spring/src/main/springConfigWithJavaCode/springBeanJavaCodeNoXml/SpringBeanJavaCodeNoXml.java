package main.springConfigWithJavaCode.springBeanJavaCodeNoXml;

import main.springConfigWithJavaCode.springConfigJavaCodeNoXml.Robot;
import main.springConfigWithJavaCode.springConfigJavaCodeNoXml.RobotConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanJavaCodeNoXml {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);

        Person person = context.getBean("person", Person.class);

        person.sayHello();
        person.sayHobby();

        context.close();
    }
}
