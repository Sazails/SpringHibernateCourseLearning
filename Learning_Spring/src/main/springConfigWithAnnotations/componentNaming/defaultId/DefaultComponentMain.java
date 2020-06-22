package main.springConfigWithAnnotations.componentNaming.defaultId;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultComponentMain {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/componentNaming/defaultId/applicationContext.xml");

        // get bean from spring container
        // @Component with empty id field = class name with first letter lowercase, however the whole name will be the same if the class's first two letters are uppercase.
        IEntity entity = context.getBean("someEntity", IEntity.class);

        // call bean method
        entity.test();

        // close context
        context.close();
    }
}
