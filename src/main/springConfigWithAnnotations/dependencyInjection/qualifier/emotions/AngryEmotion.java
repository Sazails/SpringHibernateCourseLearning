package main.springConfigWithAnnotations.dependencyInjection.qualifier.emotions;

import org.springframework.stereotype.Component;

@Component
public class AngryEmotion implements IEmotion {

    @Override
    public String getEmotion() {
        return "angry";
    }
}
