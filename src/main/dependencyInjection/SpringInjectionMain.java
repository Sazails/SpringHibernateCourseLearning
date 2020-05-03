package main.dependencyInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInjectionMain {
    public static void main(String[] args) {
        // load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/dependencyInjection/applicationContext.xml");

        // get bean from spring container
        Entity theClient = context.getBean("myCoffeeClient", Entity.class);

        // call methods on bean
        System.out.println(theClient.getHello());
        theClient.getCoffeeTemperature();

        // close context
        context.close();
    }
}
