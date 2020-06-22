package main.springBeansAndXml.setterInjection;

import main.springBeansAndXml.dependencyInjection.ICoffeeService;

public class ColdCoffeeService implements ICoffeeService {
    private int randMax = 50;
    private int randMin = 0;

    @Override
    public int getTemperature() {
        return (int)(Math.random() * ((randMax - randMin) + 1)) + randMin;
    }
}
