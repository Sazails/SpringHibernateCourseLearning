package main.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanMain {
    public static void main(String[] args) {
        // load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/beans/applicationContext.xml");

        // get bean from spring container
        Entity theCharacter = context.getBean("myCharacter", Entity.class);

        // call method on bean
        theCharacter.sayHello();

        // close context
        context.close();
    }
}
