package main.springConfigWithJavaCode.injectValuesFromPropertiesFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:main/springConfigWithJavaCode/injectValuesFromPropertiesFile/user.properties")
public class UserConfig {

    @Bean
    public User user(){
        return new User();
    }
}
