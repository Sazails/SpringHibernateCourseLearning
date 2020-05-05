package main.springConfigWithAnnotations.dependencyInjection.qualifier.emotions;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomEmotion implements IEmotion{

    private final String[] emotions = {
            "Happy",
            "Sad",
            "Angry",
            "Confused",
            "Stupid"
    };

    private Random myRandom = new Random();

    @Override
    public String getEmotion() {
        int index = myRandom.nextInt(emotions.length);
        return emotions[index];
    }
}
