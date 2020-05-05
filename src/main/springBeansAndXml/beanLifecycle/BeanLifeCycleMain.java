package main.springBeansAndXml.beanLifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMain {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springBeansAndXml/beanLifecycle/applicationContext.xml");

        // Load as entity as we will not call any methods here
        IEntity entity = context.getBean("human", IEntity.class);

        context.close();
    }
}
