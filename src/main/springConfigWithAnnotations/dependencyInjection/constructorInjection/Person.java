package main.springConfigWithAnnotations.dependencyInjection.constructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person implements IPerson {

    private IEmotion emotion;

    // Dependency injection (constructor)
    @Autowired
    public Person(IEmotion theEmotion){
        emotion = theEmotion;
    }

    @Override
    public void say(String text) {
        System.out.println(text);
    }

    @Override
    public String getEmotion() {
        return emotion.getEmotion();
    }
}
