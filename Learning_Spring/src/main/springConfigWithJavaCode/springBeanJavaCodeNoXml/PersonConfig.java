package main.springConfigWithJavaCode.springBeanJavaCodeNoXml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean // "happyPainting" is the bean id
    public IHobby hobbyPainting(){
        return new HobbyPainting();
    }

    @Bean
    public IPerson person(){
        return new Person(hobbyPainting()); // Run hobby into the constructor
    }
}
