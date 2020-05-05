package main.springConfigWithAnnotations.componentNaming.customId;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomComponentMain {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/componentNaming/customId/applicationContext.xml");

        // get bean from spring container
        IEntity entity = context.getBean("thisSomeEntity", IEntity.class);

        // call bean method
        entity.test();

        // close context
        context.close();
    }
}
