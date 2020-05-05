package main.springConfigWithAnnotations.dependencyInjection.setterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/dependencyInjection/setterInjection/applicationContext.xml");

        Person person = context.getBean("person", Person.class);

        person.say("Testing my speech!");
        System.out.println(person.getEmotion());

        context.close();
    }
}
