package main.springBeansAndXml.dependencyInjection;

public class HotCoffeeService implements ICoffeeService {

    private int randMax = 80;
    private int randMin = 50;

    @Override
    public int getTemperature() {
        return (int)(Math.random() * ((randMax - randMin) + 1)) + randMin;
    }
}
