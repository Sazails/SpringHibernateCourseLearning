package main.setterInjection;

import main.dependencyInjection.Entity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSetterMain {
    public static void main(String[] args) {
// load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from spring container
        Entity theOwner = context.getBean("myCoffeeOwner", Entity.class);

        // call methods on bean
        System.out.println(theOwner.getHello());
        theOwner.getCoffeeTemperature();

        // close context
        context.close();
    }
}
