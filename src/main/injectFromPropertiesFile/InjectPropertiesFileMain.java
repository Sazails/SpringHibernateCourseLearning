package main.injectFromPropertiesFile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectPropertiesFileMain {
    public static void main(String[] args) {
        // load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from spring container
        // We user OnlineUser instead of Entity because it contains the get and set methods.
        DataPacket dataPacket = context.getBean("myDataPacket", DataPacket.class);

        // call methods on bean
        dataPacket.SendDataPacket("01100100 01110010 01100001 01101001 01101110");

        // close context
        context.close();
    }
}
