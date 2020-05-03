package main.beanLifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMain {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/beanLifecycle/applicationContext.xml");

        // Load as entity as we will not call any methods here
        Entity entity = context.getBean("human", Entity.class);

        context.close();
    }
}
