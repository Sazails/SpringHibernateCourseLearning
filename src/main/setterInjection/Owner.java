package main.setterInjection;

import main.dependencyInjection.CoffeeService;
import main.dependencyInjection.Entity;

public class Owner implements Entity {

    private CoffeeService coffeeService;

    public Owner(){}

    public void setCoffeeService(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Override
    public String getHello() {
        return "Owner: yo";
    }

    @Override
    public void getCoffeeTemperature() {
        System.out.println("Coffee temperature: " + coffeeService.getTemperature());
    }
}
