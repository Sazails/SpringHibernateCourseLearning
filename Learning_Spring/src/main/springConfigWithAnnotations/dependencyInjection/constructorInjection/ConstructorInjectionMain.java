package main.springConfigWithAnnotations.dependencyInjection.constructorInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/dependencyInjection/constructorInjection/applicationContext.xml");

        Person person = context.getBean("person", Person.class);

        person.say("Testing my speech!");
        System.out.println(person.getEmotion());

        context.close();
    }
}
