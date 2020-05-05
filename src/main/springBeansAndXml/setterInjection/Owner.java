package main.springBeansAndXml.setterInjection;

import main.springBeansAndXml.dependencyInjection.ICoffeeService;
import main.springBeansAndXml.dependencyInjection.IEntity;

public class Owner implements IEntity {

    private ICoffeeService coffeeService;

    public Owner(){}

    public void setCoffeeService(ICoffeeService coffeeService) {
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
