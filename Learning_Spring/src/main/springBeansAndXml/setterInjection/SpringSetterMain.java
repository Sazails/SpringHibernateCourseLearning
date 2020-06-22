package main.springBeansAndXml.setterInjection;

import main.springBeansAndXml.dependencyInjection.IEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSetterMain {
    public static void main(String[] args) {
// load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springBeansAndXml/setterInjection/applicationContext.xml");

        // get bean from spring container
        IEntity theOwner = context.getBean("myCoffeeOwner", IEntity.class);

        // call methods on bean
        System.out.println(theOwner.getHello());
        theOwner.getCoffeeTemperature();

        // close context
        context.close();
    }
}
