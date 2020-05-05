package main.springBeansAndXml.beansBasics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanMain {
    public static void main(String[] args) {
        // load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springBeansAndXml/beansBasics/applicationContext.xml");

        // get bean from spring container
        IEntity theCharacter = context.getBean("myCharacter", IEntity.class);

        // call method on bean
        theCharacter.sayHello();

        // close context
        context.close();
    }
}
