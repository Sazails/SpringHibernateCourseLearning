package main.springConfigWithAnnotations.beanScopeAndLifecycle.beanScopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Student {

}
