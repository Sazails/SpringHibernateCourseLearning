package main.springConfigWithAnnotations.componentNaming.customId;

import org.springframework.stereotype.Component;

@Component("thisSomeEntity") // This is the spring way of creating a bean
public class SomeEntity implements IEntity {

    @Override
    public void test(){
        System.out.println("Testing");
    }
}
