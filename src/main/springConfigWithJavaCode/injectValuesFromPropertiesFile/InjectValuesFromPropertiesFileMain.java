package main.springConfigWithJavaCode.injectValuesFromPropertiesFile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectValuesFromPropertiesFileMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        User user = context.getBean("user", User.class);

        user.sayHello();

        System.out.print(
                "Role: " + user.getRole()
                + "\nName: " + user.getName()
                + "\nEmail: " + user.getEmail()
        );
    }
}
