package main.springBeansAndXml.beanScopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopesMain {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/springBeansAndXml/beanScopes/applicationContext.xml");

        // Both objects should point to the same address (creates only one instance of the bean object)
        Human human = context.getBean("myHumanSingleton", Human.class);
        Human human2 = context.getBean("myHumanSingleton", Human.class);

        boolean isEqual = human == human2;
        System.out.println("Are humans equal: " + isEqual);
        System.out.println("Human memory location: " + human);
        System.out.println("Human2 memory location: " + human2);



        // Both objects should not point to the same address (creates new bean object every time)
        human = context.getBean("myHumanPrototype", Human.class);
        human2 = context.getBean("myHumanPrototype", Human.class);

        isEqual = human == human2;
        System.out.println("Are humans equal: " + isEqual);
        System.out.println("Human memory location: " + human);
        System.out.println("Human2 memory location: " + human2);

        context.close();
    }
}
