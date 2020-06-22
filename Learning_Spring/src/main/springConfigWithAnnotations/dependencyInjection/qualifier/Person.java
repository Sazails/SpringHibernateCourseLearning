package main.springConfigWithAnnotations.dependencyInjection.qualifier;

import main.springConfigWithAnnotations.dependencyInjection.qualifier.emotions.IEmotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person implements IPerson {

    @Autowired // Field injection (creates a setter for itself (uses reflection))
    @Qualifier("randomEmotion") // Sets the default if there are more than 1 of the shared components
    private IEmotion emotion;

    public Person() { }

//    When using a visible constructor this is how you use the @Qualifier
//    public Person(@Qualifier("randomEmotion")IEmotion theEmotion){
//        emotion = theEmotion;
//    }

    @Override
    public void say(String text) {
        System.out.println(text);
    }

    @Override
    public String getEmotion() {
        return emotion.getEmotion();
    }
}
