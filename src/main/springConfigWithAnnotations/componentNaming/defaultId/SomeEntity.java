package main.springConfigWithAnnotations.componentNaming.defaultId;

import org.springframework.stereotype.Component;

@Component
public class SomeEntity implements IEntity {

    @Override
    public void test(){
        System.out.println("Testing");
    }
}
