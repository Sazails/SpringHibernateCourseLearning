package main.beanLifecycle;

public class Human implements Entity {
    private static final String somethingStr = "Wooga Booga Hooga Booga Ya!";
    private static final String goodbyeStr = "Goodbye!";

    private void saySomething() {
        System.out.println(somethingStr);
    }

    private void sayGoodbye() {
        System.out.println(goodbyeStr);
    }

    private void sayRealGoodbye() {
        System.out.println(goodbyeStr);
    }

    // init method (any name)
    @Override
    public void start(){
        saySomething();
    }

    // destroy method (any name) does not work on bean with scope "prototype" as their multiple instances have to be destroyed manually.
    @Override
    public void end(){
        System.out.println("REAL GOODBYE");
    }
}
