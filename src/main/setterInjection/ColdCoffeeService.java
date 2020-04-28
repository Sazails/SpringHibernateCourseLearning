package main.setterInjection;

import main.dependencyInjection.CoffeeService;

public class ColdCoffeeService implements CoffeeService {
    private int randMax = 50;
    private int randMin = 0;

    @Override
    public int getTemperature() {
        return (int)(Math.random() * ((randMax - randMin) + 1)) + randMin;
    }
}
