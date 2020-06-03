package main.springConfigWithAnnotations.beanScopeAndLifecycle.beanLifecycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class BIGProgramUpdater {

    // init method
    @PostConstruct
    public void start(){
        System.out.println("Started");
    }

    // destroy method (if the component scope is a prototype then the @PreDestroy method will not be called, the client has to manage and remove the instantiated prototype beans manually)
    @PreDestroy
    public void end(){
        System.out.println("Ended");
    }
}
