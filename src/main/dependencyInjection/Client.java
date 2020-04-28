package main.dependencyInjection;

public class Client implements Entity {

    // No arg constructor to avoid compiler error as we already have a custom constructor.
    // Compiler can't generate a default constructor if an existing constructor already exists.
    public Client(){}

    // cache field for the dependency
    private CoffeeService coffeeService;

    // constructor for the dependency
    public Client(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }

    @Override
    public String getHello() {
        return "Client: Hello!";
    }

    @Override
    public void getCoffeeTemperature() {
        System.out.println("Coffee temperature: " + coffeeService.getTemperature());
    }
}
