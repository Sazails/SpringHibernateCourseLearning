package main.springConfigWithAnnotations.beanScopeAndLifecycle.beanLifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAnnotationScopeMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/beanScopeAndLifecycle/beanLifecycle/applicationContext.xml");

        // Should run the start() and end() method
        BIGProgramUpdater updater = context.getBean("BIGProgramUpdater", BIGProgramUpdater.class);

        context.close();
    }
}
