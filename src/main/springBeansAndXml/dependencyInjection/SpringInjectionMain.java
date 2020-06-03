package main.springBeansAndXml.dependencyInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInjectionMain {
    public static void main(String[] args) {
        // load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springBeansAndXml/dependencyInjection/applicationContext.xml");

        // get bean from spring container
        IEntity theClient = context.getBean("myCoffeeClient", IEntity.class);

        // call methods on bean
        System.out.println(theClient.getHello());
        theClient.getCoffeeTemperature();

        // close context
        context.close();
    }
}
