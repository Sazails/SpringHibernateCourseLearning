package main.springConfigWithAnnotations.beanScopeAndLifecycle.beanScopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAnnotationScopeMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/beanScopeAndLifecycle/beanScopes/applicationContext.xml");

        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);

        StudentPrototype studentProto1 = context.getBean("studentPrototype", StudentPrototype.class);
        StudentPrototype studentProto2 = context.getBean("studentPrototype", StudentPrototype.class);

        System.out.println("Student1 and Student2 share the same memory: " + (student1 == student2));
        System.out.println("studentProto1 and studentProto2 share the same memory: " + (studentProto1 == studentProto2));

        context.close();
    }
}
