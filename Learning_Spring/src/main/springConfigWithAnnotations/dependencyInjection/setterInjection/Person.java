package main.springConfigWithAnnotations.dependencyInjection.setterInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person implements IPerson {

    private IEmotion emotion;

    public Person() { }

    // Dependency injection (setter)
    @Autowired
    public void setFortuneService(IEmotion theEmotion) { emotion = theEmotion; }

    // For dependency injection using @Autowired your method name can be whatever you want it to be
    // @Autowired
    // public void wobwobwob(IEmotion theEmotion) { emotion = theEmotion; }

    @Override
    public void say(String text) {
        System.out.println(text);
    }

    @Override
    public String getEmotion() {
        return emotion.getEmotion();
    }
}
