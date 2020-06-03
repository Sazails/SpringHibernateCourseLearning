package main.springConfigWithAnnotations.dependencyInjection.fieldInjection;

import org.springframework.stereotype.Component;

@Component
public class HappyEmotion implements IEmotion {

    @Override
    public String getEmotion() {
        return "happy";
    }
}
