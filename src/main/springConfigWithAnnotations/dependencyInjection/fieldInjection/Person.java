package main.springConfigWithAnnotations.dependencyInjection.fieldInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person implements IPerson {

    // Field injection (creates a setter for itself (uses reflection))
    @Autowired
    private IEmotion emotion;

    public Person() { }

    @Override
    public void say(String text) {
        System.out.println(text);
    }

    @Override
    public String getEmotion() {
        return emotion.getEmotion();
    }
}
