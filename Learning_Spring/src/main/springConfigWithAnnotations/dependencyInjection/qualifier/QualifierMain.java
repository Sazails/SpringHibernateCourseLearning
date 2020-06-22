package main.springConfigWithAnnotations.dependencyInjection.qualifier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifierMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springConfigWithAnnotations/dependencyInjection/qualifier/applicationContext.xml");

        Person person = context.getBean("person", Person.class);

        person.say("Testing my speech!");
        System.out.println("Emotion: " + person.getEmotion());

        context.close();
    }
}
