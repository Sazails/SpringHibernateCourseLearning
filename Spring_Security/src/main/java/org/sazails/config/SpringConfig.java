package org.sazails.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sazails")
@PropertySource("classpath:persistence-mysql.properties")
public class SpringConfig {

    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource securityDataSource(){
        // Create connection
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // Set jdbc driver
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // Log connection
        logger.info("jdbc.url=" + environment.getProperty("jdbc.url"));
        logger.info("jdbc.user=" + environment.getProperty("jdbc.user"));

        // Set database connection
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        // Set connection pool
        securityDataSource.setInitialPoolSize(getPropertyAsInt("connection.pool.initialPoolSize"));
        securityDataSource.setMaxIdleTime(getPropertyAsInt("connection.pool.maxIdleTime"));
        securityDataSource.setMaxPoolSize(getPropertyAsInt("connection.pool.maxPoolSize"));
        securityDataSource.setMinPoolSize(getPropertyAsInt("connection.pool.minPoolSize"));

        return securityDataSource;
    }

    private int getPropertyAsInt(String propertyName){
        return Integer.parseInt(environment.getProperty(propertyName));
    }
}
