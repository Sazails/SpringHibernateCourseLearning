package main.injectLiteralValues;

import main.beans.Entity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLiteralMain {
    public static void main(String[] args) {
        // load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/injectLiteralValues/applicationContext.xml");

        // get bean from spring container
        // We user OnlineUser instead of Entity because it contains the get and set methods.
        OnlineUser onlineUser = context.getBean("myOnlineUser", OnlineUser.class);

        // call methods on bean
        onlineUser.sayHello();
        System.out.println(onlineUser.toString());
        onlineUser.setEmail("testing@mail.org");
        onlineUser.setUsername("flatUser");
        onlineUser.sayHello();
        System.out.println(onlineUser.toString());

        // close context
        context.close();
    }
}
