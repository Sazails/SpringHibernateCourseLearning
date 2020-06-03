package main.springConfigWithJavaCode.springConfigJavaCodeNoXml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigJavaCodeNoXml {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RobotConfig.class);

        Robot robot = context.getBean("robot", Robot.class);

        System.out.println("Name: " + robot.getName());

        context.close();
    }
}
